package com.LeiLei.Snake;

import java.awt.*;

import static com.LeiLei.util.config.*;

public abstract class BasicSnake {
    //方向
    private int Dir;
    //位置
    private int x, y;
    //绘制
    public abstract void paint(Graphics g);

    public void move(){
        switch (Dir){
            case DIR_UP-> this.y -= GRID_WIDTH;
            case DIR_DOWN-> this.y += GRID_WIDTH;
            case DIR_LEFT-> this.x -= GRID_WIDTH;
            case DIR_RIGHT-> this.x += GRID_WIDTH;
        }
    }

    public void setDir(int dir) {
        Dir = dir;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDir() {
        return Dir;
    }
}
