package pl.jvsystem.workpreparation;

/**
 * @author Przemek Nowak [przemek.nowak.pl@gmail.com]
 */
public class Example {

    public static void main(String[] args) {
//        Example e = new Example();
//        String a = "World"; String b = "Hello";
//        e.swap(a, b);
//        System.out.println(a + " "+ b);

        String s = new String("Hello");
        String s2 = new String("Hello");

        if (s == s2) {
            System.out.println("1");
        }
        if (s.equals(s2)) {
            System.out.println("2");
        }

    }

    void swap(String s1, String s2) {
        String tmp = s1;
        s2 = s1;
        s1 = tmp;
    }

}

class X {
    void a() throws NullPointerException {
        System.out.println("xa");
    }
}

class Y extends X {
    @Override
    void a() throws RuntimeException {
        System.out.println("ya");
    }
}
