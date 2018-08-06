package org.muzhe.test.lambda.collectionBatchInvoke;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muzhe-wang on  18-7-19 下午6:20.
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<Shape> shapeList = generateList();
        shapeList.stream().filter(shape -> shape.getHigh() >= 2).forEach(shape -> System.out.println(shape));

        System.out.println("filter the info and set the high num ...");

        List<Integer> highList = new ArrayList<>();
        shapeList.stream().filter(shape -> shape.getHigh() <= 5).forEachOrdered(shape -> {
            System.out.println(shape);
            highList.add(shape.getHigh());
        });
        System.out.println(highList);
    }


    private static List<Shape> generateList() {

        List<Shape> shapeList = new ArrayList<Shape>();
        shapeList.add(Shape.builder().high(12).length(12).build());
        shapeList.add(Shape.builder().high(1).length(2).build());
        shapeList.add(Shape.builder().high(2).length(3).build());
        shapeList.add(Shape.builder().high(3).length(4).build());
        shapeList.add(Shape.builder().high(4).length(5).build());
        return shapeList;

    }


    @Data
    @Builder
    private static class Shape {

        private int length;

        private int high;

    }

}
