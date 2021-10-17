package com.company.search.day03;

import com.company.search.day02.stack.IntStack;

public class IntArrayQueue {

    private int max;
    private int num;
    private int[] que;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }

    // queue 생성자. stack이랑 거의 똑같..?
    public IntArrayQueue(int capacity) {
        num = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enqueue(int data) throws OverflowIntStackException {
        if (num >= max) {
            throw new OverflowIntStackException();
        } else {
            return que[num++] = data;
        }
    }

    public int dequeue() throws EmptyIntStackException {
        if (num <= 0) {
            throw new EmptyIntStackException();
        } else {
            int temp = que[0];
            for (int i = 1; i < num; i++) {
                que[i] = que[i - 1];
            }
            num--;
            return temp;
        }
    }

    public int peek() throws EmptyIntStackException {
        if (num <= 0) {
            throw new EmptyIntStackException();
        } else {
            return que[num];
        }
    }

    public int indexOf(int data) {
        for (int i = 0; i < num; i++) {
            if (que[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        num = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {
        if (num <= 0) {
            System.out.println("데이터가 비어있습니다.");
        } else {
            for (int i : que) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
