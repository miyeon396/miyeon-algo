package com.example.codete.section1string;

import java.util.Scanner;

public class ReverseSpecificStr {
    // 특정 문자만 뒤집기 : 알파벳+ 특수문자 -> 알파벳 뒤집기
    // a!b@c#%d -> d!c@b#%a
    public String solution(String str) {
        String answer = "";

        //lt, rt 놓고 각 가리키고 있는게 서로 알파벳일 때만 교환 후 동시 증가
        // 특수문자면 하나 증가

        char[] strArr = str.toCharArray();//문자배열 만들어짐
        int lt = 0; //첫 번째 문자
        int rt = str.length()-1; //마지막 문자

        while(lt < rt) {
            if(!Character.isAlphabetic(strArr[lt])) lt++; //알파벳이 아닐 떈 걍 증가
            else if(!Character.isAlphabetic(strArr[rt])) rt--; //알파벳이 아닐 때 감소
            else {
                char tmp = strArr[lt];
                strArr[lt] = strArr[rt];
                strArr[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(strArr); //strArr이라는 배열을 String화 시켜준다 static Method 이기때문에 class.메서드 씀.

       return answer;
    }

    public static void main(String args[]) {
        ReverseSpecificStr T = new ReverseSpecificStr();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));

    }
}
