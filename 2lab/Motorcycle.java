public class Motorcycle extends Transport{
    public boolean hasHelmet;

    public Motorcycle(){
        this("yamakasi", 2016, true);
    }

    public Motorcycle(String brand_val, int year_val, boolean helmet){
        super(brand_val, year_val);
        hasHelmet = helmet;
    }

    @Override
    public void move(){
        if (hasHelmet){
            System.out.println("this motorcycle is slammed into a pole. The helmet didn't help");
        }
        else{
            System.out.println("this motorcycle is slammed into a pole");
        }
    }

    public boolean getHasHelmet(){
        return hasHelmet;
    }

    public void setHasHelmet(boolean val){
        hasHelmet = val;
    }

    public void trickshot(){
        System.out.println("the motocycle rides on one wheel");
    }
}
