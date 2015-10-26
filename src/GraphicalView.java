import javax.swing.*;
import java.awt.*;

public class GraphicalView extends JPanel {
    int width, height;
    JFrame frame;
    Population pop;

    public void repaintAll(){
        frame.repaint();
        this.repaint();
    }

    public GraphicalView(int width, int height){
        frame = new JFrame("Sorting Visualizer");
        this.setSize(width, height);
        frame.setSize(width, height);

        this.width = width;
        this.height = height;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(this);
    }

    public void setPop(Population pop){
        this.pop = pop;
        repaintAll();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int personWidth = 10;
        int personHeight = 20;

        //draw dead
        for(Person person: pop.getPeople()){
            g2.setColor(new Color(0, 0, 0, 50));
            g2.setColor(Color.decode("0xCCCCCC"));
            if(person.isDead()){
                g2.fillRect((int) person.getLocation().x, (int) person.getLocation().y, personWidth, personHeight);
                g2.setColor(Color.decode("0x738473"));
                g2.drawRect((int)person.getLocation().x, (int)person.getLocation().y, personWidth, personHeight);
            }
        }

        for(Person person: pop.getPeople()){
            if (person.isInfected() && !person.isDead()){
                g2.setColor(new Color(255, 0, 0, 50));
                g2.fillOval((int)person.getLocation().x + personWidth/2 - 20, (int)person.getLocation().y + personHeight/2 - 20, 40, 40);
                g2.setColor(Color.red);
            }
            else g2.setColor(Color.decode("0xbada55"));

            if(!person.isDead()) {
                g2.fillRect((int) person.getLocation().x, (int) person.getLocation().y, personWidth, personHeight);
                g2.setColor(Color.decode("0x738473"));
                g2.drawRect((int) person.getLocation().x, (int) person.getLocation().y, personWidth, personHeight);
            }


        }

    }
}
