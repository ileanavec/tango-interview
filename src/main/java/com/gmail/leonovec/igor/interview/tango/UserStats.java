package com.gmail.leonovec.igor.interview.tango;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class UserStats {

    private final Map<String, LongAdder> hitsPerUser = new ConcurrentHashMap<>();

    public void onUserCall(String userId) {
        hitsPerUser.computeIfAbsent(userId, key -> new LongAdder()).increment();
    }
}
