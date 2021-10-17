package com.company.search.day02.stack;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/11
 * Time: 12:57 오전
 * des : Stack methods
 */
public class IntStack {

    private int max;
    private int ptr;
    private int[] stk;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }

    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if (ptr >= max) {
            // == 연산자로 최대 값을 평가하게 되면 배열의 범위가 벗어 날 경우에 아에 오류를 내 버리기 때문에 위처럼 >= 연산자로 접근.
            throw new OverflowIntStackException();
        } else {
            return stk[ptr++] = x;
        }
    }

    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        } else {
            return stk[--ptr];
        }
    }

    public int peek() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        } else {
            // ptr은 항상 다음 층을 가르키고 있으므로 -1을 수행
            return stk[ptr - 1];
        }
    }

    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) {
            if (stk[i] == x) {
                return i;
            }
        }

        return -1;
    }

    public void clear() {
        ptr = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= max;
    }

    public void dump() {
        if (ptr <= 0) {
            System.out.println("스택이 비어있습니다.");
        } else {
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }

}
