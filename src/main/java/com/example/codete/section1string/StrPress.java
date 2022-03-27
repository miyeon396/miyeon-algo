package com.example.codete.section1string;

import java.util.Scanner;

public class StrPress {
    //SSOHHHHA -> S2OH4A
    public String solution(String str) {
        //배열보고 현재=현재+1이면 카운트
        String answer = "";
        str = str + " "; //outOfIndex막게
        int cnt = 1;

        for(int i=0; i< str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) cnt++;
            else {
                answer+=str.charAt(i);
                if(cnt > 1) answer+=String.valueOf(cnt);
                cnt=1;
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        StrPress T = new StrPress();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));

    }
}
