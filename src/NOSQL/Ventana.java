package NOSQL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Server.Client;

public class Ventana extends JFrame implements ActionListener{
	JLabel vent;
	public Ventana()  {
	setSize(800,800);
	setTitle("InmemDB");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setLayout(null);
	ImageIcon foto = new ImageIcon("src/images/img.png");
	JLabel vent = new JLabel(foto);
	vent.setSize(500,500);
	vent.setName("InmemDB");
	vent.setBounds(0, 0, 800, 800);
	vent.setLayout(null);
	ImageIcon icono = new ImageIcon("src/images/log.png");
	setIconImage(icono.getImage());
	JButton button = new JButton();
	button.setText("Agregar tabla");
	button.setBounds(20,640, 180, 60);
	button.addActionListener(this);
	add(button);
	JButton bot3 = new JButton();
	bot3.setText("Consultar base de datos");
	bot3.setBounds(280,640, 180, 60);
	add(bot3);
	bot3.addActionListener(action2);
	JButton bot = new JButton();
	bot.setText("Salir");
	bot.setBounds(525,640, 180, 60);
	
	bot.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			CloseFrame();
			
			
		}
	});
	add(bot);
	add(vent);
	setVisible(true);}

	AbstractAction action2 = new AbstractAction()
	{
		
	    @Override
		public void actionPerformed(ActionEvent e) {
	    	setVisible(false);	
	    	new wind(); }

	};

	
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
 		new Nombre();
	 }
	 
 		
public static void main(String[] args) {
	
	new Ventana();
	Client.getInstance().start();
}

}
