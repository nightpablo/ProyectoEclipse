package InterfazGrafica;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prueba {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba window = new Prueba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prueba() {
		initialize();
		System.out.println("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0,1));
		
		int i=0;
		while(i<10) {
			JButton a = new JButton("Holi "+i);
			a.addActionListener(accion);
			frame.add(a);
			i++;
		}
		
		frame.pack();
	}
	
	private ActionListener accion = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton a = new JButton("Holi"+" ee");
			a.addActionListener(accion);
			frame.add(a);
			frame.pack();
		}
	};

}
