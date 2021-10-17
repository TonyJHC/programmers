package com.company.search.day02.stack;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/11
 * Time: 12:27 오후
 * des : 하나의 배열을 공유하여 두 개의 스택을 구현하는 정수 데이터용 스택 클래스 입니다.
 */
enum StackType {
    STACK_A, STACK_B
}

public class SharedStack {

    private int ptr1;
    private int ptr2;
    private int max;
    private int[] stk;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
            System.out.println("스택 범위 초과");
        }
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
            System.out.println("스택 범위 초과");
        }
    }

    public SharedStack(int capacity) {
        max = capacity;
        ptr1 = 0;
        ptr2 = max - 1;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            System.out.println(e);
            max = 0;
        }
    }

    public int push(StackType st, int x) throws OverflowIntStackException {
        // ptr1이 ptr2와 같을 경우로 분류한다면 ptr1과 ptr2가 겹칠 때 예외 발생시킴!
        if (ptr1 > ptr2) {
            throw new OverflowIntStackException();
        } else {
            switch (st) {
                case STACK_A:
                    return stk[ptr1++] = x;
                case STACK_B:
                    return stk[ptr2--] = x;
            }
        }
        return -1;
    }

    public int pop(StackType st) throws EmptyIntStackException {
        if (ptr1 <= 0 || ptr2 > max) {
            throw new EmptyIntStackException();
        } else {
            switch (st) {
                case STACK_A:
                    return stk[--ptr1];
                case STACK_B:
                    return stk[++ptr2];
            }
        }
        return -1;
    }

    public void printStk() {
        System.out.print("STACK A : ");
        if (ptr1 <= 0) {
            System.out.println("STACK A IS EMPTY");
        } else {
            for (int i = 0; i < ptr1; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }

        System.out.print("STACK B : ");
        if (ptr2 >= max - 1) {
            System.out.println("STACK B IS EMPTY");
        } else {
            for (int j = max - 1; j > ptr2; j--) {
                System.out.print(stk[j] + " ");
            }
        }
    }

    public static void main(String[] args) {

        SharedStack ss = new SharedStack(10);

        ss.push(StackType.STACK_B, 9);
        ss.push(StackType.STACK_B, 9);
        ss.push(StackType.STACK_B, 9);
        ss.push(StackType.STACK_B, 9);
        ss.push(StackType.STACK_B, 9);
        ss.push(StackType.STACK_B, 9);
        ss.push(StackType.STACK_B, 9);
        ss.push(StackType.STACK_B, 9);
        ss.push(StackType.STACK_B, 9);
        ss.push(StackType.STACK_B, 9);

        ss.printStk();
    }

}
