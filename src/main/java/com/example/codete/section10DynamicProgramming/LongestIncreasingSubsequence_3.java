package com.example.codete.section10DynamicProgramming;

import java.util.Scanner;

public class LongestIncreasingSubsequence_3 {
    // 최대 부분 증가수열 (LIS)
    // N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는 (작은수에서 큰 수로)
    // 원소들의 집합을 찾는 프로그램 작성
    // 예를 들어 원소가 2 7 5 8 6 4 7 12 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2 5 6 7 12를 뽑아내어 길이가 최대 5인 최대 부분 증가수열을 만들 수 있다.

    // 입력설명
    // 첫째 줄은 입력되는 데이터의 수 N / 둘째 줄은 N개의 입력 데이터들이 주어진다.

    // 출력 설명
    // 첫번쨰 줄에 부분 증가 수열의 최대길이를 출력한다.

    // ex) 8 / 5 3 7 8 6 2 9 4 -> 4

    static int[] dy;
    public int solution(int[] arr) {
        int answer = 0;
        dy = new int[arr.length];
        dy[0] = 1;

        for (int i=1; i<arr.length; i++) {
            int max = 0;
            for (int j=i-1; j>=0; j--) {
                if(arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String args[]) {
        LongestIncreasingSubsequence_3 T = new LongestIncreasingSubsequence_3();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(arr));

    }
}
