package com.company.search.day04;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/25
 * Time: 7:04 오후
 */
public class Q3 {
    public static int gcdArray(int[] a) throws IllegalArgumentException {
        if(a.length <= 1)
            throw new IllegalArgumentException("배열에는 2개 이상의 값이 필요합니다.");

        int cnt = 2;
        while(cnt <= a.length) {
            if(a[0]<a[1]){
                int i = a[0];
                a[0] = a[1];
                a[1] = i;
            }

            int min = a[0] % a[1];
            a[0] = a[1];
            a[1] = min;
            if (a[1] == 0) {
                if(a.length == cnt)
                    return a[0];
                a[1] = a[cnt];
            }
            cnt++;
        }
        return a[0];
    }

    public static void main(String[] args){
        int[] a = new int[] {22, 8};
        System.out.println(gcdArray(a));
    }
}



