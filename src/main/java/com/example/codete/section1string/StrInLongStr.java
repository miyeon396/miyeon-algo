package com.example.codete.section1string;

import java.util.Scanner;

public class StrInLongStr {
    //문장 속에서 가장 긴 단어 출력. 문장속 단어는 공백으로 구분
    //가장 긴 게 여러개면 맨 앞의 것
    //hi my name is miyeon -> miyeon
    public String solution(String str) {
        String answer = "";
        String answer2 = "";
        int m = Integer.MIN_VALUE;
        int m2 = Integer.MIN_VALUE, pos;
        // 방법 1. split
        String[] strArr = str.split(" ");

        for(String s : strArr) {
            //여기서 가장 긴 단어.
            // 최대값 구하는 것. 갱신 될 때마다 answer에 넣어주는 것.
            int sLen = s.length();
            if(sLen > m) {
                m = sLen;
                answer = s;
            }

        }

        //방법 2. subtring, indexof
        while((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > m2) {
                m2 = len;
                answer2 = tmp;
            }
            str = str.substring(pos+1);
        }
        if(str.length() > m2) answer2 = str; //마지막 단어에 대한 처리
        System.out.println("answer2 ="+answer2);

        return answer;
    }

    public static void main(String args[]) {
        StrInLongStr T = new StrInLongStr();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine(); //한 줄을 입력받아야 하니까
        System.out.println(T.solution(str));

    }
}
