package com.example.codete.section5StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Iron_5 {
    // 여러개의 쇠막대기 레이저로 절단
    // 아래에서 위로 쇠막대기 겹치고 수직으로 발사하여 레이저를 쇠막대기 자름. 배치 조건 아래와 같이 만족
    // 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다. 끝점은 겹치치 않게 놓는다.
    // 쇠 막대기를 자르는 레이저는 적어도 하나 존재한다.
    // 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
    // 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.
    // 1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ()으로 표현된다. 또한 모든 ()는 반드시 레이저를 표현한다.
    // 2. 쇠막대기의 왼쪽 끝은 여는 괄호 오른쪽 끝은 닫힌 괄호로 표현한다.
    // 쇠막대기는 레이저에 의해 몇 개의 조각으로 잘려지는데, 위의 예에서 가장 위에 있는 두 개의 쇠막대기는 각각 3개와 2개의 조각으로 잘려지고, 이와 같은 방식응로 주어진 쇠막대기들은 총 17개의 조각으로 잘려짐
    // 쇠막대기와 레이저의 배치를 나타내는 괄호가 주어졌을 때 잘려진 쇠막대기의 조각의 총 수 구하라
    // ex) ()(((()())(())()))(()) -> 17
    // 여는 괄호 만나면 스택에 푸쉬하세요. 닫는 괄호 만났을 때, 레이저의 쌍인지, 막대기의 끝을 알리는 닫는 괄호인지 알아내야함.
    // 바로 앞의 괄호를 확인. 여는거-> 레이저 / 닫는거 -> 막대기 여는거면 팝.
    // 팝하고 나면 갯수(스텍의 사이즈)를 셈. answer에 push 반복...
    // 닫는 괄호를 만나면 팝 해주고, +1 해줌.

    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
            } else { // 닫는 괄호
                //일단 만나면 여는 괄호는 뺴버림
                stack.pop();
                if(str.charAt(i-1) == '(') answer+=stack.size(); // 레이저의 경우 스택에 있는 만큼 토막 +
                else answer++; //막대기인 경우 끝 막대기 +1
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        Iron_5 T = new Iron_5();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));

    }
}
