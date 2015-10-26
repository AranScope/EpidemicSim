import java.util.ArrayList;
import java.util.Random;

public class Population {
    private ArrayList<Person> people;
    private double deathRate;
    private double recoveryRate;

    private Random ra;

    public Population(int size){
        ra = new Random();
        people = new ArrayList<>();

        for(int i = 0; i < size; i++){
            people.add(new Person());
        }

        deathRate = 0.005;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void randomInfect(int numOfPeople){
        for(int x = 0; x < numOfPeople; x++){
            people.get(ra.nextInt(people.size())).setInfected(true);
        }
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public double getDeathRate() {
        return deathRate;
    }

    public void setDeathRate(double deathRate) {
        this.deathRate = deathRate;
    }

    public double getRecoveryRate() {
        return recoveryRate;
    }

    public void setRecoveryRate(double recoveryRate) {
        this.recoveryRate = recoveryRate;
    }

    public void setInfected(int index){
        people.get(index).setInfected(true);
    }

    public boolean isInfected(int index){
        return people.get(index).isInfected();
    }

    public int getSize(){
        return people.size();
    }

    public void update(){
        ArrayList<Person> peopleToInfect = new ArrayList<>();

        for(Person p1: people){
            for(Person p2: people){
                if(!(p1 == p2) && !p2.isDead() && !p1.isDead()){
                    if(p1.getDistanceTo(p2) < 20){
                        if(p1.isInfected()) peopleToInfect.add(p2);
                    }
                }
            }
        }

        for(Person person: people){
            if(person.isInfected() && !person.isDead()){
                if(ra.nextDouble() < deathRate) person.setDead(true);
            }
        }

        for(Person person: peopleToInfect){
            person.setInfected(true);
        }

        for(Person person: people){
            //person.getLocation().add(person.getLocation().getVectorTo(getPeople().get(12).getLocation()));
            //person.getLocation().add(person.getLocation().getVectorTo(new Vector2(300, 300)).normalise());
            //person.getLocation().add(Vector2.getRandomVector(5, 5));

           // if(person.isInfected()) person.setVelocity(person.getLocation().getVectorTo(Vector2.getMouseLocation()));

            if(!person.isDead()) person.setLocation(person.getLocation().add(person.getVelocity().normalise()));


            if(person.getLocation().x > 800 && person.getVelocity().x > 0){
                person.setVelocity(person.getVelocity().mult(new Vector2(-1, 1)));
            }
            if(person.getLocation().x < 0 && person.getVelocity().x < 0){
                person.setVelocity(person.getVelocity().mult(new Vector2(-1, 1)));
            }
            if(person.getLocation().y > 600 && person.getVelocity().y > 0){
                person.setVelocity(person.getVelocity().mult(new Vector2(1, -1)));
            }
            if(person.getLocation().y < 0 && person.getVelocity().y < 0){
                person.setVelocity(person.getVelocity().mult(new Vector2(1, -1)));
            }
        }
    }
}
