package ru.geegbrains.java02.lesson_01;

import java.awt.*;

// Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
public class Background extends Sprite {
    public final Color color;

    Background() {
        color = new Color(
                (int) (Math.random() * 255), //r
                (int) (Math.random() * 255), //g
                (int) (Math.random() * 255)  //b
        );
    }



    public Color getColor() {
        return color;
    }





    @Override
    public void update(GameCanvas canvas, float deltaTime) {


    }

    @Override
    public void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());

    }



}

