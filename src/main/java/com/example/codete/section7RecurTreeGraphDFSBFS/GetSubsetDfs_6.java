package com.example.codete.section7RecurTreeGraphDFSBFS;

public class GetSubsetDfs_6 {

    // 부분집합 구하기
    // 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력

    // 입력 설명
    // 첫줄 자연수 N(1<=N<=10)
    // 출력 설명
    // 첫줄부터 각 줄에 하나씩 부분집합을 예제와 같은 순서로 출력 단 공집합은 출려 x
    // ex) 3 -> 123 / 12 / 13 / 1 / 23 / 2 / 3
    // -> 얘도 이진트리 재귀로 풀 듯

    // 설명
    // -> 이진트리
    //                        DFS(1) -> 1을 사용한다 사용하지 않는다
    //            DFS(2) -> 2 사용 o x   DFS(2)
    //        DFS(3) -> 3 사용 o x  DFS(3)
    // DFS(4) -> 종료  DFS(4)
    // 123 넣을 수 있고 안넣을 수 있고 2 * 2 * 2 = 8 (2^n)
    // 스택 트레이스에 넣어놓고 직접 해보세요.. 삼성에 DFS 꼭 나오니 차근차근 스택 넣고 그림그리고 원리 이해해야 풀 수 잇음.

    static int n;
    static int[] ch; //체크 배열. 사용한다. 안한다 체크하려고

    public void DFS(int l) {
        // 보통 재귀는 if else
        if(l == n+1) { // 종착점에 왔다.
            String tmp = "";
            for(int i=1; i<=n; i++) {
                if(ch[i] == 1) tmp += (i+" ");
            }
            if(tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else { // 종착점에 오지 않았다. 뻗어 나아가야지
            ch[l] = 1; //체크배열에 사용한다의 경우 1로
            DFS(l+1); // 왼(사용한다)
            ch[l] = 0; //체크배열에 사용하지 않는드의 경우 0으로
            DFS(l+1); // 오(사용하지않는다)
        }
    }

    public static void main(String args[]) {
        GetSubsetDfs_6 T = new GetSubsetDfs_6();
        n=3;
        ch = new int[n+1]; //인덱스 번호 +1 하려고고        T.DFS(1);
        T.DFS(1);
    }
}
