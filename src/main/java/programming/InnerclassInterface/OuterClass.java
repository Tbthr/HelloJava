package programming.InnerclassInterface;

class OuterClass {
    private int data = 30;

    public void test() {
        System.out.println("我是外部类成员方法");
    }

    class MemberInnerClass {
        // 访问外部类的私有数据成员
        void getData() {
            System.out.println("data is " + data);
        }

        // 访问外部类的成员方法
        void getTest() {
            OuterClass.this.test();
            // test();
        }
    }

    public static void main(String[] args) {
        // 首先必须实例化外部类
        OuterClass obj = new OuterClass();
        // 接着通过外部类对象来创建内部类对象
        OuterClass.MemberInnerClass in = obj.new MemberInnerClass();
        in.getData();
        in.getTest();
    }
}