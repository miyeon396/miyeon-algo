package com.example.codete.section8DFSBFS;

import java.util.Scanner;

public class GetMaxScore_3 {
    // 최대 점수 구하기 (DFS)
    // 좋은 성적 내기 위해 현수는 선생님이 내준 N개의 문제를 풀려고함.
    // 각 문제는 그것을 풀어을 때 얻는 점수와 푸는데 걸리는 시간이 주어짐
    // 제한시간 M안에 N개의 문제 중 최대 점수를 얻을 수 있도록 해야함
    // 해당 문제는 해당 시간이 걸리면 푸는걸로 간주. 한 유형당 한개만 풀 수 있음.

    // 입력 설명 첫 줄에 문제의 개수 1<=N<=20과 제한 시간 M(10<=M<=300)이 주어짐
    // 두번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간
    // 출력 설명 첫 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력

    // -> 부분집합 스타일의 문제다

    // 입력 예제
    // 5 20 / 10 5 / 25 12 / 15 8 / 6 3 / 7 4 -> 41

    // {} 문제를 푼다 = 가져온다 / 못푼다 = 가져오지 않는다 {0, 2, 4} 0번 2번 4번만 가져온다 이런식..
    // -> D(L, Sum) // Level,Sum,time
    // 점수 따로 놓고, 걸리는 시간 따로 놓고



    static int answer = Integer.MIN_VALUE; // 최대 무게를 찾아야 하니까 가장 작은 값.
    static int n;
    static int m;

    public void DFS(int L, int sum, int time, int[] ps, int [] pt) { //score / time
        if (time>m) {
            return;
        }
        if (L==n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L+1, sum+ps[L], time+pt[L], ps, pt); //L번째 문제를 푼다 sum에 더함. L만큼 시간 걸린다 time에 더함
            DFS(L+1, sum, time, ps, pt); // 문제를 풀지 않겠다.
        }

    }

    public static void main(String[] args) {
        GetMaxScore_3 T = new GetMaxScore_3();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 문제 개수
        m = scanner.nextInt(); // 제한 시간
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt(); // 점수
            b[i] = scanner.nextInt(); // 문제 풀리는데 걸리는 시간을 넣음
        }
        T.DFS(0,0, 0, a, b);
        System.out.println(answer);
    }

}
