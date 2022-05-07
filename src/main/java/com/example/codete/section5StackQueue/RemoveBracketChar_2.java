package com.example.codete.section5StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class RemoveBracketChar_2 {
    // 입력된 문자열에서 소괄호() 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
    // ex) (A(BC)D)EF(G(H)(IJ)K)LM(N) -> EFLM
    // -> 괄호가 있어. 괄호가 있으면 십중팔구 스택
    // 여는괄호 + 알파벳은 무조건 푸쉬 -> 닫는 괄호를 만났을 때 여는 괄호가 짝꿍. 여는괄호까지 제거하기(팝).
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char x: str.toCharArray()) {
            if(x == ')') {
                while(stack.pop() != '('); //여는 괄호 꺼내고 멈춤. stack.pop() 은 꺼낸 값을 리턴받음.
            } else {
                stack.push(x);
            }
        }
        for(int i=0; i<stack.size(); i++) {
            answer+=stack.get(i);
        }

        return answer;
    }

    public static void main(String args[]) {
        RemoveBracketChar_2 T = new RemoveBracketChar_2();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));
        
    }
}
