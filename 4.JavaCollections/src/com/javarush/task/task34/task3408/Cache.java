package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public K getKey() {
        return null;
    }
    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V o = cache.get(key);
        if (o == null) {
            V newV = (V) clazz.getDeclaredConstructor(key.getClass()).newInstance(key);
            cache.put(key, newV);
            return cache.get(key);
        } else {
            return o;
        }
    }

    public boolean put(V obj) {
        //TODO add your code here
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey", null);
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            cache.put(key, obj);
            return true;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
