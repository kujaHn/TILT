package Creational_Pattern.domain;

public enum Direction {

    NORTH(0),
    SOUTH(1),
    EAST(2),
    WEST(3);

    private final int directionNum;

    Direction(int directionNum) {
        this.directionNum = directionNum;
    }

}
