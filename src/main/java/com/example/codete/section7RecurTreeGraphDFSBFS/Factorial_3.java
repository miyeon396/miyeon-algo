package com.example.codete.section7RecurTreeGraphDFSBFS;

public class Factorial_3 {

    // 팩토리얼
    // 자연수 N이 입력되면 N!을 구하는 프로그램
    // ex) 5! = 5 * 4 * 3 * 2 * 1 = 120

    // 입력 예시
    // 첫줄 자연수 N(1<=N<=100)
    // ex) 5 -> 120


   public int DFS(int n) {
       if (n==1) {
           return 1;
       } else {
           return n * DFS(n-1);
       }

   }

    public static void main(String args[]) {
        Factorial_3 T = new Factorial_3();
        System.out.println(T.DFS(5));
    }
}
