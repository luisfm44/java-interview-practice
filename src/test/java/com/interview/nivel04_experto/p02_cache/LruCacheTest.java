package com.interview.nivel04_experto.p02_cache;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Evaluación del reto; activa con -Pretos -Dtest=LruCacheTest. */
@Tag("reto")
class LruCacheTest {
    @Test void readsAffectEvictionOrder() {
        var cache = new LruCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        assertEquals(10, cache.get(1));
        cache.put(3, 30);
        assertEquals(-1, cache.get(2));
        assertEquals(10, cache.get(1));
        assertEquals(30, cache.get(3));
    }

    @Test void updatesDoNotIncreaseSizeAndRefreshRecency() {
        var cache = new LruCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(1, 99);
        cache.put(3, 30);
        assertEquals(99, cache.get(1));
        assertEquals(-1, cache.get(2));
        assertEquals(-1, cache.get(99));
        cache.put(4, 40);
        assertEquals(-1, cache.get(3));
    }

    @Test void supportsCapacityOneAndRejectsInvalidCapacity() {
        var cache = new LruCache(1);
        cache.put(-5, 0);
        assertEquals(0, cache.get(-5));
        cache.put(2, 7);
        assertEquals(-1, cache.get(-5));
        assertEquals(7, cache.get(2));
        assertThrows(IllegalArgumentException.class, () -> new LruCache(0));
        assertThrows(IllegalArgumentException.class, () -> new LruCache(-1));
    }
}
