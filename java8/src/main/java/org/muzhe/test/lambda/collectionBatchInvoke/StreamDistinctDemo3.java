package org.muzhe.test.lambda.collectionBatchInvoke;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author muzhe-wang on  18-7-20 上午10:47.
 */
public class StreamDistinctDemo3 {

    public static void main(String[] args) {

        List<String> result = generateList();
        System.out.println("================================================parallelStream===================================");
        long current = System.currentTimeMillis();
        Map<Integer, Integer> collectMap = result.parallelStream()
                .map(e -> new Integer(e))
                .filter(e -> e % 2 == 0)
                .collect(Collectors.groupingBy(p -> p, Collectors.summingInt(p -> 1)));
        System.out.println("taste the time = " + (System.currentTimeMillis() - current));

        System.out.println("================================================Stream===================================");
         current = System.currentTimeMillis();
        Map<Integer, Integer> collectMap2 = result.stream()
                .map(e -> new Integer(e))
                .filter(e -> e % 2 == 0)
                .collect(Collectors.groupingBy(p -> p, Collectors.summingInt(p -> 1)));
        System.out.println("taste the time = " + (System.currentTimeMillis() - current));
    }

    private static List<String> generateList() {

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            stringList.add(String.valueOf(i));
            stringList.add(String.valueOf(i + 1));
        }
        return stringList;

    }

}
