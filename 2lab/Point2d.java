public class Point2d {
    // координата x
    private double xCoord; //private - доступно только в классе, внутри которого объявлено. Это переменная
    // coordinate y
    private double yCoord;
    //constructor of initializing
    public Point2d(double x, double y){
        xCoord = x; //constructor doesn't hava return value. it initializes the variables
        yCoord = y; //constructor names should be capitalized
    }
    //constructor by default
    public Point2d(){
        this(0,0); //when object is created without values, it's AUTOMATICALLY assigned as x=0 and y=0
    }
    // return x
    public double getX(){
        return xCoord;
    }
    //return y
    public double getY(){
        return yCoord;
    }
    //x value setting
    public void setX(double val){
        xCoord = val;
    }
    //y value setting
    public void setY(double val){
        yCoord = val;
    }
}
