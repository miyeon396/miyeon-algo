package com.example.codete.section1string;

import java.util.ArrayList;
import java.util.Scanner;

public class StrRollOver {
    //N개의 단어가 주어지면 각 단어를 뒤집어 출력
    //ex) 3 hi coco bye -> ih ococ eyb
    // String builder, left/right 써서 뒤집기
    public ArrayList<String> solution(int n, String[] strArr) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> answer2 = new ArrayList<>();

        //방법1. StringBuilder & reverse
        for(String s : strArr) {
            String tmp = new StringBuilder(s).reverse().toString(); //StringBuilder 문자열을 다루는 클래스
            //String은 더하거나 추가하거나 할 때, 객체가 계속 만들어짐. String Builder은 객체를 새로 만들지 않음. 메모리 부담이 덜함. 연산이 많다면 StringBuilder를 추천
            answer.add(tmp);
        }

        //단어 안에서 특정 문자만 바꿔라 -> 일일히 하나하나 뒤집 left/right
        for(String s : strArr) {
            char[] charArr = s.toCharArray(); //study 01234

            //단어의 길이를 구하구 04바꾸고, 13바꾸고 이런 방식
            int lt = 0;
            int rt = s.length()-1;

            //직접 reverse를 구현 하는 것.
            while(lt<rt) {
                char tmp= charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(charArr);
            answer2.add(tmp);

        }
        System.out.println("answer2="+answer2);

        return answer;
    }

    public static void main(String args[]) {
        StrRollOver T = new StrRollOver();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strArr = new String[n];
        for(int i=0; i<n; i++) {
            strArr[i] = scanner.next();
        }
        for(String x : T.solution(n, strArr)) {
            System.out.println(x);
        }


    }
}
