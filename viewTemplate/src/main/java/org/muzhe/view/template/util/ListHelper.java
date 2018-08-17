package org.muzhe.view.template.util;

import org.muzhe.view.template.model.ConfModelTree;

import java.util.*;

/**
 * @author muzhe-wang on  18-8-6 下午5:02.
 */
public class ListHelper {

    /**
     * 将一个对象转变为一个　List
     *
     * @param elements 对象列表
     * @param <T>
     * @return
     */
    public static <T> List<T> safeAssembleList(T... elements) {
        if (elements == null) {
            return Collections.emptyList();
        }
        List<T> result = new ArrayList<>(elements.length);
        result.addAll(Arrays.asList(elements));
        return result;
    }

    public static <T> int safeSize(List<T> elements) {
        return Optional.ofNullable(elements)
                .orElse(Collections.emptyList())
                .size();
    }

    /**
     * 判断list的空间为ｎｕｌｌ。
     * @param unVisit
     * @param <T>
     * @return
     */
    public static <T> boolean isEmpty(List<T> unVisit) {

        return unVisit == null || unVisit.size() == 0;
    }
}
