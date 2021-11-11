package com.example.tony.Level2;


import java.util.LinkedList;
import java.util.*;


class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent; // 인접 노드와의 관계 ( 자식 )
        boolean marked; // 해당 노드 방문 유무

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    Node[] nodes;  // 노드들 저장

    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {// 두 노드의 관계를 저장하는 함수
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0); // 인자 없으면 시작 노드부터
    }

    // DFS : Stack
    void dfs(int index) { // 시작노드 인자로 받아서 순회 결과 출력하는 함수
        Node root = nodes[index]; // 인덱스로 노드 가져오기
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true; // 방문했음을 표시
        while(!stack.empty()){
            Node r = stack.pop() ; // 스택에서 데이터 pop
            for (Node n : r.adjacent){
                if(n.marked == false){ // stack에 추가되지 않은 노드들만 추가
                    n.marked =true; // 방문 표시
                    stack.push(n);
                }
            }
            visit(r); // 출력
        }
    }

    void bfs(){
        bfs(0); // 인자 없으면 시작 노드부터
    }

    // BFS : Queue
    void bfs(int index){
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); // 시작할 노드 큐에 추가
        root.marked = true; // 방문

        while(!queue.isEmpty()){
            Node r = queue.poll(); // 꺼내기
            for(Node n : r.adjacent){ // 인접한 노드(자식)로 이동 : 인접(자식) 노드 queue에 추가하기 위해
                if(n.marked == false){ // 방문한적 없다면
                    n.marked = true; // 방문 했음을 알림
                    queue.offer(n); // 큐에 추가
                }
            }
            visit(r); // 큐에서 poll한 노드 출력
        }

    }

    void visit(Node n){ // 출력함수
        System.out.print(n.data + " ");
    }


}
public class TargetNumber {


    public int solution(int[] numbers, int target) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {

    }
}
