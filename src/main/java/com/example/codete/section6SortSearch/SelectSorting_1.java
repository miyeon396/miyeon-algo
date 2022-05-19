package com.example.codete.section6SortSearch;

import java.util.Scanner;

public class SelectSorting_1 {

    // N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램
    // 정렬 방법은 선택 정렬
    // 입력 예시 -> 6 / 13 5 11 7 23 15 -> 5 7 11 13 15 23

    // 선택졍렬은 arr이란 배열에 넣고 2중 포문 -> i가 0일때 j 돌면서 젤 작은 숫자 찾아내야함.
    // index 번호가 하나 필요 i를 일단 넣어놓고 젤 작은 것의 인덱스 위치 넣어둠.
    // 그러고 첫 한바퀴 돌고 젤 작은게 나오면 i와 swap 해줌.

    public int[] solution(int n, int[] arr) {

        for(int i=0; i<n-1; i++) {
            int idx=i;
            for(int j=i+1; j<n; j++) {
                if(arr[j] < arr[idx]) {
                    idx = j;
                }
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
            }
        }

        return arr;
    }

    public static void main(String args[]) {
        SelectSorting_1 T = new SelectSorting_1();
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
