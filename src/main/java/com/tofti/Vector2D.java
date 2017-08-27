package com.tofti;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector2D plus(Vector2D arg) {
        return new Vector2D(x + arg.getX(), y + arg.getY());
    }

    public Vector2D minus(Vector2D arg) {
        return new Vector2D(x - arg.getX(), y - arg.getY());
    }

    public Vector2D wrapAround(double xLimit, double yLimit) {
        double wx = x > xLimit ? x - xLimit : x;
        wx = wx < 0 ? xLimit - wx : wx;

        double wy  = y > yLimit ? y - yLimit : y;
        wy = wy < 0 ? yLimit - wy  : wy;

        return new Vector2D(wx, wy);
    }

    public static Vector2D getArithmeticMean(Collection<? extends Vector2D> input) {
        double sumX = 0d;
        double sumY = 0d;
        for(Vector2D i : input) {
            sumX += i.getX();
            sumY += i.getY();
        }
        return new Vector2D(sumX / (double)input.size(), sumY / (double)input.size());
    }

    public double getDistanceFrom(Vector2D other) {
        return getDistanceBetween(this, other);
    }

    public Vector2D normalize() {
        return normalizeTo(1d);
    }

    public Vector2D normalizeTo(double to) {
        double magnitude = getMagnitude();
        if(0d == magnitude) {
            return new Vector2D(0d, 0d);
        }
        double xi = x / magnitude * to;
        double yi = y / magnitude * to;
        Vector2D n = new Vector2D(xi, yi);
        return n;
    }

    public double getMagnitude() {
        double m = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return m;
    }

    public static double getDistanceBetween(Vector2D a, Vector2D b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static List<Vector2D> withinDistanceOf(final List<Vector2D> vectors, final Vector2D from,
                                                  final double distance) {
        return vectors.stream().filter(v -> v.getDistanceFrom(from) <= distance).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
