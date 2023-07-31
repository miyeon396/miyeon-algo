package com.example.codete.book.ch3.슬라이딩윈도우;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {
    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken()); //문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이
        int Result = 0;
        checkArr = new int[4]; //체크 배열 A C G T 넣는
        myArr = new int[4];
        char A[] = new char[S]; //문자열 데이터
        checkSecret = 0; // 현재 4개 중에 개수를 얼마나 만족하는지

        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());

        for (int i=0; i<4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken()); //아까 입력했던 것 중 4개를 차례대로 가져오겠지
            if (checkArr[i] == 0) { //0인애는 안세어줘도 되니까(=이미 만족) 우리는 checkSecret가 4인걸 찾을거니까 하나 올려줌
                checkSecret++;
            }
        }

        for (int i=0; i<P; i++) { // 부분 문자열 처음 받을 때 세팅
            Add(A[i]); //첫번째 값을 현재 상태 배열에 넣어주겠다.
        }

        if (checkSecret == 4) Result++; //처음값이 부분문자열이 만족한다 그럼 결과 1추가

        // 이제부터 슬라이딩 윈도우
        for (int i=P; i<S; i++) {
            int j = i-P; //부분 문자열에서 젤 왼쪽에 해당하는게 j / 젤 오른쪽에 해당하는게 i
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) Result++; //한번 이동할때마다 현재 시크릿이 맞는지 체크
        }

        System.out.println("Result = " + Result);
        bf.close();

    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}
