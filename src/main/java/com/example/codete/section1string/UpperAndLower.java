package com.example.codete.section1string;

import java.util.Scanner;

public class UpperAndLower {
    //문자열을 입력 대문자 -> 소문자로, 소문자 -> 대문자로 변환
    public String solution(String str) {
        String answer = "";
        String answerAscii = "";

        //String 기반 문자 배열 생성
        char[] strArr = str.toCharArray();

        for(char c : strArr) {
            //대소문자 체크 및 변환 적재
            if(Character.isLowerCase(c)) answer+=Character.toUpperCase(c);
            else answer+=Character.toLowerCase(c);
        }

        for(char c : strArr) {
            //방안2. 아스키 넘버로도 가능.
            // 65~90 : 대문자 / 97 ~ 122 : 소문자 = 소문자 - 32 = 대문자
            //char는 정수형이기 때문에 바로 아스키 코드로 비교됨
            if(c >= 65 && c <= 90) answerAscii+=(char)(c+32);
            if(c >=97 && c <= 122) answerAscii+=(char)(c-32);
        }

        System.out.println("answerAscii="+answer);
        return answer;
    }

    public static void main(String args[]) {
        UpperAndLower T = new UpperAndLower();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));

    }
}
