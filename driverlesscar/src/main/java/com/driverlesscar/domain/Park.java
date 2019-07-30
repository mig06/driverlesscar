package com.driverlesscar.domain;

/**
 * Copyright
 * User: Ganzf
 * Date: 2019/7/28
 * Description: 停车场
 */
public class Park {

    private int length;
    private int width;

    public Park(int length, int width) {
        this.length = length;
        this.width = width;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
