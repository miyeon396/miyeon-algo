package com.example.codete.section6SortSearch;

import java.util.Scanner;

public class InsertionSorting_3 {

    // N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램
    // 정렬 방법은 삽입 정렬
    // 입력 예시 -> 6 / 13 5 11 7 23 15 -> 5 7 11 13 15 23

    // 삽입 정렬 하는 법
    // arr이라는 배열에 입력을 해놓고 ij 이중 포문인데
    // i는 1부터 돔. j는 i-1부터 0까지 돔. (i for 문 안에서)
    // tmp에 arr[i]값 넣어놓고 arr[j]와 tmp와 값 체크해서  arr[j] > tmp 면 arr[j+1]에 arr[j]를 넣고
    // j포문이 멈춘 바로 뒤에 tmp를 넣는다??
    // 오름차순으로 정렬이됨.


    public int[] solution(int n, int[] arr) {
        for(int i=1; i<n; i++) {
            int tmp = arr[i];
            int j;
            for(j=i-1; j>=0; j--) {
                if(arr[j] > tmp) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }

        return arr;
    }

    public static void main(String args[]) {
        InsertionSorting_3 T = new InsertionSorting_3();
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
