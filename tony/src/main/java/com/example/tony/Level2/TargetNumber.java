package com.example.tony.Level2;


import java.util.LinkedList;

/*
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
//        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
//        }
//        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
//        }
    }
    // DFS : Recursive
    void dfsR(Node r){

        if(r == null) return;
        r.marked = true;
        visit(r);
        for(Node n : r.adjacent){
            if(n.marked == false){
                dfsR(n);
            }
        }
    }

    // DFS : Recursive : array
    void dfsR(int index){
        Node r = nodes[index];
        dfsR(r);

    }

    void dfsR(){
        dfsR(0);
    }
    void visit(Node n){ // 출력함수
        System.out.print(n.data + " ");
    }

}
*/

public class TargetNumber {

    int count;

    public int solution(int[] numbers, int target) {
        int count = 0;
        int answer = 0;
        dfs(numbers, 0, target, 0);
        answer = this.count;

        return answer;

    }

    public void dfs(int[] numbers, int depth, int target, int result) {
        if (depth == numbers.length) {
            if (target == result) {
                this.count++;
            }
            return;
        }

        int add = result + numbers[depth];
        int sub = result - numbers[depth];

        // 재귀 호출시 함수 stack에 의해 역순으로 호출되면서 계산
        dfs(numbers, depth + 1, target, add);
        dfs(numbers, depth + 1, target, sub);

    }

    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();
        int[] numbers = {1, 1, 1, 1, 1};

        int result = targetNumber.solution(numbers, 3);
        System.out.println("result : " + result);
    }
}
