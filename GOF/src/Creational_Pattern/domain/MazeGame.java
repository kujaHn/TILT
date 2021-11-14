package Creational_Pattern.domain;

import static Creational_Pattern.domain.Direction.*;

public class MazeGame {
    Maze createMaze() {
        Maze maze = new Maze();
        Room room1 = new Room();
        Room room2 = new Room();
        Door door = new Door(room1, room2);

        roomSetting(room1, room2, door);

        maze.addRoom(room1);
        maze.addRoom(room2);

        return maze;
    }

    private void roomSetting(Room room1, Room room2, Door door) {
        room1.setSide(EAST, door);
        room2.setSide(WEST, door);
    }
}
