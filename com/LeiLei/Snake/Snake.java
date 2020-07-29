package com.LeiLei.Snake;

import com.LeiLei.Food.Food;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.LeiLei.util.config.*;
import static com.LeiLei.util.config.GRID_WIDTH;


public class Snake {
    private final List<BasicSnake> snakeList = new ArrayList<BasicSnake>();
    private final SnakeHead head = new SnakeHead();
    public Snake(){
        snakeList.add(head);
    }
    public void paint(Graphics g){
        move();
        for (BasicSnake basic: snakeList) {
            basic.paint(g);
        }
    }

    public boolean alive(){
        for(int i=1;i<this.snakeList.size();i++){
            if (this.snakeList.get(i).getY() == head.getY() && this.snakeList.get(i).getX() == head.getX()) {
                return false;
            }
        }
        return true;
    }

    public void addBody(){
        SnakeBody body = new SnakeBody();
        body.setX(this.snakeList.get(snakeList.size()-1).getX());
        body.setY(this.snakeList.get(snakeList.size()-1).getY());
        body.setDir(this.snakeList.get(snakeList.size()-1).getDir());
        switch (this.snakeList.get(snakeList.size()-1).getDir()){
            case DIR_UP-> body.setY(this.snakeList.get(snakeList.size()-1).getY() + GRID_WIDTH);
            case DIR_DOWN-> body.setY(this.snakeList.get(snakeList.size()-1).getY() - GRID_WIDTH);
            case DIR_LEFT-> body.setX(this.snakeList.get(snakeList.size()-1).getX() + GRID_WIDTH);
            case DIR_RIGHT-> body.setX(this.snakeList.get(snakeList.size()-1).getX() - GRID_WIDTH);
        }
        this.snakeList.add(body);
    }

    public void updateSnake(){
        for(int i=this.snakeList.size()-1;i>=1;i--){
            this.snakeList.get(i).setDir(this.snakeList.get(i-1).getDir());
            switch (this.snakeList.get(i-1).getDir()){
                case DIR_UP -> {
                    this.snakeList.get(i).setY(this.snakeList.get(i-1).getY() + GRID_WIDTH);
                    this.snakeList.get(i).setX(this.snakeList.get(i-1).getX());
                }
                case DIR_DOWN -> {
                    this.snakeList.get(i).setY(this.snakeList.get(i-1).getY() - GRID_WIDTH);
                    this.snakeList.get(i).setX(this.snakeList.get(i-1).getX());
                }
                case DIR_LEFT -> {
                    this.snakeList.get(i).setX(this.snakeList.get(i-1).getX() + GRID_WIDTH);
                    this.snakeList.get(i).setY(this.snakeList.get(i-1).getY());
                }
                case DIR_RIGHT -> {
                    this.snakeList.get(i).setX(this.snakeList.get(i-1).getX() - GRID_WIDTH);
                    this.snakeList.get(i).setY(this.snakeList.get(i-1).getY());
                }
            }
        }
    }

    public void move(){
        for (BasicSnake basic: snakeList) {
            basic.move();
        }
    }

    public BasicSnake getHead() {
        return head;
    }

    public List<BasicSnake> getSnakeList() {
        return snakeList;
    }
}
