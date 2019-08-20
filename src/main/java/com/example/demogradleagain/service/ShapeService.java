package com.example.demogradleagain.service;

import com.example.demogradleagain.model.Shape;
import org.springframework.stereotype.Service;

public class ShapeService {
    private Shape circle;
    private Shape square;

    public ShapeService(Shape circle, Shape square) {
        this.circle = circle;
        this.square = square;
    }

    public Shape getCircle() {
        return circle;
    }

    public void setCircle(Shape circle) {
        this.circle = circle;
    }

    public Shape getSquare() {
        return square;
    }

    public void setSquare(Shape square) {
        this.square = square;
    }
}
