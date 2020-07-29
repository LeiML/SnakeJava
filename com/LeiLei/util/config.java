package com.LeiLei.util;

import java.awt.*;
import java.util.Random;

public class config {
    //游戏的名称
    public static final String FRAME_TITLE = "贪吃蛇";
    //基础的窗口的大小的配置信息
    public static final int FRAME_WIDTH     = 670;
    public static final int FRAME_HEIGHT    = 650;
    //网格的大小，20*20
    public static final int GRID_WIDTH      = 20;
    //网格的行数与列数
    public static final int GRID_ROW        = 30;
    public static final int GRID_COL        = 30;
    //基础的偏置
    public static final int BASE_BIAS       = 35;
    //蛇的4个方向
    public static final int DIR_UP          = 1;
    public static final int DIR_DOWN        = 2;
    public static final int DIR_LEFT        = 3;
    public static final int DIR_RIGHT       = 4;
    //蛇头的颜色
    public static final Color HEAD          = Color.RED;
    //蛇的身体的颜色
    public static final Color BODY          = Color.BLUE;
    //食物的颜色数组
    public static final Color[]color = {Color.CYAN, Color.MAGENTA, Color.orange, Color.YELLOW, Color.pink};
    //生成随机数
    public static int RandomNum(int min, int max){
        return (new Random()).nextInt(max) + min;
    }
}
