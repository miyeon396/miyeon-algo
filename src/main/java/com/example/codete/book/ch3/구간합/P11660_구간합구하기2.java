package com.example.codete.book.ch3.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11660_구간합구하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int arraySize = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());

        System.out.println("arraySize = " + arraySize);
        System.out.println("quizNo = " + quizNo);

        //1. 원본 배열 저장
        int A[][] = new int[arraySize+1][arraySize+1];
        for (int i=1; i<=arraySize; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j=1; j<=arraySize; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.stream(A).forEach(ints -> System.out.println(Arrays.toString(ints)));

        //2. 합배열 저장
        int D[][] = new int[arraySize+1][arraySize+1];
        for (int i=1; i<=arraySize; i++) {
            for (int j=1; j<=arraySize; j++) {
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
            }
        }

        // 3. 구간합 구하기 (퀴즈 개수만큼)
        for (int i=0; i<quizNo; i++) {
            st = new StringTokenizer(bufferedReader.readLine()); // 새로 또 입력
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            System.out.println("result = " + result);
        }

    }
}
