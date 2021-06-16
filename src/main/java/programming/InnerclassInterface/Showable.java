package programming.InnerclassInterface;

interface Showable {
    void show();

    // 声明嵌套接口
    interface Message {
        void msg();
    }
}

class TestNestedInterface1 implements Showable.Message {
    // 实现嵌套接口Message中的msg()方法
    @Override
    public void msg() {
        System.out.println("Hello nested interface");
    }

    public static void main(String[] args) {
        // 实例化TestNestedInterface1类，向上转型为Showable.Message接口类型
        TestNestedInterface1 message = new TestNestedInterface1();
        message.msg();
    }
}  