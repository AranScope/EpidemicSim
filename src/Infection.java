public class Infection {
    public static void main(String[] args){
        Population pop = new Population(1000);
        GraphicalView view = new GraphicalView(800, 600);

        pop.randomInfect(10);

        while(true){
            view.setPop(pop);
            pop.update();
            try{
                Thread.sleep(50);
            }catch(Exception e){}
        }

    }
}
