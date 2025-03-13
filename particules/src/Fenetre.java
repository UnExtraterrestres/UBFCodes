import javax.swing.JFrame;

public class Fenetre extends JFrame
{

    /* ARGUMENTS */
    int largeur, hauteur;
    String titre;
    Panneau pan;

    /* CONSTRUCTEURS */
    public Fenetre(int l, int h, String t)
    {

        /*
         * constructeur principal
         * @param l type entier naturel
         * @param h type entier naturel
         * @param t type chaîne de car
         * @return l'affectation des arguments de this
         * par les valeurs spécifiées
         * */
        largeur = l;
        hauteur = h;
        titre = t;

        this.setSize(largeur, hauteur);
        this.setTitle(titre);

        pan = new Panneau();
        this.setContentPane(pan);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public Fenetre()
    {

        /*
         * constructeur par défaut
         * @return l'affectation des arguments de this
         * par appel du constructeur principal
         * */
        this(1500, 800, "Simulation - modèle de particules");
    }
}
