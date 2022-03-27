package com.example.codete.section1string;

import java.util.Scanner;

public class ExtractOnlyNum {
    //abke020s039 -> 020039 -> 20039
    public int solution(String str) {
        // ascii 48이상 57이하 -> 0-9
        int answer = 0;

        String answer2 = "";

        for(char c : str.toCharArray()) {
            //1. ascii number로
            if(c >= 48 && c <= 57) answer = answer*10+(c-48);

            //2. isDigit로
            if(Character.isDigit(c)) answer2+=c;

        }

        System.out.println("answer2="+Integer.parseInt(answer2));


        return answer;
    }

    public static void main(String args[]) {
        ExtractOnlyNum T = new ExtractOnlyNum();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));

    }
}
