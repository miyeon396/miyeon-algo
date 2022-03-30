package com.example.codete.section2arr;

import java.util.Scanner;

public class Fibonacci_4 {
    // 숫자 입력 시 숫자만큼의 피보나치 출력
    public int[] solution(int n) {
        int[] answer = new int[n];

        //1. 배열 사용 경우
        answer[0] = 1;
        answer[1] = 1;

        for(int i=2; i<n; i++) {
            answer[i] = answer[i-2]+answer[i-1];
        }

        //2. 배열 쓰지 말기
        int a=1, b=1, c;
        System.out.print("case2 = "+a+ " "+b+" ");
        for(int i=2; i<n; i++) {
            c = a+b;
            System.out.println(c+" ");
            a = b;
            b = c;
        }

        return answer;
    }

    public static void main(String args[]) {
        Fibonacci_4 T = new Fibonacci_4();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int x : T.solution(n)) System.out.print(x+ " ");

    }
}
