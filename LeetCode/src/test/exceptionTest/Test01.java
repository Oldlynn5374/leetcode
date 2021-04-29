package test.exceptionTest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Test01 {
    public static void main(String[] args)   {
        System.out.println("begin");
        int i = 1/ 0;
        System.out.println("end");
        

    }
}
class Annoyance extends Exception {
}
class Sneeze extends Annoyance {
}
class Human {
    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            } catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        } finally {
            System.out.println("Hello World!");
        }

    }
}