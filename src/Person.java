public class Person {
    private boolean infected;
    private boolean dead;
    private Vector2 location;
    private Vector2 velocity;
    
    public Person(){
        this.infected = false;
        this.dead = false;
        this.location = Vector2.getRandomVector(700, 500);
        this.velocity = Vector2.getRandomVector(10, 10);
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Vector2 getLocation() {
        return location;
    }

    public void setLocation(Vector2 location) {
        this.location = location;
    }

    public Vector2 getVelocity(){
        return velocity;
    }

    public void setVelocity(Vector2 velocity){
        this.velocity = velocity;
    }

    public double getDistanceTo(Person neighbour) {
        Vector2 thisCentre = new Vector2(this.location.x + 5, this.location.y + 10);
        Vector2 thatCentre = new Vector2(neighbour.getLocation().x + 5, neighbour.getLocation().y + 10);
        return thisCentre.getDistanceTo(thatCentre);
    }
}
