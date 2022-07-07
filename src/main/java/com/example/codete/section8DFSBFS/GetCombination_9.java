package com.example.codete.section8DFSBFS;

import java.util.Scanner;

public class GetCombination_9 {
    // 조합 구하기
    // 1부터 N까지 번호가 적힌 구슬이 있습니다.
    // 이중 M개를 뽑는 방법의 수를 출력하는 프로그램 작성
    // 첫줄 자연수 (3<=N<=10)과 M(2<=M<=N)이 주어집니다.
    // 첫줄에 결과 출력. 사전순 오름차순
    // ex) 4 2 -> 1 2 / 1 3 / 1 4 / 2 3 / 2 4 / 3 4

    // DFS(L,S) -> DFS(0,1) 0번인덱스1번 인덱스 -> 1 2 3 4 도는 것.
    // combi[L] = i를 넣는 것. 하나 증가해서
    // 사진
    // D(2,3)이 되었는데 레벨이 2니까 끝 팝 백해서 다시 1로 와서 3을 넣음. ... 반복

    static int[] combi;
    static int n;
    static int m;

    public void DFS(int L, int s) {
        if (L==m) { //조합이 완성이 된 것
            for (int x: combi) {
                System.out.print(x+" ");
            }
            System.out.println();
        } else {
            for (int i=s; i<=n; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        GetCombination_9 T = new GetCombination_9();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        combi = new int[m];
        T.DFS(0, 1);
    }

}
