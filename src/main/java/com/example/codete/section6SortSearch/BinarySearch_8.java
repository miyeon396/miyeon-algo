package com.example.codete.section6SortSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_8 {

    // 임의의 N개의 숫자가 입력으로 주어짐.
    // N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면,
    // 이분 검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램
    // 단 중복 존재 안함

    // 입력 예시
    // 첫줄 자연수 N, M / 두번째 줄 N개의 수가 주어짐
    // ex) 8 32 / 23 87 65 12 57 32 99 81 -> 정렬을 해놓고 32를 찾아라 -> 3

    // 이분 검색 (binary Search) 좁혀나간다
    // 이분 검색은 정렬이 되어 있어야함. 앞에서부터 검색해가는건 순차 검색(O(n))
    // 이분 검색은 lt=0초기화 rt는 n-1 -> 중간 지점 mid = (lt + rt) / 2 찾아서 값 맞는지 비교.
    // 찾은 값이 더 크면 더 작은쪽에서 비교 큰쪽은 검색 범위에서 비교 -> rt값이 mid-1로 바뀜 -> 검색 범위가 절반으로 줄어듦
    // 반대로 내가 찾고자 하는 값이 미드가 가리키는 것 보다 크면 작은 쪽의 범위를 죽이고 lt가 mid+1이 되버림
    // 이런식으로 좁혀 나가는 것. 근데 좁혀나가다가 lt>rt면 볼 필요도 없이 끝


  public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt=0;
        int rt = n-1;

        while (lt<=rt) {
            int mid = (lt+rt) / 2;
            if (arr[mid] == m) {
                answer = mid+1;
                break;
            }
            if (arr[mid] > m) {
                rt = mid-1; // 큰쪽은 탐색 범위에서 제외해버림
            } else {
                lt = mid+1; // 작은쪽은 탐색 범위에서 제외해버림
            }
        }
        return answer;
    }

    public static void main(String args[]) {
        BinarySearch_8 T = new BinarySearch_8();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, m, arr));

    }
}
