package com.company.search.day01;

public class BinarySearchX {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 9};

        binarySearchX(arr, arr.length, 7);

        System.out.println(binarySearchX(arr, arr.length, 7));


    }

    static int binarySearchX(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;
        int cnt = 0;
        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
//                while (pc > 0 && a[pc] == a[pc - 1]) {
//                    pc -= 1;
//                    if(pc == 0){
//                        break;
//                    }
//                }
                for (pl = pc; pl >= 0; pl--) {
                    cnt++;
                    if (a[pl] == key) {
                        return pl;
                    }
                }
                return -1;


            } else if (a[pc] > key) {
                pr = pc - 1;
            } else if (a[pc] < key) {
                pl = pc + 1;
            }
        } while (pl <= pr);

        System.out.println("검색에 실패하였습니다.");
        return -1;
    }
}
