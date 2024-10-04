package com.example.platformer;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Enemy {
    private Rectangle enemyRect;
    double xSpeed = 2;
    double ySpeed = 0;
    double gravity = 0.5;
    Platform platform;
    Player player;
    Color color;

    public Enemy(Rectangle enemyRect, Platform platform, Player player){
        this.enemyRect = enemyRect;
        this.platform = platform;
        this.player = player;
        color = Color.RED;
        enemyRect.setFill(color);
    }
    public Rectangle getEnemyRect(){
        return enemyRect;
    }

    public void update(){
        if (enemyRect.getX() <= platform.getPlatformRect().getX()){
            xSpeed = 2;
        }
        else if (enemyRect.getX() + enemyRect.getWidth() >= platform.getPlatformRect().getX() + platform.getPlatformRect().getWidth()) {
            xSpeed = -2;
        }

        enemyRect.setX(enemyRect.getX() + xSpeed);
        
    }





}
