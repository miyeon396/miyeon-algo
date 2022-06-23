package com.example.codete.section7RecurTreeGraphDFSBFS;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchRouteAdjencyMatrixArrayList_13 {

    // 경로 탐색(인접리스트) (앞문제와 문제는 똑같은데 이건 인접 리스트 앞에껀 인접 행렬)
    // 정점이 수만개가 들어오면 인접 행렬은 굉장히 비효율 적이다 행렬의 행과 열을 for문 다 돌면서 체크해야하기 떄문 메모리를 너무 크게 잡아먹는다 배열만드는데.. -> 인접 리스트를 사용

    // 방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성
    // 1 2 3 4 5 / 1 2 5 / 1 3 4 2 5 / 1 3 4 5 / 1 4 2 5 / 1 4 5
    // 총 6가지 (그래프에서 1번정점에서 5버 정점으로 가는 가지수 )
    //   <-
    // 1 -> 2 -> 5
    // | X  ^   ^
    // VV  V|  /
    // 3 -> 4

    // 인접 리스트를 5개 만들어 놓음
    // 1번 리스트 -> 2추가 -> 3추가 -> 4추가
    // 2번 리스트 -> 1추가 -> 3추가
    // 3번 리스트 -> 2추가 -> 5추가
    //... 이런식으로

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
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public void DFS(int v){
        if(v==n) {
            answer++;
        } else {
            for (int nextV : graph.get(v)) { //v번 ArrayList
                //이제 방문했냐 안했냐만 체크
                if(ch[nextV]==0) { //no 방문
                    ch[nextV] = 1;
                    DFS(nextV);
                    ch[nextV] = 0;
                }
            }
        }
    }

    public static void main(String args[]) {
        SearchRouteAdjencyMatrixArrayList_13 T = new SearchRouteAdjencyMatrixArrayList_13();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 노드의 개수
        m = scanner.nextInt(); // 간선의 개수
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        for (int i=0; i<m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b); //3번 arrayList에 5를 add 시켜라 이런 의미
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
