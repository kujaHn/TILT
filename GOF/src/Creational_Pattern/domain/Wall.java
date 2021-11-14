package Creational_Pattern.domain;

public class Wall implements MapSite{
    @Override
    public void enter() {
        System.out.println("벽으로 막혀 있습니다.");
    }
}
