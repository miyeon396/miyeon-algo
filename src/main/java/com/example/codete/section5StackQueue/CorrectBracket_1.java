package com.example.codete.section5StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class CorrectBracket_1 {
    // 괄호 입력 시 올바른 괄호면 YES, 아니면 NO 출력
    // 문자열의 최대 길이 30
    // (())() YES / (()())) NO
    // Stack 사용 LIFO 선입후출
    // (QUEUE는 FIFO)
    public String solution(String str) {
        String answer = "YES";

        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()) {
            if(x=='(') stack.push(x);
            else {
                if(stack.isEmpty()) return "NO"; //닫는 괄호가 더 많은 경우
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return "NO"; //여는 괄호가 더 많은 경우

        return answer;
    }

    public static void main(String args[]) {
        CorrectBracket_1 T = new CorrectBracket_1();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));
        
    }
}
