package top.linesoft.biptstudy;

class Point{
    double x,y,z;
    Point(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    double getDistance(Point point1){
        return Math.sqrt(Math.pow(this.x-point1.x,2)+Math.pow(this.y-point1.y,2)+Math.pow(this.z-point1.z,2));
    }
}
public class Main {

    public static void main(String[] args) {
	    Point p1 = new Point(2,8,9);
        Point p2 = new Point(8,20,4);
        System.out.println(p1.getDistance(p2));
    }
}
