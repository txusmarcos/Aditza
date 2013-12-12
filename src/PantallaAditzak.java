import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PantallaAditzak extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel lAditza, lNombreAditza, lTextoCorrecto, lPertsona;
	JTextField tfPertsona, tfAdtizaSingularra, tfAditzaPlurala;
	JButton bEmpezar, bReset, bSalir, bComprobar;
	int veces = 0;
	
	
	public PantallaAditzak(){
		super();
		
		// Tipo de letra por defecto
		setFont( new Font( "Courier New",Font.PLAIN,30 ));
		
		// Ponemos todos los componentes 'a mano' 
		setLayout(null);
					
		// Utilizadas para posicionamiento relativo en la pantalla
		int x0 = 10, y0 = 10;
		
		EventosAditza gEventos = new EventosAditza(this);
		
		//Etiqueta 'Pertsona'
		lPertsona = new JLabel("Pertsona");
		lPertsona.setBounds(x0+10, y0+20, 90, 15);
		lPertsona.setFont(new Font("Curier New", Font.BOLD, 12));
        add(lPertsona);
        
		//Etiqueta 'Aditza'
        lAditza = new JLabel("Aditza");
        lAditza.setBounds(x0+110, y0+20, 90, 15);
        lAditza.setFont(new Font("Curier New", Font.BOLD, 12));
        add(lAditza);
        //Etiqueta 'NombreAditza'
        lNombreAditza = new JLabel("");
        lNombreAditza.setBounds(x0+200, y0+20, 110, 15);
        lNombreAditza.setFont(new Font("Curier New", Font.BOLD, 21));
        add(lNombreAditza);
		
       
        // Campo de texto 'Aditza'
        tfPertsona = new JTextField();
        tfPertsona.setBounds(x0 + 5, y0+50, 80, 20);
        tfPertsona.setText("");
        tfPertsona.setFont(new Font("Curier New", Font.BOLD, 16));
        tfPertsona.setEnabled(false);
        tfPertsona.setActionCommand("tfPertsona");
        tfPertsona.addActionListener(gEventos);
        add(tfPertsona);
        
        // Campo de texto 'AdtizaSingularra'
        tfAdtizaSingularra = new JTextField();
        tfAdtizaSingularra.setBounds(x0 + 100, y0+50, 90, 20);
        tfAdtizaSingularra.setText("");
        tfAdtizaSingularra.setFont(new Font("Curier New", Font.BOLD, 16));
        tfAdtizaSingularra.setEnabled(false);
        tfAdtizaSingularra.setActionCommand("tfAditzaSingularra");
        tfAdtizaSingularra.addActionListener(gEventos);
        add(tfAdtizaSingularra);
        
        // Campo de texto 'tfAditzaPlurala'
        tfAditzaPlurala = new JTextField();
        tfAditzaPlurala.setBounds(x0 + 200, y0+50, 90, 20);
        tfAditzaPlurala.setText("");
        tfAditzaPlurala.setFont(new Font("Curier New", Font.BOLD, 16));
        tfAditzaPlurala.setEnabled(false);
        tfAditzaPlurala.setActionCommand("tfAditzaPlurala");
        tfAditzaPlurala.addActionListener(gEventos);
        add(tfAditzaPlurala);                              
       
        // Botón 'Empezar'
        bEmpezar = new JButton("Empezar");
        bEmpezar.setBounds(x0+25, y0+120, 85, 20);
        bEmpezar.addActionListener(gEventos);
        bEmpezar.setActionCommand("Empezar");
        add(bEmpezar);
        
        // Botón 'Reset'
        bReset = new JButton("Reset");
        bReset.setBounds(x0+115, y0+120, 85, 20);
        bReset.addActionListener(gEventos);
        bReset.setActionCommand("Reset");
        add(bReset);
        
        // Botón 'Salir'
        bSalir = new JButton("Salir");
        bSalir.setBounds(x0+205, y0+120, 85, 20);
        bSalir.addActionListener(gEventos);
        bSalir.setActionCommand("Salir");
        add(bSalir);
        
        // Botón 'Comprobar'
        bComprobar = new JButton("Comprobar");
        bComprobar.setBounds(x0+105, y0+85, 105, 25);
        bComprobar.addActionListener(gEventos);
        bComprobar.setActionCommand("Comprobar");
        bComprobar.setEnabled(false);
        add(bComprobar);
	}
        
	

}
