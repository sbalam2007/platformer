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

        //list all platforms here
        Platform[] platforms = {platform1};

        GameLogic gameLoop = new GameLogic(gameScene, player, platforms);
        gameLoop.start();
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
