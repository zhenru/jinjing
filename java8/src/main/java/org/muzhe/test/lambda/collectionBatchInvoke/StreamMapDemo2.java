package org.muzhe.test.lambda.collectionBatchInvoke;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author muzhe-wang on  18-7-20 上午10:36.
 */
public class StreamMapDemo2 {

    public static void main(String[] args) {

        List<String> list = generateList();
        Map<Integer, Integer> collectMap = list.stream()
                .map(e -> new Integer(e))
                .filter(e -> e > 20)
                .collect(Collectors.groupingBy(p -> p, Collectors.summingInt(p -> 1)));

        collectMap.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    private static List<String> generateList() {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
            list.add(String.valueOf(i + 1));
        }
        return list;
    }
}
