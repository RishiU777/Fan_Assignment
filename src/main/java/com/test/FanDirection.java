package com.test;

public enum FanDirection {
    CLOCKWISE, ANTI_CLOCKWISE;

    public FanDirection reverse() {
        return this == CLOCKWISE ? ANTI_CLOCKWISE : CLOCKWISE;
    }
}
