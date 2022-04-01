package programming.classLoad.hot_deploy;

import java.io.File;
import java.lang.reflect.Method;

public class HotDeployDemo {

    private static final String CLASS_NAME = "programming.classLoad.hot_deploy.HelloImpl";

    private static final String CLASS_PATH = "D:/Java/JavaProjects/HelloJava/target/classes/"
            + CLASS_NAME.replaceAll("\\.", "/") + ".class";

    private static volatile Object helloService;

    public static Object getHelloService() {
        if (helloService != null) {
            return helloService;
        }
        synchronized (HotDeployDemo.class) {
            if (helloService == null) {
                helloService = createHelloService();
            }
            return helloService;
        }
    }

    private static Object createHelloService() {
        try {
            MyClassLoader cl = new MyClassLoader(null);
            Class<?> cls = cl.loadClass(CLASS_NAME);
            if (cls != null) {
                return cls.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void client() {
        new Thread(() -> {
            try {
                while (true) {
                    Object helloService = getHelloService();
                    System.out.println("helloService.ClassLoader = " + helloService.getClass().getClassLoader());
                    Method sayHello = helloService.getClass().getMethod("sayHello");
                    sayHello.invoke(helloService);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void monitor() {
        new Thread() {
            private long lastModified = new File(CLASS_PATH).lastModified();

            @Override
            public void run() {
                try {
                    while (true) {
                        long now = new File(CLASS_PATH).lastModified();
                        if (now != lastModified) {
                            lastModified = now;
                            reloadHelloService();
                        }
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void reloadHelloService() {
        helloService = createHelloService();
    }

    public static void main(String[] args) {
        monitor();
        client();
    }
}