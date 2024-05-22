class RecursionFactorial {
    public static void main(String[] args) {
        int n = 5;
        int factorial = factorial(n);
        System.out.println("Factorial of " + n + " is " + factorial);
    }

    private static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}