package com.example.codete.section1string;

import java.util.Scanner;

public class palindromeReplaceAllStr {
    // 특수문자, 숫자 받지만 알파벳만을 가지고 회문 검사
    public String solution(String str) {
        String answer = "NO";

        str = str.toUpperCase().replaceAll("[^A-Z]", ""); //대문자 A부터 Z까지가 아니면 다 변경하거라

        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) return "YES";

        return answer;
    }

    public static void main(String args[]) {
        palindromeReplaceAllStr T = new palindromeReplaceAllStr();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));

    }
}
