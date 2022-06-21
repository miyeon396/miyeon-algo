package com.example.codete.section7RecurTreeGraphDFSBFS;

import java.util.Scanner;

public class SearchRouteAdjencyMatrix_12 {

    // 경로 탐색(인접행렬)
    // 방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성
    // 1 2 3 4 5 / 1 2 5 / 1 3 4 2 5 / 1 3 4 5 / 1 4 2 5 / 1 4 5
    // 총 6가지 (그래프에서 1번정점에서 5버 정점으로 가는 가지수 )
    //   <-
    // 1 -> 2 -> 5
    // | X  ^   ^
    // VV  V|  /
    // 3 -> 4

    // 입력 설명
    // 첫번째 줄에는 정점의 수 N (1<=N<=20)와 간선의 수 M 가 주어짐.
    // 그 다음 부터 M 줄에 걸쳐 연결 정보가 주어진다.
    // 출력 설명
    // 총 가지수를 출력

    // ex) 5 9 / 1 2 / 1 3 / 1 4 / 2 1 / 2 3 / 2 5 / 3 4/ 4 2 / 4 5 -> 6
    // 경로 : 한번 방문한 노드는 다시 방문하지 않는다.

    static int n = 0;
    static int m = 0;
    static int answer = 0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n) {
            answer++;
        } else {
            for(int i=1; i<=n; i++) {
                if(graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1; //v가 i로 이동
                    DFS(i);
                    ch[i] = 0;// 취소
                }
            }
        }

    }

    public static void main(String args[]) {
        SearchRouteAdjencyMatrix_12 T = new SearchRouteAdjencyMatrix_12();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 노드의 개수
        m = scanner.nextInt(); // 간선의 개수
        graph = new int[n+1][n+1]; //정점 번호
        ch = new int[n+1];
        for (int i=0; i<m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
