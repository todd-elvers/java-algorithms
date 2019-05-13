package te.interview.prep;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/lru-cache/">Problem on leetcode</a>
 */
//TODO: Review this and make it O(1) by using doubly-linked list + map of int->node
public class LRUCache {
    private int clock;
    private int capacity;
    private Map<Integer, TimeAwareValue> cache;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.capacity = capacity;
        this.clock = 0;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;

        TimeAwareValue cachedValue = cache.get(key);
        cachedValue.lastTimeUsed = ++clock;
        cache.put(key, cachedValue);

        return cachedValue.value;
    }

    public void put(int key, int value) {
        // Edge case: only evict the LRU if we're at capacity and don't already have an entry for `key`
        if(!cache.containsKey(key) && cache.size() == capacity) {
            evictLeastRecentlyUsedValue();
        }

        cache.put(key, new TimeAwareValue(value, ++clock));
    }

    private void evictLeastRecentlyUsedValue() {
        Integer keyToLRU = cache.entrySet().stream()
                .reduce((e1, e2) -> e1.getValue().lastTimeUsed > e2.getValue().lastTimeUsed ? e2 : e1)
                .map(Map.Entry::getKey)
                .get();

        cache.remove(keyToLRU);
    }

    private static class TimeAwareValue {
        int value, lastTimeUsed;
        TimeAwareValue(int value, int lastTimeUsed) {
            this.value = value;
            this.lastTimeUsed = lastTimeUsed;
        }

    }
}
