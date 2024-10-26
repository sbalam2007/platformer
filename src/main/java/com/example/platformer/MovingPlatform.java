package com.example.platformer;

import javafx.scene.shape.Rectangle;

public class MovingPlatform extends Platform{
    private boolean vertical = false;
    private Rectangle platformRect;
    private boolean moveRight;
    private boolean moveUp;
    private int distanceMoved;
    private final int MOVE_SPACES;
    private final int plat_Speed = 2;
    public MovingPlatform(int x, int y, int width, int height, int MOVE_SPACES, boolean vertical) {
        super(new Rectangle(x, y, width, height));
        this.platformRect = getPlatformRect();
        this.vertical = vertical;
        moveRight = true;
        moveUp = true;
        this.MOVE_SPACES = MOVE_SPACES;

    }

    public void movePlatform() {
        if (!vertical){
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
        else {
            if (moveUp){
                platformRect.setY(platformRect.getY() + plat_Speed);
            }
            else {
                platformRect.setY(platformRect.getY() - plat_Speed);
            }
            distanceMoved += plat_Speed;

            if (distanceMoved >= MOVE_SPACES) {
                moveUp = !moveUp;
                distanceMoved = 0;
            }
        }
    }
}
