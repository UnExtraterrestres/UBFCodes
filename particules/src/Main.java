import static java.lang.Thread.sleep;

public class Main
{

    public static int hasardDans(int b1, int b2)
    {

        if(b1>b2)
        {
            b1 += b2;
            b2 = b1 - b2;
            b1 = b1 - b2;
        }

        return b1 + (int)(Math.random()*(b2-b1+1));
    }

    public static Particule[] hasardParticules(int nbPart, Fenetre fen)
    {

        Particule[] parts = new Particule[nbPart];

        for(int i = 0; i<nbPart; i++)
        {
            parts[i] = new Particule(hasardDans(fen.largeur-10, 10), hasardDans(fen.hauteur-10, 10));
        }

        return parts;
    }

    public static void mouvement(Particule[] parts)
    {

        for (Particule p: parts)
        {
            p.vitesse();
            p.rotation(parts);
        }
    }

    public static void main(String[] args)
    {
        
        Fenetre f = new Fenetre();
        int NB_PARTICULES = 10;
        int NB_GENERATIONS = 100000;
        Particule[] particules = hasardParticules(NB_PARTICULES, f);

        f.pan.setParticules(particules);

        for (int i = 0; i<NB_GENERATIONS; i++)
        {
            mouvement(particules);
            
	    try
            {
                sleep(90);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
	
            f.pan.setParticules(particules);
        }
    }
}
