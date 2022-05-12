package com.example.codete.section5StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Postfix_4 {
    // 후위 연산식이 주어지면 연산한 결과를 출력하는 프로그램 작성
    // ex) 3*(5+2)-9를 후위연산식 352+*9- -> 12
    // stack를 사용 예정 -> 숫자 만났을 때 push. 연산자 만났을 때 꺼냄. 나중에 나온게 왼쪽 먼저5 나온게 오른쪽2. 연산 해서 다시 push. 반복~
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(char x : str.toCharArray()) {
            if(Character.isDigit(x)) {
                stack.push(x-48);
            } else {
                int rt = stack.pop(); //먼저 나온거
                int lt = stack.pop(); //나중에 나온거
                if(x == '+') {
                    stack.push(lt+rt);
                } else if(x == '-') {
                    stack.push(lt-rt);
                } else if(x == '*') {
                    stack.push(lt*rt);
                } else if( x == '/') {
                    stack.push(lt/rt);
                }
            }
        }
        answer = stack.get(0);

        return answer;
    }

    public static void main(String args[]) {
        Postfix_4 T = new Postfix_4();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));

    }
}
