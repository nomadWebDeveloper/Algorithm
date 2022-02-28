package dp;

public class FibonacciNumbers {
    public Integer fibonacci(Integer n) {
//        if (n == 0) return 0;
//        else if (n == 1) return 1;
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        FibonacciNumbers func = new FibonacciNumbers();
        System.out.println(func.fibonacci(0));
        System.out.println(func.fibonacci(1));
        System.out.println(func.fibonacci(2));
        System.out.println(func.fibonacci(3));
        System.out.println(func.fibonacci(4));
    }
}
