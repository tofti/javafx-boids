package com.tofti;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Vector2DTest extends TestCase {

    private static double TOLERANCE = 1E-6;

    @Test
    public void testGetArithmeticMean() {
        Vector2D x1  = Vector2D.getArithmeticMean(Arrays.asList(new Vector2D(2d, 2d), new Vector2D(4d, 4d)));
        Assert.assertEquals(x1.getX(), 3d, TOLERANCE);
        Assert.assertEquals(x1.getY(), 3d, TOLERANCE);

        Vector2D x2  = Vector2D.getArithmeticMean(Arrays.asList(new Vector2D(-2d, -2d), new Vector2D(2d, 2d)));
        Assert.assertEquals(x2.getX(), 0d, TOLERANCE);
        Assert.assertEquals(x2.getY(), 0d, TOLERANCE);
    }


    @Test
    public void testNormalize() {
        Assert.assertEquals(new Vector2D(10d, 0d).normalize().getX(), 1.0, TOLERANCE);
        Assert.assertEquals(new Vector2D(10d, 0d).normalize().getY(), 0.0, TOLERANCE);
        Assert.assertEquals(new Vector2D(0d, 10d).normalize().getX(), 0.0, TOLERANCE);
        Assert.assertEquals(new Vector2D(0d, 10d).normalize().getY(), 1.0, TOLERANCE);

        Assert.assertEquals(new Vector2D(3d, 4d).normalize().getX(), 0.6, TOLERANCE);
        Assert.assertEquals(new Vector2D(3d, 4d).normalize().getY(), 0.8, TOLERANCE);

        Assert.assertEquals(new Vector2D(-3d, -4d).normalize().getX(), -0.6, TOLERANCE);
        Assert.assertEquals(new Vector2D(-3d, -4d).normalize().getY(), -0.8, TOLERANCE);

        Assert.assertEquals(new Vector2D(3d, 4d).normalize().getMagnitude(), 1d, TOLERANCE);
        Assert.assertEquals(new Vector2D(-3d, -4d).normalize().getMagnitude(), 1d, TOLERANCE);

        Assert.assertEquals(new Vector2D(0d, 0d).normalize().getX(), 0d, TOLERANCE);
        Assert.assertEquals(new Vector2D(0d, 0d).normalize().getY(), 0d, TOLERANCE);

        Assert.assertEquals(new Vector2D(3d, 4d).normalizeTo(2d).getX(), 1.2, TOLERANCE);
        Assert.assertEquals(new Vector2D(3d, 4d).normalizeTo(2d).getY(), 1.6, TOLERANCE);
    }

    @Test
    public void testGetMagnitude() {
        Assert.assertEquals(new Vector2D(2d, 2d).getMagnitude(), 2.82842712, TOLERANCE);
        Assert.assertEquals(new Vector2D(-2d, 2d).getMagnitude(), 2.82842712, TOLERANCE);
        Assert.assertEquals(new Vector2D(-2d, -2d).getMagnitude(), 2.82842712, TOLERANCE);
        Assert.assertEquals(new Vector2D(2d, -2d).getMagnitude(), 2.82842712, TOLERANCE);
        Assert.assertEquals(new Vector2D(3d, -2d).getMagnitude(), 3.60555127546, TOLERANCE);
        Assert.assertEquals(new Vector2D(-3d, -2d).getMagnitude(), 3.60555127546, TOLERANCE);
        Assert.assertEquals(new Vector2D(-3d, -2d).getMagnitude(), 3.60555127546, TOLERANCE);
        Assert.assertEquals(new Vector2D(3d, -2d).getMagnitude(), 3.60555127546, TOLERANCE);
    }

    @Test
    public void testDistanceBetween() {
        Assert.assertEquals(new Vector2D(2d, 2d).getDistanceFrom(new Vector2D(3d,3d)), Math.sqrt(2d), 0.01);
        Assert.assertEquals(new Vector2D(-2d, -2d).getDistanceFrom(new Vector2D(-3d,-3d)), Math.sqrt(2d), 0.01);
        Assert.assertEquals(new Vector2D(-3d, -4d).getDistanceFrom(new Vector2D(3d,3d)), 9.219544457292887, 0.01);
    }
}