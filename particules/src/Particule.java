public class Particule
{

    /* ARGUMENTS */
    int x;
    int y;
    double phi;
    int R;
    double c;
    double alpha;
    double beta;
    double r;

    /* CONSTRUCTEURS */
    public Particule(int x, int y, double phi, int R, double c, double alpha, double beta, double r)
    {

        /*
        * constructeur principal
        * @param x, y type entier
        * @param phi type réél
        * @param R type réél positif non nul
        * @return l'affectation des arguments de this
        * par les valeurs spécifiées
        * */

        this.x = x;
        this.y = y;
        this.phi = phi;
        this.R = R;
        this.c = c;
        this.alpha = alpha;
        this.beta = beta;
        this.r = r;
    }
    public Particule(int x, int y) {

        /*
         * constructeur secondaire
         * @param x, y type entier
         * @return l'affectation des arguments de this
         * par appel du constructeur principal
         * */

        this(x, y, Math.random()*360, 5, 6.7, 180, 17, 10);
    }

    /* METHODES */
    public void vitesse()
    {

        this.x += (int)(c*Math.cos(phi));
        this.y += (int)(c*Math.sin(phi));
    }

    public int signe(int valeur)
    {

        if (valeur < 0)
        {

            return -1;
        }
        return 1;
    }
    
    public void rotation(Particule[] parts)
    {

        int Nt = 0;
        int Dt = 0;
        int Gt = 0;

        for (Particule p: parts)
        {
            if (this.r >= Math.sqrt((this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y)))
            {
                Nt ++;
                if (Math.abs(p.y-this.y)*Math.cos(this.phi) > Math.abs(p.x-this.x)*Math.sin(this.phi))
                {
                    Gt ++;
                } else
                {
                    Dt ++;
                }
            }
        }

        this.phi += alpha+beta*Nt*signe(Dt-Gt);
    }
}
