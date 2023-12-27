public class Point3d extends Point2d{ //class point3d inherits class point2d using extends
    // z coordinate
    public double zCoord;
    //constructor of initializing
    public Point3d(double x, double y, double z){
        super(x, y);
        zCoord = z;
    }
    // constructor by default
    public Point3d(){
        this(0,0,0);
    }
    // return z
    public double getZ(){
        return zCoord;
    }
    // z value setting
    public void setZ(double val){
        zCoord = val;
    }
}
