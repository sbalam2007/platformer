package com.example.platformer;
import javafx.animation.AnimationTimer;

import javafx.scene.Scene;

public class GameLogic extends AnimationTimer{
    public GameLogic(GameScene gameScene, Player player,Platform[] platforms){
        this.gameScene = gameScene;
        this.player = player;
        this.scene = scene gameScene.getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case LEFT:
                    player.moveLeft();
                    break;
                case RIGHT:
                    player.moveright();
                    break;
                case SPACE, UP:
                    player.jump();
                    break;

            }

        });
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case LEFT:
                case RIGHT:
                    player.setXSpeed(0);
                    break;
                

            }

        });

       
    }

    @Override
    public void handle(long l) {

    }
}
