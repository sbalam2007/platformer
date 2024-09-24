package com.example.platformer;
//can you make a moving platformer class? I feel like it would be pretty cool

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
