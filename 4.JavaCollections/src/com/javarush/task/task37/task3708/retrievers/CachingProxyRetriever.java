package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private OriginalRetriever originalRetriever;
    private LRUCache cache;

    public CachingProxyRetriever(Storage storage) {
        this.originalRetriever = new OriginalRetriever(storage);
        cache = new LRUCache(16);
    }

    public Object retrieve(long id) {
        Object cached = cache.find(id);
        if (cached == null) {
            cached = originalRetriever.retrieve(id);
            cache.set(id, cached);
        }

       return cached;
    }

    
}
