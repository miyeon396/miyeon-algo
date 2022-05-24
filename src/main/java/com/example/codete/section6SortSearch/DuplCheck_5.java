package com.example.codete.section6SortSearch;

import java.util.Arrays;
import java.util.Scanner;

public class DuplCheck_5 {

    // N명의 학생
    // 1부터 10000000까지 자연수중 좋아하는거 적어서 내라
    // N명의 학생이 적어낸 숫자 중 중복이 존재하면 D 출력, N명이 다 다른거 썼으면 U 출력

    // 정렬에서도 이런거 사용할 수 있다. 정렬 - nlogn -> 해쉬맵보단 성능이 떨어짐
    // 예시 8 / 20 25 52 30 39 33 43 33
    // 정렬 함 해놓고 옆에 같은 숫자가 있으면 중복 됬다 하고 리턴.


   public String solution(int n, int[] arr) {
       String answer = "U";
       Arrays.sort(arr); //오름 차순 간단 정렬

       for(int i=0; i<n-1; i++) {
           if(arr[i] == arr[i+1]) return "D";
       }

        return answer;
    }

    public static void main(String args[]) {
        DuplCheck_5 T = new DuplCheck_5();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
