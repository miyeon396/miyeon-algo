package com.example.codete.book.ch3.투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class P1235_좋은수 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 0;

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int k=0; k<N; k++) {
            int i=0;
            int j=N-1;
            int find=arr[k];

            while (i<j) {
                if (arr[i]+arr[j] == find) {
                    if (i!=k && j!=k) {
                        cnt++;
                        break;
                    } else if (i==k) {
                        i++;
                    } else if (j==k) {
                        j--;
                    }
                } else if (arr[i]+arr[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        System.out.println(cnt);
    }
}
