package com.example.codete.section2arr;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintBigNum_1 {
    public ArrayList<Integer> solution(int n, int[] arr) {
        //n개 정수 입력받아 자신의 바로 앞수보다 큰 수 출력
        //첫번쨰껀 무조건 출력
        // 6  8 4 5 6 9 2 -> 8 5 6 9
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i=1; i<n; i++) {
            if(arr[i] > arr[i-1]) answer.add(arr[i]);
        }

        return answer;
    }

    public static void main(String args[]) {
        PrintBigNum_1 T = new PrintBigNum_1();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        for(int x : T.solution(n, arr)) {
            System.out.println(x+ " ");
        }

    }
}
