package com.example.codete.book.ch3;

public class CharToIntTest {

    public static void main(String[] args) {
        char ch = '1';

        int num1 = ch - '0';
        int num2 = ch - 48;
        int num3 = Character.getNumericValue(ch);

        System.out.println(ch);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }
}
