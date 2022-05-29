package com.example.codete.section6SortSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point> { //Point라는 클래그객체를 정렬한다.
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y-o.y; //X값이 같을 떄 정렬 //this가 앞 o가 뒤 오름차순이면 10 20 이겠지 이럼 음수가 리턴이 되게 해야함
        else return this.x-o.x; //다를 땐 x 기준으로 정렬
    }

}
public class PointSortCompareTo_7 {

    // N개의 평면상의 좌표 (x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램 작성
    // 정렬기준은 x값에 의해서 먼저 정렬하고, x 값이 같을 경우 y 값에 의해서 정렬

    // 입출력 예시
    // 첫줄 좌표 개수 N / 둘째줄 N개의 좌표 x,y순으로 주어짐. x,y값은 양수만 입력
    // ex) 5 / 2 7 / 1 3 / 1 2 / 2 5 / 3 6 / -> 1 2 / 1 3 / 2 5 / 2 7 / 3 6

    // 좌표를 정렬하는 기술을 익히기

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //좌표 n개
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arr.add(new Point(x, y));
        }
        Collections.sort(arr);
        for(Point o : arr) {
            System.out.println(o.x+" "+o.y);
        }
    }
}
