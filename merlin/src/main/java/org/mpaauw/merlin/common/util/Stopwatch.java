package org.mpaauw.merlin.common.util;

public class Stopwatch {

    private long startTime = 0;
    private long stopTime = 0;

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
    }

    public void reset() {
        this.startTime = 0;
        this.stopTime = 0;
    }

    public long getElapsedTimeMs() {
        return this.stopTime - this.startTime;
    }

}
