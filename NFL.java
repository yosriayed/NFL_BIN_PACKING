

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

public class NFL {
	private ListOfItems Ln;
	private ArrayList<Bin> content = new ArrayList<Bin>();
	private int n;
	
	public NFL(int n) {
		this.n = n;
		Ln = new ListOfItems(n);
	}
	public int binPackingNFL(){
		for (Item item:Ln.getContent()){
			if (!(content.isEmpty())){
			Bin bin = content.get(content.size()-1);
			if (!(bin.addItem(item))){
				content.add(new Bin(item));
				}
			}
			else {
				content.add(new Bin(item));

			}
			

		}
		return content.size();
		
	}

	public static float esperance_u1(int k,int n,int l,double p){
		float x =0 ;
		int y=0	;
		
				//p probabilité à priori que un objet reste dans la boite
		for (int i=1;i<=k;i++){
			ListOfItems Ln=new  ListOfItems(n);
			y=0 ;
			for (int j=1;j<=l;j++){
				 
				ArrayList<Item>  Lnl=new ArrayList<Item>();
				
				for(Item it:Ln.getContent()){
					if(Math.random()<=p){
						Lnl.add(it);
					}
				}
				
				System.out.print("taille du sous probleme ="+Lnl.size());

				NFL tt =new NFL(n);
				ListOfItems ll=new ListOfItems(n);
				ll.setContent(Lnl);
				tt.setLn(ll);
				int yj=tt.binPackingNFL() ;
				y=y+yj ;
				//System.out.print("yj="+yj);
				//System.out.println(" || somme des yj="+y);

			}
			x=x+y/l;
			//System.out.println("xi =" + x);
		}
		
		return x/k ;
	}
	private static XYDataset createDataset() {

        DefaultXYDataset ds = new DefaultXYDataset();

        double[][] data = { {0.1, 0.2, 0.3}, {1, 2, 3} };

        ds.addSeries("series1", data);

        return ds;
    }
	public static void main(String[] args) {
		NFL test = new NFL(10);
		System.out.println("nombre boite =" + test.binPackingNFL());
		test.Ln.show();
		System.out.println("---------------------");
		for (Bin bin:test.getContent()){
			bin.show();
			System.out.println("######################");
		}
		
		System.out.println("esperance u1 NFL(n) pour p = "+esperance_u1(10,100,10,0.6));//(k,n,l,p)
		
		/*E(NFL)
		 * E(NFL)=E(NFL(u1)) pour p=1 ;
		*/
		//System.out.println("esperance  NFL(n) : "+esperance_u1(1000,5,10,1));
		XYDataset ds = createDataset();
		JFreeChart chart = ChartFactory.createXYLineChart(
                "Title",
                "x",
                "y",
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

	public ListOfItems getLn() {
		return Ln;
	}

	public void setLn(ListOfItems ln) {
		Ln = ln;
	}

	public ArrayList<Bin> getContent() {
		return content;
	}

	public void setContent(ArrayList<Bin> content) {
		this.content = content;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

}
