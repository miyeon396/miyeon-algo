package com.example.codete.book.ch3.스택큐;

import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N개
        int A[] = new int[N]; //수열 N개 배열

        //배열 채우기
        for (int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();

        int num = 1; //오름차순 수 1부터 쭉 오름차순으로 넣을 것임
        boolean result = true;

        for (int i=0; i<A.length; i++) {
            int su = A[i]; //현재 수열의 수
            if (su >= num) { //현재 수열 값 >= 오름차순 자연수 : 값이 같아질때까지 push() 수행
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                //똑같아지면
                stack.pop();
                bf.append("-\n");
            } else { //현재 수열 값 < 오름차순 자연수 : pop()을 수행해 수열 원소를 꺼냄
                int n = stack.pop();

                if ( n > su ) { //현재 수열의 값이 스텍에 있는 마지막 값보다 크다 -> 절대 완성되지 못한다.
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) {
            System.out.println(bf.toString());
        }
    }
}
