package programming.InnerclassInterface;

public class localInner2 {

    private int data = 30;//实例变量

    void display() {
        int value = 50;//在 Jdk1.7 之前局部变量必须被声明为'final'

        class Local {
            void msg() {
                System.out.println("value: " + value); // 1
            }
        }

        Local l = new Local();
        l.msg();
//        value++; // 加上这句，1处报错：Variable 'value' is accessed from within inner class, needs to be final or effectively final
    }

    public static void main(String[] args) {
        localInner2 obj = new localInner2();
        obj.display();
    }
}