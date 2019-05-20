package NOSQL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener{
	JLabel vent;
	public Ventana()  {
	setSize(800,800);
	setTitle("InmemDB");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setLayout(null);
	ImageIcon foto = new ImageIcon("images/img.png");
	JLabel vent = new JLabel(foto);
	vent.setSize(500,500);
	vent.setName("InmemDB");
	vent.setBounds(0, 0, 800, 800);
	vent.setLayout(null);
	ImageIcon icono = new ImageIcon("images/log.png");
	setIconImage(icono.getImage());
	JButton button = new JButton();
	button.setText("Ingresar datos");
	button.setBounds(28,640, 250, 60);
	button.addActionListener(this);
	add(button);
	JButton bot = new JButton();
	bot.setText("Salir");
	bot.setBounds(498,640, 250, 60);
	bot.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			CloseFrame();
			
			
		}
	});
	add(bot);
	add(vent);
	setVisible(true);}


	AbstractAction action = new AbstractAction()
	{
		
	    @Override
		public void actionPerformed(ActionEvent e) {
	    	setVisible(false);	
	    	new wind(); }

	};
	
	public void CloseFrame(){
	    super.dispose();
	}

	 public void actionPerformed(ActionEvent e) {
 		this.setVisible(false);
 		new Datos();
	 }
	 
 		
public static void main(String[] args) {
	new Ventana();
	
}

}
