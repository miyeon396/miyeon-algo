package com.example.codete.section7RecurTreeGraphDFSBFS;

public class BinaryPrint_2 {

    // 재귀함수
    // 10진수 N이 입력되면 2진수로 변환하여 출력. 단, 재귀함수 이용

    // 입력 예시
    // 첫줄 10진수 N
    // ex) 11 -> 1011


   public void DFS(int n) {
       // 몫이 0이 되면 멈춰랏
       // 그리고 반대로 출력해야하기 때문에 재귀 특징 이용해서 위가 아닌 아래에서 출력

       if (n == 0) {
           return;
       } else {
//           System.out.print(n%2+ " "); // 요건 순서대로
           DFS(n/2);
           System.out.print(n%2+ " "); // 요게 반대로
       }
   }

    public static void main(String args[]) {
        BinaryPrint_2 T = new BinaryPrint_2();
        T.DFS(11);
    }
}
