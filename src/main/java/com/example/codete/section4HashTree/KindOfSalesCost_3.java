package com.example.codete.section4HashTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class KindOfSalesCost_3 {
    // N일 동안 매출기록 주고, 연속된 K일 동안 매출액의 종류 각 구간별 구하기
    // ex) N = 7 / 매출기록 = 20 12 20 10 23 17 10 / K = 4 -> 첫구간 21 12 20 10 -> 3 두구간 12 20 10 23 -> 4 세구간 20 10 23 17 -> 4 네구간 10 23 17 10 -> 3
    // -> 3443
    // lt = 0 rt=3 (k=4이므로(k-1)) 맵에 넣으면서 카운트치고 키의 개수 answer에 넣어주는 방법
    // 2pointer + sliding window
    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        //1. hm에 첫번째그룹 넣어주기
        for(int i=0; i<k-1; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }
        //2. 2pointer algorithm 시작
        int lt = 0;
        for(int rt = k-1; rt<n; rt++) {
            hm.put(arr[rt], hm.getOrDefault(arr[rt], 0)+1);
            answer.add(hm.size());
            hm.put(arr[lt], hm.get(arr[lt])-1);
            if(hm.get(arr[lt])==0) hm.remove(arr[lt]); //맵의 사이즈로 체크하기 떄문에 값이 없다면 삭제
            lt++;
        }

        return answer;
    }

    public static void main(String args[]) {
        KindOfSalesCost_3 T = new KindOfSalesCost_3();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        for(int x : T.solution(n,k,arr)) System.out.println(x+" ");

    }
}
