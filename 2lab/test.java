public class test {
    public static void main(String[] args){
        Point2d myPoint = new Point2d();
        Point3d myOtherPoint = new Point3d(3,4,2);
        System.out.printf("%s %s\n", myPoint.getX(), myPoint.getY());
        System.out.printf("%s %s %s\n", myOtherPoint.getX(), myOtherPoint.getY(), myOtherPoint.getZ());
        myPoint.setX(14);
        myPoint.setY(1.2);
        myOtherPoint.setX(1);
        myOtherPoint.setY(2);
        myOtherPoint.setZ(4);
        System.out.printf("%s %s\n", myPoint.getX(), myPoint.getY());
        System.out.printf("%s %s %s", myOtherPoint.getX(), myOtherPoint.getY(), myOtherPoint.getZ());
    }
}
