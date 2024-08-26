package org.example;

import java.util.Scanner;

public class SumCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        try {
            int result = sum(n);
            System.out.println("The sum from 1 to " + n + " is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sum(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than or equal to 1");
        }
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }
}
