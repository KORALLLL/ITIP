public abstract class Transport {
    protected String brand_val;
    protected int year_val;
    protected static int transportCount = 0;

    public Transport(String brand, int year){
        brand_val = brand;
        year_val = year;
        transportCount++;
    }
    
    public Transport(){
        this("Volvo", 2000);
    }

    public abstract void move();

    public int getTransportCount(){
        return transportCount;
    }

    public String getBrand(){
        return brand_val;
    }

    public int getYear(){
        return year_val;
    }

    public void setBrand(String val){
        brand_val = val;
    }
    
    public void setYear(int val){
        year_val = val;
    }
}
