package programming.classLoad;

public class InstanceVariableInitializer {
    private int i = 1;
    private int j = i + 1;

    public InstanceVariableInitializer(int var) {
        System.out.println(i);
        System.out.println(j);
        this.i = var;
        System.out.println(i);
        System.out.println(j);
    }

    {               // 实例代码块
        j += 3;
    }

    public static void main(String[] args) {
        new InstanceVariableInitializer(8);
    }
}

/* 
Output: 
         1
         5
         8
         5
*/