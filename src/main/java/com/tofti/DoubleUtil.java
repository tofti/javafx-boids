package com.tofti;

public class DoubleUtil {
    public static double signSensitiveMax(double d, double maxAbsValue) {
        if(d > 0d) {
            return Math.min(d, Math.abs(maxAbsValue));
        }
        return Math.max(d, -Math.abs(maxAbsValue));
    }
}
