package com.example.codete.book.ch3;

import java.util.Scanner;

public class P11720_숫자의합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String sNum = sc.next();
        char[] charArr = sNum.toCharArray();

        int sum = 0;
        for (char c : charArr) {
            sum+= Character.getNumericValue(c);
        }
        System.out.println(sum);

    }
}
