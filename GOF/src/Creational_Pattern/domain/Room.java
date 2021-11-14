package Creational_Pattern.domain;

public class Room implements MapSite{

    private long roomNumber;
    private MapSite[] side = new MapSite[4];    // 4면 설정

    // 벽으로 생성 => 문만 만들면 된다.
    public Room() {
        side[0] = new Wall();
        side[1] = new Wall();
        side[2] = new Wall();
        side[3] = new Wall();
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public MapSite getSide(Direction direction) {
        return side[direction.ordinal()];
    }

    // 방 설정(벽 + 문)
    public void setSide(Direction direction, MapSite mapSite) {
        side[direction.ordinal()] = mapSite;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public void enter() {
        System.out.println("다음 방으로 진입합니다.");
    }
}
