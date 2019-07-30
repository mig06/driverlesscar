package com.driverlesscar;

import com.driverlesscar.constants.Command;
import com.driverlesscar.constants.Orientation;
import com.driverlesscar.domain.Park;
import com.driverlesscar.domain.Position;
import com.driverlesscar.exception.OutOfAreaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright
 * User: Ganzf
 * Date: 2019/7/28
 * Description: 无人驾驶车
 */
public class DriverLessCar implements ICar {

    private static Logger logger = LoggerFactory.getLogger(DriverLessCar.class);

    private Position oriPosition;
    private Orientation orientation;
    private Park park;
    private Position targetPosition;

    public DriverLessCar(Position position, Orientation orientation, Park park){
        this.oriPosition = position;
        this.targetPosition = position;
        this.orientation = orientation;
        this.park = park;
    }

    @Override
    public void doCommand(String command) throws Exception {
        Command com = Command.getCommand(command);
        if(com == null){
            logger.error("The command "+ command +" is not exist");
        }
        switch (com){
            case FORWARD:
                forward();
                break;
            case TURN_CLOCKWISE:
                turnClockwise();
                break;
        }

    }

    private void forward() throws Exception{
        targetPosition.proceed(orientation,true);
        isInArea(targetPosition,park);
        oriPosition = targetPosition;


    }

    /**
     * 判断是否范围内
     * @param position
     * @param park
     */
    private void isInArea(Position position, Park park) throws OutOfAreaException {
        if(!(position.getX() > 0 && position.getX() <= park.getWidth()
                && position.getY() > 0 && position.getY() <= park.getLength())){
            throw new OutOfAreaException("The position(x: "+position.getX()+" y:"+position.getY()+") Out of the park");
        }
    }

    /**
     * 顺时针旋转
     */
    private void turnClockwise(){
        orientation = orientation.turnClockwise();
        logger.info("The current orientation is {}",orientation);
    }

    @Override
    public int getPositionX() {
        return oriPosition.getX();
    }

    @Override
    public int getPositionY() {
        return oriPosition.getY();
    }

    @Override
    public String getOrientation() {
        return orientation.name();
    }
}
