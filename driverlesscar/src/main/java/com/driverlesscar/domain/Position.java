package com.driverlesscar.domain;

import com.driverlesscar.constants.Orientation;

/**
 * Copyright
 * User: Ganzf
 * Date: 2019/7/28
 * Description: 位置
 */
public class Position {

    private int x;
    private int y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void proceed(Orientation orientation, boolean forward){
        int step  =  forward ? 1 : -1;
        switch (orientation){
            case EAST : x += step; break;
            case WEST : x -= step; break;
            case NORTH : y += step; break;
            case SOUTH : y -= step; break;
        }
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
