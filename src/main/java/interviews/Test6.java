package interviews;

class Base {

    public static void display() {
        System.out.println("display method from Base");
    }

    public void print() {
        System.out.println("print method from Base");
    }
}

class Derived extends Base {

    public static void display() {
        System.out.println("display method from Derived");
    }

    public void print() {
        System.out.println("print method from Derived");
    }
}

public class Test6 {

    public static class Bike {
        private String model;
        private int cost;

        public Bike(String model, int cost) {
            this.model = model;
            this.cost = cost;
        }

        public int getCost() {
            return this.cost;
        }
    }

//    public static int foo() {
//        return 10;
//    }
//
//    public char foo() {
//        return 'a';
//    }

    public static void main(String... args) {
        Base obj1 = new Base();
        obj1.print();
    }

}
