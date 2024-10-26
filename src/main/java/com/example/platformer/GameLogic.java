package com.example.platformer;
import javafx.animation.AnimationTimer;

import javafx.scene.Scene;

public class GameLogic extends AnimationTimer{

    private GameScene gameScene;
    private int numJumps = 0;
    private Player player;
    private Platform[] platforms;
    private MovingPlatform[] movingPlatforms;
    private Scene scene;
    private Enemy[] enemies;
    private boolean isRunning = true;

    public GameLogic(GameScene gameScene, Player player,Platform[] platforms, Enemy[] enemies, MovingPlatform[] movingPlatforms){
        this.gameScene = gameScene;
        this.player = player;
        this.platforms = platforms;
        this.enemies = enemies;
        this.movingPlatforms = movingPlatforms;
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
                    if (numJumps <= 1){
                        player.jump();
                        numJumps++;
                    }
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
        for (Enemy enemy : enemies) {
            enemy.update();
        }
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
        for (Platform platform : platforms) {
            if (player.getPlayerRect().getBoundsInParent().intersects(platform.getPlatformRect().getBoundsInParent())) {
                double penetrationDepth = player.getPlayerRect().getY() + player.getPlayerRect().getHeight() - platform.getPlatformRect().getY();
                player.getPlayerRect().setY(player.getPlayerRect().getY() - penetrationDepth);
                player.setYSpeed(0);
                numJumps = 0;
            }
        }

        for (Enemy enemy : enemies) {
            if (player.getPlayerRect().getBoundsInParent().intersects(enemy.getEnemyRect().getBoundsInParent())) {
                respawnPlayer();
            }
        }

        for (MovingPlatform movingPlatform : movingPlatforms) {
            if (!movingPlatform.isVertical()){
                if (player.getPlayerRect().getBoundsInParent().intersects(movingPlatform.getPlatformRect().getBoundsInParent())) {
                    double penetrationDepth = player.getPlayerRect().getY() + player.getPlayerRect().getHeight() - movingPlatform.getPlatformRect().getY();
                    player.getPlayerRect().setY(player.getPlayerRect().getY() - penetrationDepth);
                    player.setYSpeed(0);
                    numJumps = 0;


                    player.getPlayerRect().setX(player.getPlayerRect().getX() + (movingPlatform.isMovingRight() ? movingPlatform.getPlatSpeed() : -movingPlatform.getPlatSpeed()));
                }
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
