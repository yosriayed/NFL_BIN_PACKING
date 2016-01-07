
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import javax.swing.JButton;
import javax.swing.JTextArea;


import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class ListeDisplay extends JFrame {

	private JPanel contentPane;
	private ListOfItems Ln ;
	private JScrollPane scrollPane;
	private JTextArea textPane;
	/**
	 * Launch the application.
	 */
	
	public  void show (ListOfItems L) {
		
				try {
					Ln=L ;
					System.out.println("d5al okra");
					RefineryUtilities.centerFrameOnScreen(this);
					this.setVisible(true);
					textPane.setText(L.showString());				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	
	/**
	 * Create the frame.
	 */
	
	public ListeDisplay() {
		setTitle("Liste Ln");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnH = new JButton("Histogramme");
		btnH.setActionCommand("hist");
		btnH.addActionListener(new ButtonClickListener());
		btnH.setBounds(146, 231, 171, 25);
		contentPane.add(btnH);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 12, 387, 207);
		contentPane.add(scrollPane);
		
		textPane = new JTextArea();
		scrollPane.setViewportView(textPane);
	}

	private class ButtonClickListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	         String command = e.getActionCommand();  
	         if( command.equals( "hist" ))  {
	        	 HistogramDemo1 histogramdemo1 = new HistogramDemo1("Histogramme Ln",Ln);
	                histogramdemo1.pack();
	                RefineryUtilities.centerFrameOnScreen(histogramdemo1);
	                histogramdemo1.setVisible(true);
	     	}
	         
	      }		
	   }
}
