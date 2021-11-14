package Creational_Pattern.Abstract_Factory.windowsample.factory;

public class PMWidgetFactory implements WidgetFactory{
    @Override
    public void createScrollBar() {
        System.out.println("PMV ScrollBar 만들기");
    }

    @Override
    public void createWindow() {
        System.out.println("PMV Window 만들기");
    }
}
