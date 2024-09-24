package com.example.platformer;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameScene {
    private Scene scene;
    private Pane root;
    private double width;
     private double height;

     public GameScene(Pane root, double width, double height){
        this.root = root;
        this.scene = new Scene(root, width, height);
        this.width = width;
        this.height = height;

     }

     public Scene getScene(){
         return scene;
     }

    public double getWidth() {
        return  width;
    }

    public double getHeight(){
         return height;
    }
}
