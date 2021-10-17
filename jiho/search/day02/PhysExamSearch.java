package com.company.search.day02.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/10
 * Time: 10:50 PM
 * des : 내림차순으로 정렬된 객체 배열 이진탐색. Comparator 인터페이스 구현.
 */
public class PhysExamSearch {

    // 신체 검사 데이터 정의
    static class PhyscData {

        private String name; // 이름
        private int height; // 키
        private double vision; // 시력

        // PhyscData 클래스 생성자
        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        // toString overriding
        public String toString() {
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
        public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {

            // 키를 기준으로 값을 식별
            @Override
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.height > d2.height) ? 1 :
                        (d1.height < d2.height) ? -1 : 0;
            }

        }

        private static class VisionOrderComparator implements Comparator<PhyscData> {

            // 시력을 기준으로 값을 식별!
            // 시력을 기준으로 식별 할 경우에는 시력 데이터들이 내림차순으로 정렬된 상태에서 이진탐색을 수행하게 되게끔 작성 하였기 때문에
            // d1이 d2보다 클 때 -1 반환, d1이 d2보다 작을 때 1 반환.
            // 오름차순과 반대로 compare 메서드의 리턴 값 구현.
            @Override
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.vision > d2.vision) ? -1 :
                        (d1.vision < d2.vision) ? 1 : 0;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

//        PhyscData[] x = {
//                new PhyscData("이나령", 162, 0.3),
//                new PhyscData("유지훈", 168, 0.4),
//                new PhyscData("김한결", 169, 0.8),
//                new PhyscData("홍준기", 171, 1.5),
//                new PhyscData("전서현", 173, 0.7),
//                new PhyscData("이호연", 174, 1.2),
//                new PhyscData("이수민", 175, 2.0),
//        };

        PhyscData[] x = {
                new PhyscData("이나령", 162, 2.0),
                new PhyscData("유지훈", 168, 1.8),
                new PhyscData("김한결", 169, 1.6),
                new PhyscData("홍준기", 171, 1.6),
                new PhyscData("전서현", 173, 0.7),
                new PhyscData("이호연", 174, 0.5),
                new PhyscData("이수민", 175, 0.3),
        };

        // System.out.print("몇 cm인 사람을 찾고 있나요? : ");
        // int height = scan.nextInt();

        System.out.print("시력이 몇 인 사람을 찾고 있나요? : ");
        double vision = scan.nextDouble();

        //int idx = Arrays.binarySearch(x, new PhyscData("", height, 0.0), PhyscData.HEIGHT_ORDER);
        int idx = Arrays.binarySearch(x, new PhyscData("", 0, vision), PhyscData.VISION_ORDER);

        if (idx < 0) {
            System.out.println("찾는 요소가 없습니다.");
        } else {
            System.out.println("x[" + idx + "] 에 있습니다.");
            System.out.println("찾은 데이터 : " + x[idx]);
        }
    }
}