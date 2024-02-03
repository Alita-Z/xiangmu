/*
 * FXGL - JavaFX Game Library. The MIT License (MIT).
 * Copyright (c) AlmasB (almaslvl@gmail.com).
 * See LICENSE for details.
 */

package com.example.hardcoredemo.modular.fxgl;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.settings.GameSettings;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.math.BigDecimal;

/**
 * Shows how to use JavaFX UI within FXGL.
 */
public class TestSample extends GameApplication {

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setTitle("Hi IT青年 Game");
        settings.setWidth(480);
        settings.setHeight(320);
        settings.setVersion("0.1");
    }

    // 实体类型
    private enum Type {
        PLAYER;
    }
    // 玩家
    private Entity player;
    @Override
    protected void initGame() {
        player = Entities.builder()
                .type(Type.PLAYER) // 实体类型为玩家
                .at(200, 120) // 初始化位置
                .viewFromNodeWithBBox(new Circle(20, Color.color(0.4, 0.7, 0.3, 0.3)))
//                .view(new Rectangle(50,50)) // 实体造型
                .buildAndAttach(); // 构造并添加到游戏世界中
    }
    @Override
    protected void initUI() {
        Text textPixels = new Text();
        textPixels.setTranslateX(50); // x = 50
        textPixels.setTranslateY(100); // y = 100

        FXGL.getApp().getGameScene().addUINode(textPixels); // add to the scene graph
    }


    public static void main(String[] args) {
        launch(args);
    }
}
