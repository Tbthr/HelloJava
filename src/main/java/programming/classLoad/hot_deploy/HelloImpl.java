package programming.classLoad.hot_deploy;

public class HelloImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
