package jv.sword;

public class Test {

    public static void testBytePlus() {

        byte a = 127;
        byte b = 127;

        a += b;
        System.out.println(getType(a) + a);
//        a = a + b;
        a = (byte) (a + b);
        System.out.println(getType(a) + a);

    }

    public static String getType(Object o) {
        return o.getClass().toString();
    }

    public static void main(String[] args) {

        testBytePlus();
    }
}
