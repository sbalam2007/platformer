package com.example.platformer;
import javafx.animation.AnimationTimer;

import javafx.scene.Scene;

public class GameLogic extends AnimationTimer{
    private GameScene gameScene;
    private Player player;
    private Platform[] platforms;
    private Scene scene;
    private boolean isRunning = true;

    public GameLogic(GameScene gameScene, Player player,Platform[] platforms){
        this.gameScene = gameScene;
        this.player = player;
        this.platforms = platforms;
        this.scene = gameScene.getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case LEFT:
                    player.moveLeft();
                    break;
                case RIGHT:
                    player.moveRight();
                    break;
                case SPACE, UP:
                    player.jump();
                    break;

            }

        });
        scene.setOnKeyReleased(event -> {
            switch (event.getCode()){
                case LEFT:
                case RIGHT:
                    player.setXSpeed(0);
                    break;
                

            }

        });

       
    }

    @Override
    public void handle(long now) {
        if (isRunning){
            update();
        }

    }

    private void update(){
        player.update();
        double cameraX = player.getPlayerRect().getX() - 120;
        gameScene.setTranslateX(-cameraX);
        double cameraY = player.getPlayerRect().getY() - 200;
        gameScene.setTranslateY(-cameraY);
        if (player.getPlayerRect().getY() + player.getPlayerRect().getHeight() < -2000 ){
            respawnPlayer();
        }
        if (player.getPlayerRect().getY() + player.getPlayerRect().getHeight() > 2000 ){
            respawnPlayer();
        }
        checkCollisions();

    }

    private void respawnPlayer(){
        player.getPlayerRect().setX(100);
        player.getPlayerRect().setY(100);
    }

    private void checkCollisions(){
        for (Platform platform: platforms){
            if (player.getPlayerRect().getBoundsInParent().intersects(platform.getPlatformRect().getBoundsInParent())) {
                player.setYSpeed(0);
            }

        }

    }

    public void start(){
        isRunning = true;
        super.start();
    }

    public void stop(){
        isRunning = false;
        super.stop();
    }
}
