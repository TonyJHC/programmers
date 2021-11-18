package com.example.tony.Baekjun;

public class test {
    public static void main(String[] args) {
        String str = new String();
        str = "512341";
        System.out.println(str.length());
        str = str.replaceAll(str,"");
        System.out.println(str.length());

        boolean [] visited = new boolean[5];
        visited[1]  = true;
        for(boolean i : visited){
            System.out.println(i);
        }


        }
}
