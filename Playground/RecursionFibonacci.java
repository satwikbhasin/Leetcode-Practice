import java.util.Arrays;

public class RecursionFibonacci {
    public static void main(String[] args) {
        int n = 50;

        System.out.println("Without Memoization:");

        long startTime = System.nanoTime();
        long fibonacci = fibonacci(n);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000_000.0;

        System.out.println("Fibonacci of " + n + " = " + fibonacci);
        System.out.println("Execution time in seconds: " + String.format("%.2f", duration));

        System.out.println("\n\nWith Memoization:");

        long[] memoizationTable = new long[n + 1];
        Arrays.fill(memoizationTable, -1);
        startTime = System.nanoTime();
        fibonacci = fibonacciMemoization(n, memoizationTable);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000_000.0;

        System.out.println("Fibonacci of " + n + " = " + fibonacci);
        System.out.println("Execution time in seconds [with memoization]: " + String.format("%.2f", duration));
    }

    private static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static long fibonacciMemoization(int n, long[] memoizationTable) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memoizationTable[n] != -1) return memoizationTable[n];
        memoizationTable[n] = fibonacciMemoization(n - 1, memoizationTable) + fibonacciMemoization(n - 2, memoizationTable);
        return memoizationTable[n];
    }
}
