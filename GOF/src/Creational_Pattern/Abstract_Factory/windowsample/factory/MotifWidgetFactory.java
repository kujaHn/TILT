package Creational_Pattern.Abstract_Factory.windowsample.factory;

public class MotifWidgetFactory implements WidgetFactory{
    @Override
    public void createScrollBar() {
        System.out.println("MotifWidget ScrollBar 만들기");
    }

    @Override
    public void createWindow() {
        System.out.println("MotifWidget ScrollBar 만들기");
    }
}
