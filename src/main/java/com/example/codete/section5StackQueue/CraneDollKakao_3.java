package com.example.codete.section5StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class CraneDollKakao_3 {
    // 1x1 크기의 칸들로 이루어진 NxN 크기의 정사각 격자 위쪽엔 크레인 옆쪽엔 바구니
    // 모든 인형은 1x1 크기의 격자 한칸을 차지. 아래부터 쌓여있음
    // 사용자는 크레인 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형 집을 수 있음. 집은 인형은 바구니에 순서대로 쌓임. 바구니의 가장 아래부터 쌓임
    // 만약 같은 모양의 인형 두개가 바구니에 연속해서 쌓이면 터져 바구니에서 사라짐
    // 인형 없는 곳에서 집었을 땐 아무일 없음.
    // 바구니는 모든 인형이 들어갈 만큼 충분히 크다는 가정
    // 격자의 상태가 담긴 2차원 배열 board와 인형을 잡기 위해 크레인을 작동시킨 위치가 담긴 배열 move가 매개변수로 주어질 때, 크레인을 모두 작동 시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램
    // 첫줄 자연수 두번째줄 n n board 배열 (0~100 0은 빈칸 나머지 숫자는 인형 의미) 세줄 moves 배열 길이 M  마지막 줄 moves 배열
    // ex ) 5
    //  0 0 0 0 0
    //  0 0 1 0 3
    //  0 2 5 0 1
    //  4 2 4 4 2
    //  3 5 1 3 1
    //  8
    // 1 5 3 5 1 2 1 3
    // -> 4
    // 움직임 따라서 array의 맨 위 뽑아서 0으로 바꾸고 상자에 넣어줌. 상자에 만약에 peek가 같다면 넣지 않고, 상자 것도 pop 시키고 answer+2 반복해서 return
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int pos : moves) {
            //pos가지고 탐색하는거 시작
            for(int i=0; i<board.length; i++) { //2차원 배열일 때 length는 행크기, 열크기는 board[0].length
                if (board[i][pos - 1] != 0) {
                    int tmp = board[i][pos - 1];
                    board[i][pos - 1] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break; // 한번만 탐색하고 다른 move에서 또 다시 탐색할 것이기 떄문
                }

            }

        }

        return answer;
    }

    public static void main(String args[]) {
        CraneDollKakao_3 T = new CraneDollKakao_3();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int m = scanner.nextInt();
        int[] moves = new int[m];
        for(int i=0; i<m; i++) {
            moves[i] = scanner.nextInt();
        }
        System.out.println(T.solution(board, moves));
        
    }
}
