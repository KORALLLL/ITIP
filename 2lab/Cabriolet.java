public class Cabriolet extends Car{
    private boolean adjustableRoof;

    public Cabriolet(String brand, int year, int passangers, boolean roof){
        super(brand, year, passangers);
        adjustableRoof = roof;
    }
    public Cabriolet(){
        this("lambo", 2018, 2, true);
    }

    @Override
    public void move(){
        System.out.println("this is beatiful cabriolet. it's moving realy fast");
    }

    public boolean getAdjustableRoof(){
        return adjustableRoof;
    }

    public void setAdjustableRoof(boolean roof){
        adjustableRoof = roof;
    }

}
