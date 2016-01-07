import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RefineryUtilities;

import javax.swing.JScrollBar;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;


public class mainframe {
	private ListeDisplay listeDisplay ;
	private JFrame frmNflbinpacking;
	private JTextField NtextField;
	private NFL nfl ;
	private JButton btnNFL;
	private JTextField ktextField;
	private JTextField ptextField;
	private JTextField ltextField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton espu1;
	private JLabel lblK;
	private JLabel lblL;
	private JLabel lblP;
	private JButton btnEnfl;
	private JButton btnHistogramme;
	private JButton btnErrorFinal;
	private JButton graph;
	private JScrollPane scrollPane;
	private JTextArea console;
	private JPanel panel;
	private JScrollPane scrollPane_1;
	private JTextArea txtrCommencezPar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainframe window = new mainframe();
					window.frmNflbinpacking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private static XYDataset createDataset(double[] l) {

        DefaultXYDataset ds = new DefaultXYDataset();
        double[] x=new double[l.length];
        double[] y=new double[l.length];
for (int i =0;i<l.length;i++){
	x[i]=i ;
	y[i]=l[i] ;
}
        double[][] data = { x, y};

        ds.addSeries("series1", data);

        return ds;
    }
	public mainframe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNflbinpacking = new JFrame();
		frmNflbinpacking.setTitle("NFL_BIN_PACKING");
		frmNflbinpacking.setBounds(100, 100, 931, 501);
		frmNflbinpacking.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(12, 12, 418, 467);
		frmNflbinpacking.getContentPane().add(panel);
		
		NtextField = new JTextField();
		NtextField.setColumns(10);
		
		JLabel lblNn_1 = new JLabel("N");
		
		ptextField = new JTextField();
		ptextField.setText("0.5");
		ptextField.setColumns(10);
		
		lblP = new JLabel("p");
		
		
		ktextField = new JTextField();
		ktextField.setText("10");
		ktextField.setColumns(10);
		
		lblK = new JLabel("k");
		
		ltextField = new JTextField();
		ltextField.setText("10");
		ltextField.setColumns(10);
		
		lblL = new JLabel("l");
		
		scrollPane = new JScrollPane();
		
		console = new JTextArea();
		console.setEditable(false);
		scrollPane.setViewportView(console);
		
		JButton btnGnrer = new JButton("Générer");
		btnGnrer.setActionCommand("Generer");
		btnGnrer.addActionListener(new ButtonClickListener());
		
		btnNFL = new JButton("NFL");
		btnNFL.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNFL.setActionCommand("NFL");
		btnNFL.addActionListener(new ButtonClickListener());
		
		espu1 = new JButton("E(NFL(u1))");
		espu1.setActionCommand("espu1");
		espu1.addActionListener(new ButtonClickListener());
		
		btnHistogramme = new JButton("Histogramme NFL");
		btnHistogramme.setActionCommand("histesp");
		
				btnHistogramme.addActionListener(new ButtonClickListener());
		
		btnEnfl = new JButton("E(NFL)");
		
		btnEnfl.setActionCommand("espNFL");
		btnEnfl.addActionListener(new ButtonClickListener());
		
		btnErrorFinal = new JButton("Erreur finale");
		btnErrorFinal.setActionCommand("erreur");
		
				btnErrorFinal.addActionListener(new ButtonClickListener());
		
		graph = new JButton("Graphe E(NFL)/N");
		graph.setActionCommand("graph");
		graph.addActionListener(new ButtonClickListener());
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNn_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblK, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(NtextField, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(ptextField, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblP, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(ktextField, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(ltextField, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblL, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
							.addGap(35)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnGnrer, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNFL, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addComponent(espu1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
							.addGap(51))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(btnErrorFinal, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnEnfl, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnHistogramme, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(graph, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
								.addContainerGap(35, Short.MAX_VALUE)))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(btnGnrer)
							.addGap(12)
							.addComponent(btnNFL)
							.addGap(12)
							.addComponent(espu1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(NtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(ptextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNn_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(7)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(ktextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(ltextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblK, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblL, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEnfl)
						.addComponent(btnHistogramme))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnErrorFinal)
						.addComponent(graph))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(476, 12, 441, 458);
		frmNflbinpacking.getContentPane().add(scrollPane_1);
		
		txtrCommencezPar = new JTextArea();
		txtrCommencezPar.setText("  - Commencez par générer la séquence des objets par \n indiquant sa taille N dans le champ N puis cliquez sur \"Génerer\"\n Une fenetre apparait qui vous permet de visualiser\n l'histogrammede la variable aléatoire \"largeur d'un objet\"\n\n - Le bouton NFL vous permet d'executer l'heuristique NFL \n pour cette liste.\n\n -Le bouton \"E(NFL(u1))\" vous permet d'estimer l'espérance de \n NFL(N) en appliquant \n\n la stratégie à priori u1, avec k,l et p sont les paramètres: \n   * k : sur combien de listes de taille N on va moyenner\n      pour avoir l'estimation de l'esperance\n   * l : le nombre de sous problèmes \n   * p : la probabilité à priori q'un objet va rester dans la liste\n\n - Le bouton \"E(NFL)\" vous permet d'estimer l'espérance de \n NFL(N)\n\n - Le bouton \"Histogramme NFL\" vous permet de visualiser la fréquence \n de chaque valeur de boites rendue par l'algorithme NFL sur k \n tirages de listes de taille N.\n\n - Le Bouton \"Graphe ..\" vous permet de visualiser E(NFL(N))/N en \n fonction de N, pour N allant de k à l\n\n -Le bouton \"erreur finale\" vous permet de voir l'erreur \n e=E(NFL(N))/N-1/2.");
		scrollPane_1.setViewportView(txtrCommencezPar);
		String text=" - Commencer par générer la séquence des objets par \nindiquant sa taille N dans le champs N";
		
		
		//frame.getContentPane().add(console);
		
	}
	 private class ButtonClickListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	         String command = e.getActionCommand();  
	         if( command.equals( "Generer" ))  {
	        	 try{
	        		 System.out.println("d5al");
	        	 nfl=new NFL(Integer.parseInt(NtextField.getText())) ;
        		 
	        	 listeDisplay=new ListeDisplay() ;
	        	 listeDisplay.show(nfl.getLn());
	        	 }
	        	 catch (Exception ex){
	        		 console.setText("Veuillez entrer un entier positif.");
	        	 }
	        	}

	         if( command.equals("NFL"))  {
	        	 try{
	        		
	        		 console.setText("Le nombre des boites : "+String.valueOf(nfl.binPackingNFL())+"\n");
	        		 String x="";int i=1 ;
	        		 for (Bin bin:nfl.getContent()){
	        			 x=x+("#############"+"boite "+i+" ###############\n");
	        				x=x+bin.showString();
	        				
	        				i++ ;
	        			}
	        		 console.setText(console.getText()+x);
	        		
	        	 }
	        	 catch (Exception ex){
	        		 console.setText("Veuillez entrer un entier positif.");
	        	 }
	        	}
	         if( command.equals("espu1"))  {
	        	 try{
	        		 NumberFormat monFormatteurDeNombre = NumberFormat.getInstance();
	        		 int k=Integer.parseInt(ktextField.getText());
	        		 int l=Integer.parseInt(ltextField.getText());
	        		 int N=Integer.parseInt(NtextField.getText());
	        		 double p=Double.parseDouble(ptextField.getText()) ;
	        		 float esp_u1=NFL.esperance_u1(k,N,l,p);//(k,n,l,p)
	        		 System.out.println(esp_u1+"k="+k+"l="+l+"N="+N+"p="+p+ptextField.getText());
	        		 console.setText("esperance u1 NFL(n) = "+esp_u1);

	        	 }
	         catch (Exception ex){
	        		 console.setText("Veuillez entrer des entrées valides.");
	        	 }
	        	}
	         if( command.equals("espNFL"))  {
	        	 try{
	        		 NumberFormat monFormatteurDeNombre = NumberFormat.getInstance();
	        		 int k=Integer.parseInt(ktextField.getText());
	        		 int N=Integer.parseInt(NtextField.getText());
	        		 float esp_u1=NFL.esperance_u1(k,N,1,1);//(k,n,l,p)
	        		 
	        		 console.setText("esperance de NFL("+N+") = "+esp_u1+"\nEstimée avec la moyenne empirique de k="+k+" réalisations des listes Ln de taille N="+N+"\nPour avoir une meilleur estimation, augmentez k");

	        	 }
	         catch (Exception ex){
	        		 console.setText("Veuillez entrer des entrées valides.");
	        	 }
	        	}
	         if( command.equals("histesp"))  {
	        	try{
	        		 System.out.println("hist");
	        		 int k=Integer.parseInt(ktextField.getText());  
	        		 int N=Integer.parseInt(NtextField.getText());
	        		float[] list=new float[k];
	        		 for (int i=0;i<k;i++){
	        			 nfl=new NFL(N) ;
	        			 list[i]=(nfl.binPackingNFL());
	        		 }
	        		 HistogramDemo1 histogramdemo1 = new HistogramDemo1("Histogramme NFL",list,N);
		                histogramdemo1.pack();
		                RefineryUtilities.centerFrameOnScreen(histogramdemo1);
		                histogramdemo1.setVisible(true);
	        		 
	        		 }
	         catch (Exception ex){
	        		 console.setText("Veuillez entrer des entrées valides./un autre probleme");
	        	 }
	        	}
	         if( command.equals("erreur"))  {
		        	try{
		        		 NumberFormat monFormatteurDeNombre = NumberFormat.getInstance();
		        		 
		        		 int N=Integer.parseInt(NtextField.getText());
		        		 float esp_u1=NFL.esperance_u1(100,N,1,1);//(k,n,l,p)
		        		 float ee=(float) (esp_u1/N-0.5) ;
		        		 console.setText("erreur finale  E(NFL)/N-1/2= "+ee);
	         }
		         catch (Exception ex){
		        		 console.setText("Veuillez entrer des entrées valides./un autre probleme");
		        	 }
		        	}
	         if( command.equals("graph"))  {
		        	
		        		 NumberFormat monFormatteurDeNombre = NumberFormat.getInstance();
		        		 int k=Integer.parseInt(ktextField.getText());
		        		 int l=Integer.parseInt(ltextField.getText());
		        		 if ((k<l)&&(k!=0)){
		        		 double[] list=new double[l];
		        		 for (int N=k;N<l;N++){
		        			 list[N]=(double)NFL.esperance_u1(100,N,1,1)/N;//(k,n,l,p)
		        		 }
		        		 
		        		 XYDataset ds = createDataset(list);
		        			JFreeChart chart = ChartFactory.createXYLineChart(
		        	                "E(NFL(N))/N)",
		        	                "N",
		        	                "E(NFL(N))",
		        	                ds,
		        	                PlotOrientation.VERTICAL,
		        	                true,
		        	                true,
		        	                false
		        	                );

		        	ChartFrame frame = new ChartFrame("Results", chart);
		        	frame.pack();
		        	frame.setVisible(true);
	        
		        		 }
		        		 else {
			        		 console.setText("Veuillez choisir des entrées valides :\n * k : borne supérieur ;l borne inférieur "
		        		 + "");

		        		 }
		        	}
	      }		
	   }
}
