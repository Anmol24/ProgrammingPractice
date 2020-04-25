package com.anmol.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

interface MySystem {
    void setTimer(long durationMillis, Runnable callback);
    long getCurrentTimeMillis();
    void addTimer(long durationMillis, Runnable callback);
}
abstract class AbstractMySystem implements MySystem {
    private final NavigableMap<Long, List<Runnable>>
            callbacks = new TreeMap<>();
    @Override
    public void addTimer(long durationMillis, Runnable callback) {
        synchronized (callbacks) {
            assert durationMillis >= 0;
            long scheduledTime = getCurrentTimeMillis() + durationMillis;
            callbacks.computeIfAbsent(scheduledTime, t -> new ArrayList<>()).add(callback);
            reschedule();
        }
    }
    private void reschedule() {
        synchronized (callbacks) {
            final Long next = callbacks.firstKey();
            if (next != null) {
                setTimer(Math.max(0, next - getCurrentTimeMillis()), () -> {
                    synchronized (callbacks) {
                        for (Runnable runnable : callbacks.get(next)) {
                            setTimer(0, runnable);
                        }
                        callbacks.remove(next);
                        reschedule();
                    }
                });
            }
        }
    }
}
