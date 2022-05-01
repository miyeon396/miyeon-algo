package com.example.codete.section4HashTree;

import java.util.*;

public class BigNumOfK_5 {
    // 1부터 100사이 자연수 N개. 같은 숫자도 있음. 3장 뽑아 적힌 수 합한 값 기록. K 번째 큰 수 구하라
    // 중복은 무시되네 ex) 25 25 23 23 22 20 19... k=3 -> 22
    // 예제 10 3 / 13 15 34 23 45 65 33 11 26 42 -> 143
    // 중복제거 Set라는 자료구조 + 정렬까지 되는 TreeSet(오름 차순 Or 내림 차순, 이진트리)
    public int solution(int[] arr, int n, int k) {
        int answer = -1;
        TreeSet<Integer> numSet = new TreeSet<>(Collections.reverseOrder()); //없으면 오름차순 넣으면 내림차순

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int l = j+1; l<n; l++) {
                    numSet.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        int cnt = 0;
        for(int x: numSet) {
            cnt++;
            if(cnt == k) return x;

        }

        //set 메서드 예제
//        numSet.remove(143);
//        numSet.size();
//        numSet.first(); // 오름차순 최소값, 내림차순 최대값
//        numSet.last(); // 오름차순 최대값, 내림차순 최소값

        return answer;
    }

    public static void main(String args[]) {
        BigNumOfK_5 T = new BigNumOfK_5();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(T.solution(arr, n, k));

    }
}
