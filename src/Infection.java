public class Infection {

    /**
     * Main method, program entry.
     * @param args
     */
    public static void main(String[] args){
        Population pop = new Population(2000);
        GraphicalView view = new GraphicalView(800, 600);

        pop.randomInfect(1);

        while(true){
            view.setPop(pop);
            pop.update();
            try{
                Thread.sleep(50);
            }catch(Exception e){}
        }

    }
}
