package recursiveFunction;

import java.io.IOException;

public class Factorial {

//    public Integer factorial(int n) {
//
//        if (n > 1) {
//            return n * factorial(n - 1);
//        } else {
//            return 1;
//        }
//
//    }
    public Integer factorial(int n) {

        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }

    }

    public static void main(String[] args) {
        Factorial fFunc = new Factorial();
        System.out.println(fFunc.factorial(5));
    }

}
