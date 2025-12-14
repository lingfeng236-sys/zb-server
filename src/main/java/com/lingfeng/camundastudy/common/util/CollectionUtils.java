package com.lingfeng.camundastudy.common.util;

import org.springframework.lang.Nullable;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionUtils extends org.springframework.util.CollectionUtils {


    public static boolean isNotEmpty(@Nullable Collection<?> collection) {
        return !org.springframework.util.CollectionUtils.isEmpty(collection);
    }

    public static boolean isNotEmpty(@Nullable Map<?, ?> map) {
        return !org.springframework.util.CollectionUtils.isEmpty(map);
    }

    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 对传入的集合进行去空与去重，返回一个{@link List}<{@link T}>集合
     *
     * @param coll 集合
     * @return {@link List}<{@link T}>
     */
    public static <T> List<T> distinct(Collection<T> coll) {
        if (CollectionUtils.isEmpty(coll)) {
            return new ArrayList<>();
        }
        return coll.stream().filter(StrUtils::isNotNull).distinct().collect(Collectors.toList());
    }

    /**
     * 对传入的数组进行去空与去重，返回一个{@link List}<{@link T}>集合
     *
     * @param arr 数组
     * @return {@link List}<{@link T}>
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] distinct(T[] arr) {
        if (CollectionUtils.isEmpty(arr)) {
            return arr;
        }
        return (T[]) Arrays.stream(arr).filter(StrUtils::isNotNull).distinct().toArray();
    }

    public static <T> T get(T[] array, int index) {
        return get(array, index, null);
    }

    public static <T> T get(T[] array, int index, T defaultValue) {
        return isArrayIndexValid(array, index) ? array[index] : defaultValue;
    }

    public static <T> boolean isArrayIndexValid(T[] array, int index) {
        return index >= 0 && getLength(array) > index;
    }

    public static int getLength(Object array) {
        return array == null ? 0 : Array.getLength(array);
    }
}
