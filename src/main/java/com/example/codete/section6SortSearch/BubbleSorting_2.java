package com.example.codete.section6SortSearch;

import java.util.Scanner;

public class BubbleSorting_2 {

    // N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램
    // 정렬 방법은 버블 정렬
    // 입력 예시 -> 6 / 13 5 11 7 23 15 -> 5 7 11 13 15 23

    // 버블정렬이란 arr하나 받아놔서 앞뒤 비교해서 더 작으면 위치 바꿔주는 것.
    // 버블버블버블버블~ 한번하고나면 젤 큰 숫자가 젤 뒤로감. 한번의 턴을 통해서 맨 큰 수자를 구하고 다음턴.
    // 다음턴 비교하되, 비교 총 횟수가 하나씩 줄어드는 것. 그럼 그 다음 큰 수 골라냄.
    // -> 비교 횟수가 하나씩 줄어들면서 정렬을 진행하는 것.

    public int[] solution(int n, int[] arr) {

        for(int i=0; i<n-1; i++) { //i는 턴의 횟수.
            for(int j=0; j<n-i-1; j++) { //j는 하나씩 적게 돔.
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }

        }

        return arr;
    }

    public static void main(String args[]) {
        BubbleSorting_2 T = new BubbleSorting_2();
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
