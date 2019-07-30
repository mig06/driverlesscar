package com.driverlesscar;

/**
 * Copyright
 * User: Ganzf
 * Date: 2019/7/28
 * Description: 无人驾驶车接口
 */
public interface ICar {

    void doCommand(String command) throws Exception ;

    int getPositionX();

    int getPositionY();

    String getOrientation();
}
