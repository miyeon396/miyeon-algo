package com.example.codete.section9Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class IsFriend_6 {
    // 친구 인가? (Disjint-Set : Union&Find) - 서로소집합
    // 오늘은 새학기 새로운 반에서 처음 시작하는 날. 반학생은 N명. 각 학생들의 친구 관계를 알고 싶다.
    // 모든 학생은 1부터 N까지 번호가 부여되어 있고, 현수에게는 각각 두명의 학생은 친구관계가 번호로 표현된 숫자 쌍이 주어짐.
    // 1,2 / 2,3 / 3,4  의 숫자 쌍이 주어지면 1번 학생과 2번 학생이 친구이고, 2번 학생-3 친구, 3-4 친구
    // 그리고 1번학생과 4번학생은 2,3을 통해 친구가 된다.
    // 학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두명이 친구인지 아닌지 판별하는 프로그램
    // 친구면 YES 아니면 NO

    // 입력 설졍
    // 첫 줄에 반 학생수 자연수 N(1<=N<=1000)과 숫자쌍의 개수인 M(1<=M<=3000)이 주어짐, 다음 M개의 줄에 걸쳐 숫자쌍이 주어짐
    // 마지막 줄에는 두학생이 친구인지 확인하는 숫자쌍이 주어짐

    // 출력 설명
    // YES OR NO

    // ex)
    // 9 7 / 1 2 / 2 3 / 3 4 / 1 5 / 6 7 / 7 8 / 8 9 / 3 8

    static int[] unf; // 인덱스 번호는 학생 번호 / 배열의 값은 집합 값?

    public static int Find(int v) {
        if(v==unf[v]) {
            return v;
        } else {
            return unf[v] = Find(unf[v]); //경로 압축
        }
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) {
        IsFriend_6 T = new IsFriend_6();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        unf = new int[n+1];

        for (int i=1; i<=n; i++) {
            unf[i] = i; //초기화
        }

        for (int i=1; i<=m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Union(a, b); //집합이 같으면 친구 관계로 만들어라
        }

        int a = scanner.nextInt();;
        int b = scanner.nextInt();;
        int fa = Find(a);
        int fb = Find(b);

        if(fa==fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }


}
