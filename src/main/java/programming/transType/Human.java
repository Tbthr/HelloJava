package programming.transType;

public class Human {
    String name = "Human";

    public String getName() {
        return this.name;
    }

    public void sleep() {
        System.out.println("Human sleep..");
    }

    public static void main(String[] args) {
        Human human = new Male();
        human.sleep();
        System.out.println(human.getName());
    }
}

class Male extends Human {
    String name = "Male";

     public String getName() {
         return this.name;
     }

    @Override
    public void sleep() {
        System.out.println("Male sleep..");
    }

    public void speak() {
        System.out.println("I am Male");
    }
}

class Female extends Human {
    String name = "Female";

    public String getName() {
        return this.name;
    }

    @Override
    public void sleep() {
        System.out.println("Female sleep..");
    }

    public void speak() {
        System.out.println("I am Female");
    }
}