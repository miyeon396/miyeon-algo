package com.example.codete.section7RecurTreeGraphDFSBFS;

public class RecursiveStackFrame_1 {

    // 재귀함수
    // 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지 출력하는 프로그램 작성

    // 입력 예제
    // 첫줄 N (3<=N<=10)
    // ex) 3 -> 1,2,3

    // 재귀함수란
    // 자기가 자기 자신 호출하는 함수
    // DFS라고 보통함 Recursive 해도 되고..
    // 반복문의 형태인거임 본인 자기 자신을 계속 호출하는 것임. DFS(n-1)
    // 재귀 함수는 stack frame을 사용한다. - 매개변수 정보, 지역변수 정보, 복귀주소 일케 갖고 있음
    // 스택에 D(3)-line6 -> D(2)-line6 -> D(1)-line6 - D(0) 이제 스택 끄내기 시작 각 Line으로 복귀 거기부터 다시..
    // 그래서 321, 123 출력되는 이유


   public void DFS(int n) {
       if(n==0) {
           return;
       } else {
           System.out.println("줄어듬"+n); // 3 2 1
           DFS(n-1);
           System.out.println("늘어남"+n); // -> 재귀함수는 stack frame 사용 1 2 3
       }
   }

    public static void main(String args[]) {
        RecursiveStackFrame_1 T = new RecursiveStackFrame_1();
        T.DFS(3);
    }
}
