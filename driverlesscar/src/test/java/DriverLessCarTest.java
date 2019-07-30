import com.driverlesscar.DriverLessCar;
import com.driverlesscar.ICar;
import com.driverlesscar.constants.Command;
import com.driverlesscar.constants.Orientation;
import com.driverlesscar.domain.Park;
import com.driverlesscar.domain.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Copyright
 * User: Ganzf
 * Date: 2019/7/30
 * Description: 无人驾驶车单元测试
 */
public class DriverLessCarTest {

    private ICar car;
    private Park park;
    private Position position;

    @Before
    public void init() {
        position = new Position(1,1);
        park = new Park(4,4);
    }

    /**
     * Given the Car is in position X = 1 and Y = 1 and facing North, when the Car turns clockwise,
     * then the Car is still in the same position but is now facing East
     * @throws Exception
     */
    @Test
    public void testTurnClockwise()throws Exception {
        car = new DriverLessCar(position, Orientation.NORTH, park);
        car.doCommand(Command.TURN_CLOCKWISE.name());
        assertEquals(1,car.getPositionX());
        assertEquals(1,car.getPositionY());
        assertEquals(Orientation.EAST.name(),car.getOrientation());
    }

    /**
     * Given the Car is in position X = 1 and Y = 1 and facing North, when the Car moves forward,
     * then the Car is still facing North but is now in position X = 1 and Y = 2
     * @throws Exception
     */
    @Test
    public void tesNorthForward()throws Exception {
        car = new DriverLessCar(position, Orientation.NORTH, park);
        car.doCommand(Command.FORWARD.name());
        assertEquals(1,car.getPositionX());
        assertEquals(2,car.getPositionY());
        assertEquals(Orientation.NORTH.name(),car.getOrientation());
    }

    /**
     * Given the Car is in position X = 1 and Y = 1 and facing East, when the Car moves forward,
     * then the Car is still facing East but is now in position X = 2 and Y = 1
     * @throws Exception
     */
    @Test
    public void testEastForward()throws Exception {
        car = new DriverLessCar(position, Orientation.EAST, park);
        car.doCommand(Command.FORWARD.name());
        assertEquals(2,car.getPositionX());
        assertEquals(1,car.getPositionY());
        assertEquals(Orientation.EAST.name(),car.getOrientation());
    }

    /**
     * Given the Car is in position X = 1 and Y = 1 and facing West, when the Car moves forward,
     * then an exception is thrown
     * @throws Exception
     */
    @Test
    public void testWestForward()throws Exception {
        car = new DriverLessCar(position, Orientation.WEST, park);
        car.doCommand(Command.FORWARD.name());
        assertEquals(1,car.getPositionX());
        assertEquals(1,car.getPositionY());
        assertEquals(Orientation.WEST.name(),car.getOrientation());
    }

    /**
     * Given the Car is in position X = 1 and Y = 1 and facing East, when the Car moves forward twice,
     * then the Car is still facing East but is now in position X = 3 and Y = 1
     * @throws Exception
     */
    @Test
    public void testEastTwiceForward()throws Exception {
        car = new DriverLessCar(position, Orientation.EAST, park);
        car.doCommand(Command.FORWARD.name());
        car.doCommand(Command.FORWARD.name());
        assertEquals(3,car.getPositionX());
        assertEquals(1,car.getPositionY());
        assertEquals(Orientation.EAST.name(),car.getOrientation());
    }
}
