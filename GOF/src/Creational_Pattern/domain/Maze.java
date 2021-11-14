package Creational_Pattern.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Maze {
    Logger logger;
    Map<Long, Room> mazeMap = new HashMap<>();

    public void addRoom(Room room) {
        logger.info(room + "추가!");
        mazeMap.put(room.getRoomNumber(), room);
    }

    public void roomNo(int roomNumber) {


    }
}
