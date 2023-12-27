public class Cargo extends Transport{
    private double capacity;
    
    public Cargo(){
        this("skania", 2006, 33);
    }

    public Cargo(String brand, int year, double capacity_val){
        super(brand, year);
        capacity = capacity_val;
    }

    @Override
    public void move(){
        System.out.println("This cargo is moving now");
    }

    public double getCapacity(){
        return capacity;
    }

    public void setCapacity(double val){
        capacity = val;
    }

    public void load(){
        System.out.println("the cargo is loaded");
    }
}
