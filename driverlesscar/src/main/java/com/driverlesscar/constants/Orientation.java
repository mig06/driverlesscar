package com.driverlesscar.constants;

/**
 * Copyright
 * User: Ganzf
 * Date: 2019/7/28
 * Description: 方向枚举
 */
public enum Orientation {
    EAST,       //东
    SOUTH,      //南
    WEST,       //西
    NORTH;      //北


    /**
     * 顺时针方向旋转
     * @return
     */
    public Orientation turnClockwise(){
        switch (this){
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            case NORTH: return EAST;
            default: return null;
        }
    }

}
