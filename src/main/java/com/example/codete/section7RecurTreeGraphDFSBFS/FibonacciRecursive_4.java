package com.example.codete.section7RecurTreeGraphDFSBFS;

public class FibonacciRecursive_4 {

    // 피보나치
    // 피보나치 수열 출력. 앞의 2개의 수 합하여 다음 숫자가 되는 수열
    // 입력은 피보나치 수열의 항의 수. 7 입력 시 1 1 2 3 5 8 13 출력

    // 입력 예시
    // 첫줄 총 항 수 N (3<=N<=45). 피보나치 수열 출력
    // ex) 10 -> 1 1 2 3 5 8 13 21 34 55

    // 1. for문 예시 2. 재귀 예시 -> 2가지 가능 정리필요. (재귀가 더 성능이 나쁘긴 함 )

    // DFS 성능 개선
    // 1. 걍 DFS 계속 호출
    // 2. Array선언해서 거기에 저장 후 연산
    // 3. Memorization - 이미 갖고 있는 값을 사용

    static int[] fibo;
    public int DFS(int n) { //n은 항의 번호
       if(n==1 || n==2) {
           return fibo[n] = 1;
       } else {
//           return DFS(n-2)+DFS(n-1);
           return fibo[n] = DFS(n-2)+DFS(n-1); //똑같이 저장하는데 효율을 더 좋게 하기위해서 배열에 저장해놓고 리턴하는 것.
       }
    }

    public static void main(String args[]) {
        FibonacciRecursive_4 T = new FibonacciRecursive_4();
        int n=7;
        fibo = new int[n+1];
        T.DFS(n);
        for(int i=1; i<=n; i++) {
//            System.out.print(T.DFS(i)+ " ");
            System.out.print(fibo[i]+ " ");
        }
    }
}
