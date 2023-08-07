package com.example.codete.book.ch3.스택큐;

import java.io.*;
import java.util.Stack;

public class P17298_오큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int A[] = new int[n]; //수열배열
        int ans[] = new int[n]; //정답배열
        String[] str = bf.readLine().split(" ");

        for (int i=0; i<n; i++) {
            A[i] = Integer.parseInt(str[i]);
        }

        Stack<Integer> myStack = new Stack<>();
        myStack.push(0); //처음에는 항상 스택이 비어있으니까 하나 넣어줌

        for (int i=0; i<n; i++) {
            //스택이 비어있지 않고, 현재 수열 스택 top 인덱스가 가리키는 수열보다 클 경우
            while (!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
                ans[myStack.pop()] = A[i];
            }
            myStack.push(i);
        }

        //반복문 다 돌았는데 스택이 비어있지 않다면 빌때까ㅣ
        while (!myStack.empty()) {
            ans[myStack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("/");
        bw.flush();
    }
}
