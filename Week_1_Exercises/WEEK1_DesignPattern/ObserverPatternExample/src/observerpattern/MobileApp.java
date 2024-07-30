package observerpattern;

public class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println("Mobile App " + name + " received stock price update: " + price);
    }
}
