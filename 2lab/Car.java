public class Car extends Transport{
    private int passangers;

    public Car(String brand, int year, int passangers_val){
        super(brand, year);
        passangers = passangers_val;
    }

    public Car(){
        this("lada", 1998, 7);
    }

    @Override
    public void move(){
        System.out.println("This car is moving");
    }

    public int getPassangers(){
        return passangers;
    }
    public void setPassangers(int val){
        passangers = val;
    }

    public void signal(){
        System.out.println("piiiiiiiiiiiii");
    }
}
