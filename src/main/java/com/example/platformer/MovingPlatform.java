package com.example.platformer;

import javafx.scene.shape.Rectangle;

public class MovingPlatform extends Platform{
    private Rectangle platformRect;
    private boolean moveRight;
    private int distanceMoved;
    private final int MOVE_SPACES;
    private final int plat_Speed = 2;
    public MovingPlatform(int x, int y, int width, int height, int MOVE_SPACES) {
        super(new Rectangle(x, y, width, height));
        this.platformRect = getPlatformRect();
        moveRight = true;
        this.MOVE_SPACES = MOVE_SPACES;

    }

    public void movePlatform() {
        if (moveRight) {
            platformRect.setX(platformRect.getX() + plat_Speed);
        } else {
            platformRect.setX(platformRect.getX() - plat_Speed);
        }

        distanceMoved += plat_Speed;

        if (distanceMoved >= MOVE_SPACES) {
            moveRight = !moveRight;
            distanceMoved = 0;
        }
    }
}
