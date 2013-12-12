import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class EventosAditza implements ActionListener, FocusListener, KeyListener{
	
	static PantallaAditzak pa;
	int maxArray, numeroAleatorio;
	int x, y;
	Random rnd;
	boolean empezado = false;
	
	String aditza[][]={{"IZAN", "NI", "NAIZ", "*"},
			{"IZAN", "BERA", "DA", "*"},
			{"IZAN","GU","GARA","*"},
			{"IZAN","ZU","ZARA","*"},
			{"IZAN","ZUEK","ZARETE","*"},
			{"IZAN","HAIEK","DIRA","*"},
			{"EGON","NI","NAGO","*"},
			{"EGON","BERA","DAGO","*"},
			{"EGON","GU","GAUDE","*"},
			{"EGON","ZU","ZAUDE","*"},
			{"EGON","ZUEK","ZAUDETE","*"},
			{"EGON","HAIEK","DAUDE","*"},
			{"JOAN","NI","NOA","*"},
			{"JOAN","BERA","DOA","*"},
			{"JOAN","GU","GOAZ","*"},
			{"JOAN","ZU","ZOAZ","*"},
			{"JOAN","ZUEK","ZOAZTE","*"},
			{"JOAN","HAIEK","DOAZ","*"},
			{"UKAN","NIK","DUT","DITUT"},
			{"UKAN","BERAK","DU","DITU"},
			{"UKAN","GUK","DUGU","DITUGU"},
			{"UKAN","ZUK","DUZU","DITUZU"},
			{"UKAN","ZUEK","DUZUE","DITUZUE"},
			{"UKAN","HAIEK","DUTE","DITUZTE"},
			{"NOR-NORI","NIRI","ZAIT","ZAIZKIT"},
			{"NOR-NORI","BERARI","ZAIO","ZAIZKIO"},
			{"NOR-NORI","GURI","ZAIGU","ZAIZKIGU"},
			{"NOR-NORI","ZURI","ZAIZU","ZAIZKIZU"},
			{"NOR-NORI","ZUEI","ZAIZUE","ZAIZKIZUE"},
			{"NOR-NORI","HAIEI","ZAIE","ZAIZKIE"}};
	
	
	public EventosAditza(PantallaAditzak pa){
		this.pa = pa;
		//Averiguamos la longitud de la matriz por si en el futuro queremos aumentarla.
		maxArray = aditza.length;
		// Inicializamos el generador de números aleatorios;
		rnd = new Random();
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String evento;
		
		evento = arg0.getActionCommand();
		
		//System.out.println("Evento: " + evento);
		//Botón SALIR
		if(evento.equalsIgnoreCase("Salir"))
			System.exit(0);
		// Botón EMPEZAR
		if(evento.equalsIgnoreCase("Empezar")){
			empezado = true;
			pa.bEmpezar.setEnabled(false);
			pa.bComprobar.setEnabled(true);
			procesoAditza();
			
		}
		// Botón RESET
		if(evento.equalsIgnoreCase("Reset")){
			empezado = false;
			pa.bEmpezar.setEnabled(true);
			pa.bComprobar.setEnabled(false);
		}		
		// Botón comprobar
		if(evento.equalsIgnoreCase("Comprobar")){
			boolean correcto = true;
			
			ponMayusculas(evento);
			
			if(pa.tfPertsona.getText().equalsIgnoreCase(aditza[y][1]) == false)
				correcto = false;
			if(pa.tfAdtizaSingularra.getText().equalsIgnoreCase(aditza[y][2]) == false)
				correcto = false;
			if(aditza[y][3].length() > 1)
				if(pa.tfAditzaPlurala.getText().equalsIgnoreCase(aditza[y][3]) == false)
					correcto = false;
			if (correcto == true){
				JOptionPane.showMessageDialog(pa, "Correcto!!!");					
				procesoAditza();
			}else
				JOptionPane.showMessageDialog(pa, "Fallaste!!!");	
		}
	}
	
	public void procesoAditza(){
		
		
		// Borramos el contenido, por si había algo
		pa.tfPertsona.setText("");
		pa.tfAdtizaSingularra.setText("");
		pa.tfAditzaPlurala.setText("");
		pa.lNombreAditza.setText("");
		// Número aleatorio entre 1 y 3 ambos inclusive
		// Con el veremos que es lo que vamo ha mostrar (1)NIK (2)DUT (3)DITUT
		x = rnd.nextInt(3) + 1;
		// Generamos un número aleatorio para elegir el caso concreto
		y = rnd.nextInt(30);

		// Si encontramos un "*" == longitud 1, tenemos que buscar otro caso
		while(aditza[y][x].length() == 1)
			x = rnd.nextInt(3) + 1;

		// Ponemos el nombre del verbo
		pa.lNombreAditza.setText(aditza[y][0]);
		//Ahora ya tenemos un caso válido
		switch(x){
		case 1 : 	pa.tfPertsona.setEnabled(false);
					pa.tfAdtizaSingularra.setEnabled(true);
					if(aditza[y][3].length() == 1)
						pa.tfAditzaPlurala.setEnabled(false);
					else
						pa.tfAditzaPlurala.setEnabled(true);
					pa.tfPertsona.setText(aditza[y][x]);
					break;
		case 2 : 	pa.tfPertsona.setEnabled(true);
					pa.tfAdtizaSingularra.setEnabled(false);
					if(aditza[y][3].length() == 1)
						pa.tfAditzaPlurala.setEnabled(false);
					else
						pa.tfAditzaPlurala.setEnabled(true);
					pa.tfAdtizaSingularra.setText(aditza[y][x]);
					break;
		case 3 : 	pa.tfPertsona.setEnabled(true);
					pa.tfAdtizaSingularra.setEnabled(true);
					pa.tfAditzaPlurala.setEnabled(false);
					pa.tfAditzaPlurala.setText(aditza[y][x]);	 
					break;						 
		}		
		
		if(pa.tfPertsona.isEnabled())
			pa.tfPertsona.requestFocus();
		else
			if(pa.tfAdtizaSingularra.isEnabled())
				pa.tfAdtizaSingularra.requestFocus();
			else
				pa.tfAditzaPlurala.requestFocus();
	}
	
	public void ponMayusculas(String campo){
		//if(campo.equalsIgnoreCase("tfPertsona"))
			pa.tfPertsona.setText(pa.tfPertsona.getText().toUpperCase());
		//if(campo.equalsIgnoreCase("tfAditzaSingularra"))
			pa.tfAdtizaSingularra.setText(pa.tfAdtizaSingularra.getText().toUpperCase());
		//if(campo.equalsIgnoreCase("tfAditzaPlurala"))
			pa.tfAditzaPlurala.setText(pa.tfAditzaPlurala.getText().toUpperCase());
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
