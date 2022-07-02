package com.example.codete.section8DFSBFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CoinChange_5 {
    // 동전 교환
    // 여러 단위의 동전들이 주어져 있을 때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
    // 각 단위의 동전은 무한정 쓸 수 있다.

    // 입력 설명
    // 첫 줄에는 동전의 종류 개수 N(1<=N<=12), 두번째 줄에는 N개의 동전의 종류
    // 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어짐
    // 각 동전의 종류는 100원을 넘지 않는다.
    // 첫 줄에 거슬러 줄 동전의 최소 개수 출력

    // ex) 3 / 1 2 5 / 15 -> 3(5 5 5 3개로 줄 수 있다.)
    // -> DFS로 풀 것. D(L,SUM) (동전의 개수, L개의동전으로만든총합)
    // 중복순열과 비슷함 D(0,0)부터 뻗어 나감 1 2 5 (index 번호로 0 1 2) 뻗어 나가다가 Sum이 금액(M)과 맞으면 그떄의 최대 개수 또한 Sum이 L보다 커지면 리턴
    // 사진




    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum, Integer[] arr) {
        if (sum > m) {
            return;
        }
        if (L>=answer) {
            return;
        }

        if (sum == m) { //sum이 거슬러 줄 금액이 되었을 때
            answer = Math.min(answer, L); //L이 sum을 만들어내는 동전의 개수
        } else { //아니라면 뻗어 나가야겠죠
            for(int i=0; i<n; i++) {
                DFS(L+1, sum+arr[i], arr);
            }
        }

    }

    public static void main(String[] args) {
        CoinChange_5 T = new CoinChange_5();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = scanner.nextInt();
        T.DFS(0,0,arr);
        System.out.println(answer);
    }

}
