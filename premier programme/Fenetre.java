import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Fenetre
{
	
	public static void main(String[] args)
	{
		
		/*Fenetre et Titre				*/
		JFrame fenetre = new JFrame("Test de fenetre");
		/*Fermeture de la fenetre			*/
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		/*Ajout d'un contenu a la fenetre		*/
		JLabel label = new JLabel("Hello world !");
		JButton button = new JButton("Print : hello world");
		
		/*changer la taille du boutton		*/
		
		fenetre.getContentPane().add(label);
		fenetre.getContentPane().add(button);
		
		fenetre.pack();
		
		
		/*Taille de la fenetre				*/
		fenetre.setSize(1040, 580);
		/*Positionnement de la fenetre		*/
		fenetre.setLocationRelativeTo(null);
		
		/*Visibilite de la fenetre			*/
		fenetre.setVisible(true);
	}
}
