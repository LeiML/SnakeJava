package com.LeiLei.Snake;

import java.awt.*;
import static com.LeiLei.util.config.*;

public class SnakeHead extends BasicSnake {
    public SnakeHead(){
        this.setX(BASE_BIAS+GRID_WIDTH/2);
        this.setY(BASE_BIAS+GRID_WIDTH/2);
        this.setDir(DIR_RIGHT);
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(HEAD);
        g.fillOval(this.getX()-GRID_WIDTH/2, this.getY()-GRID_WIDTH/2, GRID_WIDTH, GRID_WIDTH);
    }
}
