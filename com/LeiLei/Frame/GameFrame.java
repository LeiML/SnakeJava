package com.LeiLei.Frame;
import com.LeiLei.Food.Food;
import com.LeiLei.Snake.BasicSnake;
import com.LeiLei.Snake.Snake;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import static com.LeiLei.util.config.*;

public class GameFrame extends Frame implements Runnable{
    private final BufferedImage buff = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
    public Snake snake = new Snake();
    private Food food;
    public GameFrame(){
        food = new Food();
        this.BasicFrame();
        new Thread(this).start();
    }
    private void BasicFrame(){
        setTitle(FRAME_TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new SnakeKeyListen());
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void update(Graphics g) {
        Graphics img = buff.getGraphics();
        paintBack(img);
        paintGrid(img);
        snake.paint(img);
        food.paint(img);
        g.drawImage(buff, 0, 0, null);
    }

    public void paintBack(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
    }

    public void paintGrid(Graphics g){
        g.setColor(Color.RED);
        for(int i=0;i<=GRID_COL;i++){
            g.drawLine(BASE_BIAS+i*GRID_WIDTH, BASE_BIAS, BASE_BIAS+i*GRID_WIDTH, BASE_BIAS+GRID_ROW*GRID_WIDTH);
            g.drawLine(BASE_BIAS, BASE_BIAS+i*GRID_WIDTH, BASE_BIAS+GRID_COL*GRID_WIDTH, BASE_BIAS+i*GRID_WIDTH);
        }
    }

    public void FoodAlive(){
        if (snake.getHead().getX() == food.getX() && snake.getHead().getY() == food.getY()){
            food = new Food();
            snake.addBody();
        }
    }

    @Override
    public void run() {
        while(true) {
            repaint();
            FoodAlive();
            snake.updateSnake();
            if (!snake.alive())
                System.out.println(snake.alive());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class SnakeKeyListen implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP -> {
                    if (snake.getHead().getDir() != DIR_DOWN)
                        snake.getHead().setDir(DIR_UP);
                    if (snake.getHead().getDir() == DIR_DOWN&&snake.getSnakeList().size() == 1)
                        snake.getHead().setDir(DIR_UP);
                }
                case KeyEvent.VK_DOWN -> {
                    if (snake.getHead().getDir() != DIR_UP)
                        snake.getHead().setDir(DIR_DOWN);
                    if (snake.getHead().getDir() == DIR_UP&&snake.getSnakeList().size() == 1)
                        snake.getHead().setDir(DIR_DOWN);
                }
                case KeyEvent.VK_LEFT -> {
                    if (snake.getHead().getDir() != DIR_RIGHT)
                        snake.getHead().setDir(DIR_LEFT);
                    if (snake.getHead().getDir() == DIR_RIGHT&&snake.getSnakeList().size() == 1)
                        snake.getHead().setDir(DIR_LEFT);
                }
                case KeyEvent.VK_RIGHT -> {
                    if (snake.getHead().getDir() != DIR_LEFT)
                        snake.getHead().setDir(DIR_RIGHT);
                    if (snake.getHead().getDir() == DIR_LEFT&&snake.getSnakeList().size() == 1)
                        snake.getHead().setDir(DIR_RIGHT);
                }
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
