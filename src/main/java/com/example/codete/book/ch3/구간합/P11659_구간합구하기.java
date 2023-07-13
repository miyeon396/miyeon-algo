package com.example.codete.book.ch3.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11659_구간합구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println("suNo = " + suNo);
        System.out.println("quizNo = " + quizNo);

        long[] S = new long[suNo+1];
        stringTokenizer = new StringTokenizer(br.readLine());
        System.out.println("stringTokenizer = " + stringTokenizer);

        for (int i=1; i<=suNo; i++) {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken()); //합 배열 구해서 저장 S[i] = S[i-1] + A[i]
        }
        Arrays.stream(S).forEach(System.out::println);

        for (int q=0; q<quizNo; q++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println("start = " + start);
            System.out.println("end = " + end);
            System.out.println(S[end] - S[start - 1]); //실제 구간합 S[j] - S[i-1]

        }


    }
}
