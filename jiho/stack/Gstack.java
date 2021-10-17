package com.company.search.day02.stack;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/11
 * Time: 1:35 오전
 */
public class Gstack<ObjectStack> {

    private int max;
    private int ptr;
    private ObjectStack[] stk;

    // 제네릭 클래스 내의 내부 클래스에서 Throwable 클래스를 상속 받을 때
    // 내부 클래스가 static 형식이 아니면 상위 클래스와 똑같이 제네릭으로 판별되어
    // Throwable 클래스를 상속 받이 못한다.
    // Generic class not allowed to extends Throwable
    public static class EmptyGStackException extends RuntimeException {
        public EmptyGStackException() {
        }
    }

    public static class OverflowGstackException extends RuntimeException {
        public OverflowGstackException() {
        }
    }

    public Gstack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            // 객체 데이터는 최상위 Object 클래스 타입으로 받고 형변환 하는 형식으로 작성!
            stk = (ObjectStack[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public ObjectStack push(ObjectStack x) throws OverflowGstackException {
        if (ptr >= max) {
            throw new OverflowGstackException();
        } else {
            return stk[ptr++] = x;
        }
    }

    public ObjectStack pop() throws EmptyGStackException {
        if (ptr <= 0) {
            throw new EmptyGStackException();
        } else {
            return stk[--ptr];
        }
    }


    public ObjectStack peek() throws EmptyGStackException {
        if (ptr <= 0) {
            throw new EmptyGStackException();
        } else {
            // ptr은 항상 다음 층을 가르키고 있으므로 -1을 수행
            return stk[ptr - 1];
        }
    }

    public int indexOf(ObjectStack x) {
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

