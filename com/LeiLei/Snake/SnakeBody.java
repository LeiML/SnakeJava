package com.LeiLei.Snake;

import java.awt.*;

import static com.LeiLei.util.config.BODY;
import static com.LeiLei.util.config.GRID_WIDTH;

public class SnakeBody extends BasicSnake{
    public SnakeBody(){
        this.setDir(0);
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(BODY);
        g.fillRect(this.getX()-GRID_WIDTH/2, this.getY()-GRID_WIDTH/2, GRID_WIDTH, GRID_WIDTH);
    }
}
