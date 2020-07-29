package com.LeiLei.Food;
import static com.LeiLei.util.config.*;
import java.awt.*;

public class Food {

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private final int x;
    private final int y;
    private final Color foodColor;

    public Food(){
        this.x = RandomNum(0, GRID_ROW-1) * GRID_WIDTH + BASE_BIAS + GRID_WIDTH / 2;
        this.y = RandomNum(0, GRID_COL-1) * GRID_WIDTH + BASE_BIAS + GRID_WIDTH / 2;
        this.foodColor = color[RandomNum(0, color.length-1)];
    }
    public void paint(Graphics g){
        g.setColor(foodColor);
        g.fillOval(x - GRID_WIDTH / 2, y - GRID_WIDTH / 2, GRID_WIDTH, GRID_WIDTH);
    }
}
