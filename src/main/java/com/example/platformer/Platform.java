package com.example.platformer;

import javafx.scene.shape.Rectangle;

public class Platform {
    private Rectangle platformRect;

    public Platform (Rectangle platformRect){
        this.platformRect = platformRect;

    }

    public Rectangle getPlatformRect() {
        return platformRect;
    }
}
