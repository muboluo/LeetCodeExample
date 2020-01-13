package jv.point;

class TestOverRide {

    static class Person {

        public void eat() {
            System.out.println("person eat");
        }

        public void speak() {
            System.out.println("person speak");
        }

    }

    static class Boy extends Person {

        @Override
        public void speak() {
            System.out.println("boy speak");
        }

        public void fight() {
            System.out.println("boy fight");
        }

    }

    static class Girl extends Person {

        @Override
        public void eat() {
            System.out.println("girl eat");
        }

        public void sing() {
            System.out.println("girl sing");
        }

    }

    public static void main(String[] args) {

        Person boy = new Boy();
        Person girl = new Girl();

        boy.eat();
        boy.speak();

        girl.eat();
        girl.speak();

    }

}

