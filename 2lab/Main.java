public class Main {
    public static void main(String[] args){
        Car lada = new Car();
        Cargo mersedes = new Cargo();
        Motorcycle yamakasi = new Motorcycle();
        Cabriolet lambo = new Cabriolet();

        System.out.printf("%s %s %s\n", lada.getBrand(), lada.getYear(), lada.getPassangers());
        System.out.printf("%s %s %s\n", mersedes.getBrand(), mersedes.getYear(), mersedes.getCapacity());
        System.out.printf("%s %s %s\n", yamakasi.getBrand(), yamakasi.getYear(), yamakasi.getHasHelmet());
        System.out.printf("%s %s %s %s\n", lambo.getBrand(), lambo.getYear(), lambo.getPassangers(), 
            lambo.getAdjustableRoof());
        System.out.println(yamakasi.getTransportCount());
        System.out.println(lada.getTransportCount());


        lada.move();
        lada.signal();
        mersedes.move();
        mersedes.load();
        yamakasi.move();
        yamakasi.trickshot();
        lambo.move();
    
        Car marussia = new Car("marussia", 2018, 2);
        Cargo skania = new Cargo("skania", 2008, 15.6);
        Motorcycle mers = new Motorcycle("MB", 2019, false);
        Cabriolet ferro = new Cabriolet("ferrari", 2019, 2, true);


        System.out.printf("%s %s %s\n", marussia.getBrand(), marussia.getYear(), marussia.getPassangers());
        System.out.printf("%s %s %s\n", skania.getBrand(), skania.getYear(), skania.getCapacity());
        System.out.printf("%s %s %s\n", mers.getBrand(), mers.getYear(), mers.getHasHelmet());
        System.out.printf("%s %s %s %s\n", ferro.getBrand(), ferro.getYear(), ferro.getPassangers(), 
            ferro.getAdjustableRoof());
        System.out.println(marussia.getTransportCount());
        System.out.println(skania.getTransportCount());


        marussia.setBrand("real marussya");
        marussia.setYear(2022);
        marussia.setPassangers(1);
        skania.setBrand("real skania");
        skania.setYear(2010);
        skania.setCapacity(25);
        mers.setBrand("real mers");
        mers.setYear(2020);
        mers.setHasHelmet(false);
        ferro.setBrand("real ferro");
        ferro.setYear(2022);
        ferro.setPassangers(3);
        ferro.setAdjustableRoof(false);

        System.out.printf("%s %s %s\n", marussia.getBrand(), marussia.getYear(), marussia.getPassangers());
        System.out.printf("%s %s %s\n", skania.getBrand(), skania.getYear(), skania.getCapacity());
        System.out.printf("%s %s %s\n", mers.getBrand(), mers.getYear(), mers.getHasHelmet());
        System.out.printf("%s %s %s %s\n", ferro.getBrand(), ferro.getYear(), ferro.getPassangers(),
             ferro.getAdjustableRoof());
    }
}
