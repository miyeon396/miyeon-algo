package com.example.codete.miyeonexample;

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateOom {


    public static void main(String args[]) {
        ArrayList list = new ArrayList();

        try {
            for(int i=0; i < 250000; i++) {
                list.add(new byte[1000000]);
                System.out.println(i);
                Thread.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
