import java.awt.*;
import java.util.Random;

public class Vector2 {
    public double x;
    public double y;

    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector2(){
        this.x = 0;
        this.y = 0;
    }

    public static Vector2 getRandomVector(int maxX, int maxY){
        Random ra = new Random();
        return new Vector2(maxX - ra.nextDouble() * 2 * maxX, maxY - ra.nextDouble() * 2 * maxY);
    }

    public static Vector2 getMouseLocation(){
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;
        return new Vector2(x, y);
    }

    public double getDistanceTo(Vector2 pos){
        return Math.sqrt(Math.pow(pos.x - this.x, 2) + Math.pow(pos.y - this.y, 2));
    }

    public Vector2 getVectorTo(Vector2 target){
        return new Vector2(target.x - this.x, target.y - this.y);
    }

    public Vector2 normalise(){
        double length = Math.sqrt(this.x * this.x + this.y * this.y);
        this.x /= length;
        this.y /= length;
        return this;
    }

    public Vector2 abs(){
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    public Vector2 add(Vector2 addVect){
        this.x += addVect.x;
        this.y += addVect.y;
        return this;
    }

    public Vector2 mult(Vector2 multVect){
        this.x *= multVect.x;
        this.y *= multVect.y;
        return this;
    }

    public Vector2 div(Vector2 divVect){
        this.x *= divVect.x;
        this.y *= divVect.y;
        return this;
    }
}
