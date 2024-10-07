package com.example.platformer;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player {
    private Rectangle playerRect;
    private double xSpeed = 0;
    private double ySpeed = 0;
    private double gravity = 0.5;
    Color playerColor;

    public Player(Rectangle playerRect) {
        this.playerRect = playerRect;
        playerColor = Color.GRAY;
        playerRect.setFill(playerColor);
    }


    public void moveLeft() {
        xSpeed = -5;
    }

    public void moveRight() {
        xSpeed = 5;
    }

    public void jump() {
        ySpeed = -10;
    }

    public void update() {
        playerRect.setX(playerRect.getX() + xSpeed);
        playerRect.setY(playerRect.getY() + ySpeed);
        ySpeed += gravity;
    }

    public Rectangle getPlayerRect() {
        return playerRect;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }
}