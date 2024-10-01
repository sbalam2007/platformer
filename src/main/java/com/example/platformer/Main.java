package com.example.platformer;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.scene.layout.Pane;
public class Main extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {


        Pane root = new Pane();
        GameScene gameScene = new GameScene(root, 600, 400);
        Scene scene = gameScene.getScene();

        Rectangle playerRect = new Rectangle(50, 50, 20, 20);
        root.getChildren().add(playerRect);

        Player player = new Player(playerRect);


        Rectangle platformRect1 = new Rectangle(50, 300, 200, 20);
        root.getChildren().add(platformRect1);
        Platform platform1 = new Platform(platformRect1);

        Rectangle platformRect2 = new Rectangle(300, 250, 200, 20);
        root.getChildren().add(platformRect2);

        Platform platform2 = new Platform(platformRect2);

        Rectangle platformRect3 = new Rectangle(450, 200, 200, 20);
        root.getChildren().add(platformRect3);

        Platform platform3 = new Platform(platformRect3);

        Rectangle platformRect4 = new Rectangle(600, 350, 200, 20);
        root.getChildren().add(platformRect4);

        Platform platform4 = new Platform(platformRect4);

        MovingPlatform movingPlatform = new MovingPlatform(900, 300, 200, 20, 200);
        root.getChildren().add(movingPlatform.getPlatformRect());

        Rectangle platformRect5 = new Rectangle(1300, 400, 200, 20);
        root.getChildren().add(platformRect5);
        Platform platform5 = new Platform(platformRect5);




        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                movingPlatform.movePlatform();
            }
        };
        timer.start();
        //list all platforms here
        Platform[] platforms = {platform1, platform2, platform3, platform4, movingPlatform, platform5};

        GameLogic gameLoop = new GameLogic(gameScene, player, platforms);
        gameLoop.start();
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
