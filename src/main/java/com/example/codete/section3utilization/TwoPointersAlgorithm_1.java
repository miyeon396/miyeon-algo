package com.example.codete.section3utilization;

import java.util.ArrayList;
import java.util.Scanner;

public class TwoPointersAlgorithm_1 {
    // 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력
    // 첫 배열 크기 / 첫 배열 원소 n 개 / 두 배열 크기 / 두 배열 원소
    // 누구나 다하는걸로 하지말고 효율적으로 짤 수 있냐..
    // 퀵정렬 o(nlogn) -> o(n)으로 짜라는 것...
    // 첫배열과 두번째 배열은 정렬된 상태에서 들어 온 것.
    // 작은 쪽을 arr에 넣으란 것 남은 쪽은 걍 넣음 됨.
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while(p1 < n && p2 < m) { //p1이 됫건 p2가 됫건 하나라도 멈추면 걍 끝내고 쭉 적음됨
            if(a[p1] < b[p2]) answer.add(a[p1++]); //p1에 있는 값 넣고 그 뒤에 증가가 됨 후위증감 연산자 (++p1은 증가 하고 증가된 값을 넣음 전위증감)
            else answer.add(b[p2++]);
        }
        while(p1<n) answer.add(a[p1++]);
        while(p2<m) answer.add(b[p2++]);

        return answer;
    }

    public static void main(String[] args) {
        TwoPointersAlgorithm_1 T = new TwoPointersAlgorithm_1();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for(int i=0; i<m; i++){
            b[i] = scanner.nextInt();
        }
        for(int x : T.solution(n,m,a,b)) System.out.println(x + " ");
    }
}
