import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Panneau extends JPanel
{

    /* ARGUMENTS */
    Particule[] particules;

    /* METHODES */
    public void setParticules(Particule[] p)
    {

        this.particules = p;
        repaint();
    }

    public void paintComponent(Graphics g)
    {

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        for(Particule p: particules)
        {
            g.fillOval(p.x, p.y, p.R*2, p.R*2);
        }
    }
}
