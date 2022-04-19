package com.example.codete.section3utilization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GetSameAtom_2 {
    // A, B 두개의 집합이 주어지면 두 집합의 공통원소를 추출하여 오름차순으로 출력하는 프로그램. -> 교집합
    // 중복되진 않음.
    // ex) 크기 / N 개 / 크기 / M 개 -> 5 / 1 3 9 5 2 / 5 / 3 2 5 7 8 -> 2 3 5

    // a배열에 오름차순정렬 시키기. b배열에 오름차순 정렬 시키기 -> 비교 a[p1] b[p2] 같을 때 넣고 작을 떄 작은 곳을 증가 시키기
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a); //오름차순 자동 정렬
        Arrays.sort(b);

        int p1 = 0;
        int p2 = 0;
        while(p1<n && p2<m) {
            if(a[p1] == b[p2]) {
                answer.add(a[p1++]);
                p2++;
            } else if(a[p1]<b[p2]) p1++; //작은 쪽을 증가 시켜라
            else p2++;
        }

        return answer;
    }

    public static void main(String args[]) {
        GetSameAtom_2 T = new GetSameAtom_2();
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
