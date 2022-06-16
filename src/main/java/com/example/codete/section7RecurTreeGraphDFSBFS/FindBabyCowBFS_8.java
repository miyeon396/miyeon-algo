package com.example.codete.section7RecurTreeGraphDFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindBabyCowBFS_8 {

    // 송아지 찾기 (BFS 상태 트리 탐색)
    // 송아지를 잃어버림. 다행히 송아지에는 위치 추적기가 달려있다.
    // 인간의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
    // 송아지는 움직이지 않고 제자리에 있다.
    // 현수는 스카이콩콩을 타고 가는데 한 번의 점프로 앞으로 1 뒤로 1 앞으로 5를 이동할 수 있다.
    // 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램

    // 입력
    // 첫 줄에 현수위치 S 송아지위치 E (좌표 1~10000)
    // 출력
    // 점프의 최소 횟수를 구한다. 답은 1이상이며 반드시 존재한다.

    // ex) 5 14 -> 3
    // 가지치기해서 갈 수 있는 경우의 수를 나열하고 1 -1 5 를 5부터 시작해서 더해서 level1 한다.
    // level2도 마찬가지 이떄 포인트들을 큐에 넣는데 이미 한번 갔던 포인트는 제외하고 넣는다.
    // 계속 글케하다가 최초로 나온게 최단거리!
    // 0  -                  5 (1 -1 5)
    // 1  -        6         4      10
    // 2  -     7     11   3   9    15
    // 3  -   8  12   16   2   14

    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch; // 한번 방문한 것 다시 안넣기 위한 체크배열. 또 체크하면 시간 복잡도만 늘어나기 때문에.
    Queue<Integer> q = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[10001]; //좌표가 10000까지니까
        ch[s] = 1;
        q.offer(s);
        int l = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                int x = q.poll(); // 루트노드
//                if (x == e) { //요기서 해도 되지만 굳이 큐에 넣었다 뺐다 하느니 아래 자식에서 바로 체크하는것도 좋다
//                    return l;
//                }
                for(int j=0; j<3; j++) {
                    int nx = x+dis[j];
                    if (nx==e) { // 요기서
                        return l+1; //자식노드니까 +1
                    }
                    if(nx >= 1 && nx <= 10000 && ch[nx]==0) {
                        ch[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            l++;
        }
        return 0;

    }

    public static void main(String args[]) {
        FindBabyCowBFS_8 T = new FindBabyCowBFS_8();
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int e = scanner.nextInt();
        System.out.println(T.BFS(s,e));

    }


}

