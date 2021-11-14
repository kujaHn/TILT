package Creational_Pattern.domain;

public class Door implements MapSite{
    // 방 사이에 문이 있어야 하기 떄문에 방의 정보가 필요
    private Room room1;
    private Room room2;
    private boolean isOpen;

    public Door() {
    }

    public Door(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }

    @Override
    public void enter() {
        System.out.println("문을 엽니다.");
    }

    public Room otherSideFrom(Room room) {
        return room;
    }

}
