package org.muzhe.test.lambda.collectionBatchInvoke;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author muzhe-wang on  18-7-19 下午6:53.
 */
public class StreamMapDemo {


    public static void main(String[] args) {
        List<String> list = generateIngeterList();

        List<Integer> resultList = list.stream()
                .map(e -> new Integer(e)) //使用map将当前系统中中的String转变为　Integer
                .filter(e -> e > 10) //使用filter过滤掉那些不需要的对象
                .distinct() //将重复的值去掉
                .collect(Collectors.toList());//使用collect将一个对象分散的数据收集到一个List中去
        resultList.forEach(e -> System.out.println(e));

        System.out.println("=====================================将当前的Ｌist转变为　Ｍap进行处理　=======================================");
        Map<Integer, Integer> resultMap = list.stream()
                .map(e -> Integer.valueOf(e))
                .filter(e -> e % 2 == 0)
                .distinct()
                .collect(Collectors.toMap(e -> e, e -> e * 2));

        resultMap.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });

    }

    private static List<String> generateIngeterList() {

        List<String> integerList = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            integerList.add(String.valueOf(i));
            integerList.add(String.valueOf(i + 1));
        }
        return integerList;
    }


}
