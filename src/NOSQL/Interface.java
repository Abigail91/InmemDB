package NOSQL;
 
import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
 
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.JButton;
 
public class Interface extends JFrame implements ActionListener{
 
        private JPanel contentPane;
        JRadioButton b1;
        JRadioButton b2;
        JRadioButton b3;
        JRadioButton b4;
        JRadioButton b5;
        JRadioButton b6;
        JLabel seleccion;
        static int rep;
        ButtonGroup grupoBotones;
 
 
        public Interface() {
                setResizable(false);
                setSize(400, 400);
                setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Desktop\\log.png"));
                setTitle("InmemDB");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(400, 400, 400, 400);
                contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                setContentPane(contentPane);
 
                b1 = new JRadioButton("String");
                b1.setFont(new Font("Tahoma", Font.PLAIN, 14));
 
                b2 = new JRadioButton("Integer");
                b2.setFont(new Font("Tahoma", Font.PLAIN, 14));
 
                b3 = new JRadioButton("Join");
                b3.setFont(new Font("Tahoma", Font.PLAIN, 14));
 
                seleccion = new JLabel("Elija el tipo de dato para la columna " + rep);
 
                seleccion.setForeground(SystemColor.textHighlight);
                seleccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
 
                b4 = new JRadioButton("Long");
                b4.setFont(new Font("Tahoma", Font.PLAIN, 14));
 
                b5 = new JRadioButton("Float");
                b5.setFont(new Font("Tahoma", Font.PLAIN, 14));
 
                b6 = new JRadioButton("Double");
                b6.setFont(new Font("Tahoma", Font.PLAIN, 14));
 
                grupoBotones=new ButtonGroup();
                grupoBotones.add(b1);
                grupoBotones.add(b2);
                grupoBotones.add(b3);
                grupoBotones.add(b4);
                grupoBotones.add(b5);
                grupoBotones.add(b6);
 
                JButton bott = new JButton("Siguiente");
                bott.addActionListener(this);
 
 
 
 
 
                GroupLayout gl_contentPane = new GroupLayout(contentPane);
                gl_contentPane.setHorizontalGroup(
                                gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(seleccion))
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addGap(98)
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                                .addComponent(b2)
                                                                                                .addComponent(b3)
                                                                                                .addComponent(b6)
                                                                                                .addComponent(b4)
                                                                                                .addComponent(b5)
                                                                                                .addComponent(b1)
                                                                                                .addComponent(bott))))
                                                .addContainerGap(189, Short.MAX_VALUE))
                                );
                gl_contentPane.setVerticalGroup(
                                gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(24)
                                                .addComponent(seleccion)
                                                .addGap(29)
                                                .addComponent(b2)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(b1)
                                                .addGap(3)
                                                .addComponent(b5)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(b4)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(b6)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(b3)
                                                .addGap(38)
                                                .addComponent(bott)
                                                .addContainerGap(47, Short.MAX_VALUE)));
 
                contentPane.setLayout(gl_contentPane);
                setVisible(true);
 
        }
       
       
        public void repeticiones(int rep) {
                
                if(rep == 0) {
                    setVisible(false);
                        
                        
                }else {
                        if(b1.isSelected() || b2.isSelected() || b3.isSelected() || b4.isSelected()||b5.isSelected()||b6.isSelected()) {
                                setVisible(false);
                                if(b1.isSelected()) {
                                        new Input(rep);
                                        Input.type = b1.getText();}
                               // Input.lista.addLast((String) Input.getValue());

                                if(b2.isSelected()) {
                                        new Input(rep);
                                        Input.type = b2.getText();}
                                
                             //   Input.lista.addLast((String) Input.getValue());

                                
                                if(b3.isSelected()) {
                                        new Input(rep);
                                        Input.type = b3.getText(); }
                                
                             //   Input.lista.addLast((String) Input.getValue());
                               
                                if(b4.isSelected()) {
                                        new Input(rep);
                                        Input.type = b4.getText();
                                }
                                
                             //   Input.lista.addLast((String) Input.getValue());

                                if(b5.isSelected()) {
                                        new Input(rep);
                                        Input.type = b5.getText();
                                }
                                
                             //   Input.lista.addLast((String) Input.getValue());

                                if(b6.isSelected()) {
                                        new Input(rep);
                                        Input.type = b6.getText();
                                }
                                
                              //  Input.lista.addLast((String) Input.getValue());

                               
                               
                        }else {
                                JOptionPane.showMessageDialog(null, "Seleccione un tipo de dato");
                        }
                }
        }
       
        public void actionPerformed(ActionEvent e) {   
                repeticiones(rep);
        }
 
 
}
 