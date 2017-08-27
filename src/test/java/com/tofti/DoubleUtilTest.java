package com.tofti;

import org.junit.Assert;
import org.junit.Test;

public class DoubleUtilTest {
    private static double TOLERANCE = 1E-6;
    @Test
    public void testMaxSignInsensitive() {
        Assert.assertEquals(DoubleUtil.signSensitiveMax(5.0d, 10.d), 5d, TOLERANCE);
        Assert.assertEquals(DoubleUtil.signSensitiveMax(10.0d, 10.d), 10.0d, TOLERANCE);
        Assert.assertEquals(DoubleUtil.signSensitiveMax(11.0d, 10.d), 10.0d, TOLERANCE);

        Assert.assertEquals(DoubleUtil.signSensitiveMax(-5.0d, -10.d), -5d, TOLERANCE);
        Assert.assertEquals(DoubleUtil.signSensitiveMax(-10.0d, -10.d), -10.0d, TOLERANCE);
        Assert.assertEquals(DoubleUtil.signSensitiveMax(-11.0d, -10.d), -10.0d, TOLERANCE);
    }

}