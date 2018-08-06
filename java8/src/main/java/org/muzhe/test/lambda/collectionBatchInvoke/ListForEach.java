package org.muzhe.test.lambda.collectionBatchInvoke;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muzhe-wang on  18-7-19 下午6:15.
 */
public class ListForEach {

    public static void main(String[] args) {

        List<Integer> list = generateList();
//        使用原有语法糖访问当前的　list.
        for (Integer num : list) {
            System.out.println(num);
        }

        System.out.println("----------------------------------------------------");

//         lambda的实现方式
        list.forEach(o -> {
            System.out.println(o);
        });
    }

    private static List<Integer> generateList() {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        return list;

    }
}
