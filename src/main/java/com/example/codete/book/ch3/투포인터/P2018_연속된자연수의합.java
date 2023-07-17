package com.example.codete.book.ch3.투포인터;

import java.util.Scanner;

public class P2018_연속된자연수의합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1; // 마지막 자기자신은 더해주고 시작함.
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while (end_index != N) {
            if (sum==N) {
                count++;
                end_index++;
                sum = sum+end_index;
            } else if (sum > N) {
                sum = sum - start_index;
                start_index++;
            } else if (sum < N) {
                end_index++;
                sum = sum + end_index;
            }
        }

        System.out.println(count);
    }
}
