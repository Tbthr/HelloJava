package programming.abstractTest;

public class Abstract {
    Abstract(){
        System.out.println("我是抽象类");
    }

    void ttt(){
        System.out.println("tttt");
    }

    public static void main(String[] args) {
        t1 t1 = new t1();
        t1.ttt();

    }
}
abstract class t extends Abstract {
    private String name;
    protected abstract void eat(int a);
    t(){
        System.out.println("programming.abstractTest.t");
    }
}
class t1 extends t{
    @Override
    protected void eat(int a) {

    }

    t1(){
        System.out.println("programming.abstractTest.t1");
    }
}