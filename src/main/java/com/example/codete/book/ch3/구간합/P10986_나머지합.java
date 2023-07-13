package com.example.codete.book.ch3.구간합;

import java.util.Scanner;

public class P10986_나머지합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 항목 개수
        int M = sc.nextInt(); //나누어 떨어질 수
        long S[] = new long[N];
        long C[] = new long[M]; //나머지 개수 저장할 배열
        long result = 0;
        S[0] = sc.nextInt();
        for (int i=1; i<N; i++) {
            S[i] = S[i-1] + sc.nextInt();
        }

        //합배열의 모든 값에 %연산 수행
        for (int i=0; i<N; i++) {
            int remainder = (int) (S[i] % M);
            if (remainder == 0) {
                result++;
            }
            C[remainder]++;
        }

        for (int i=0; i<M; i++) {
            if (C[i] > 1) { //2개 뽑는거니
                result = result + (C[i] * (C[i]-1) / 2) ;
            }

        }
        System.out.println("result = " + result);
    }
}
