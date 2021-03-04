package com.gmail.leonovec.igor.interview.tango;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * The same as {@link UserStats}, but for the case if lazy init of {@link LazyUserStats#hitsPerUser} required
 */
public class LazyUserStats {

    private volatile Map<String, LongAdder> hitsPerUser;
    private final Object monitor = new Object();

    public void onUserCall(String userId) {
        initMapIfRequired();
        hitsPerUser.computeIfAbsent(userId, key -> new LongAdder()).increment();
    }

    private void initMapIfRequired() {
        if (hitsPerUser == null) {
            synchronized (monitor) {
                if (hitsPerUser == null) {
                    hitsPerUser = new ConcurrentHashMap<>();
                }
            }
        }
    }
}
