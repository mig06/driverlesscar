package com.driverlesscar.constants;



/**
 * Copyright
 * User: Ganzf
 * Date: 2019/7/28
 * Description: 命令枚举
 */
public enum Command {
    FORWARD,  //前进
    BACKWARD, //后退
    TURN_CLOCKWISE;  //顺时针转动



    public static Command getCommand(String command) {
        if(command.isEmpty()){
            return null;
        }
        Command[] enums = values();
        for (Command cEnum : enums) {
            if (cEnum.name().equals(command)) {
                return cEnum;
            }
        }
        return null;
    }


}
