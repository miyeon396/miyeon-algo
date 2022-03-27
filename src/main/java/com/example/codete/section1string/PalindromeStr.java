package com.example.codete.section1string;

import java.util.Scanner;

public class PalindromeStr {
    // 대소문자 구분 없이 회문 문자열(앞뒤가 같음)이면 Yes, 아니면 No return
    // 짝수 : 길이를 나누기 2까지 나눠서 돌면서 같은지 비교하도록
    // 홀수 : 나누기 2 해서 그전까지만 비교
    public String solution(String str) {
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();
        for(int i=0; i<len/2; i++) {
            if(str.charAt(i) != str.charAt(len-i-1)) return "NO";
        }

        //방법2. String builder
        String answer2 = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) answer2 = "YES";
        System.out.println("22="+answer2);

        return answer;
    }

    public static void main(String args[]) {
        PalindromeStr T = new PalindromeStr();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));

    }
}
