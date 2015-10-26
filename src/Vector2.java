import java.awt.*;
import java.util.Random;

/**
 * Vector2 class including basic vector operations for position and velocity representation and calculations.
 */
public class Vector2 {
    public double x;
    public double y;

    /**
     * Constructor
     * @param x x value of the vector.
     * @param y y value of the vector.
     */
    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor
     */
    public Vector2(){
        this.x = 0;
        this.y = 0;
    }

    public static Vector2 getRandomVector(int maxX, int maxY){
        Random ra = new Random();
        return new Vector2(maxX - ra.nextDouble() * 2 * maxX, maxY - ra.nextDouble() * 2 * maxY);
    }

    /**
     * Get the current location of the mouse pointer relative to 0,0.
     * @return Mouse location vector.
     */
    public static Vector2 getMouseLocation(){
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;
        return new Vector2(x, y);
    }

    /**
     * Get distance to target vector.
     * @param target
     * @return Distance vector to target.
     */
    public double getDistanceTo(Vector2 target){
        return Math.sqrt(Math.pow(target.x - this.x, 2) + Math.pow(target.y - this.y, 2));
    }

    /**
     * Get vector to target location.
     * @param target Target vector.
     * @return Direction vector to target vector.
     */
    public Vector2 getVectorTo(Vector2 target){
        return new Vector2(target.x - this.x, target.y - this.y);
    }

    /**
     * Normalise vector operation
     * @return Normalised Vector2 object.
     */
    public Vector2 normalise(){
        double length = Math.sqrt(this.x * this.x + this.y * this.y);
        this.x /= length;
        this.y /= length;
        return this;
    }

    /**
     * Absolute vector operation.
     * @return Absolute Vector2 object.
     */
    public Vector2 abs(){
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    /**
     * Addition vector operation.
     * @param addVect
     * @return Sum of two Vector2 objects.
     */
    public Vector2 add(Vector2 addVect){
        this.x += addVect.x;
        this.y += addVect.y;
        return this;
    }

    /**
     * Multiplication vector operation.
     * @param multVect
     * @return Product of two Vector2 objects.
     */
    public Vector2 mult(Vector2 multVect){
        this.x *= multVect.x;
        this.y *= multVect.y;
        return this;
    }

    /**
     * Division vector operation.
     * @param divVect
     * @return Quotient of two Vector2 objects.
     */
    public Vector2 div(Vector2 divVect){
        this.x *= divVect.x;
        this.y *= divVect.y;
        return this;
    }
}
