import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Aditzak  extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -491034458093394202L;

	public Aditzak(){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//creamos el contenedor
		setTitle("Aditzak");
		setSize(350, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFont( new Font( "Courier",Font.PLAIN,30 ));
		
		System.out.println("Primera modificación con Git");

		//Añadimos los componentes de la pantalla al contenedor		
		PantallaAditzak pa = new PantallaAditzak();
		this.add(pa);			
		setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Aditzak();
		
	}

}
