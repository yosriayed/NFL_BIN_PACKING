
import java.util.ArrayList;

public class ListOfItems {
	private ArrayList<Item> content = new ArrayList<Item>();
	private int size ;
	
	public ListOfItems(int n) {
		content.ensureCapacity(n);
		MersenneTwister r_x=new MersenneTwister(new MersenneTwister().nextLong());
		int [] tab_init = new int [624] ;
		for (int i = 0; i<624; i ++){
			tab_init[i] = r_x.nextInt();
		}
		MersenneTwister r_y = new MersenneTwister(tab_init);
		for (int i = 0; i<624; i ++){
			tab_init[i] = r_x.nextInt();
		}
		//r_x = new MersenneTwister(tab_init);
		for (int i=0; i<n;i++){
			content.add(new Item(r_x.nextDouble(),r_y.nextDouble()));
		}
		setSize();
		
		
	}

	public ArrayList<Item> getContent() {
		return content;
	}

	public void setContent(ArrayList<Item> content) {
		this.content = content;
	}

	public int getSize() {
		return size;
	}

	public void setSize() {
		size = content.size();
	}
	
	public void SetSize(int size){
		this.size = size;
	}
	
	public void show(){
		for (Item item:content){
			System.out.println("["+ item.getLargeur()+" , "+item.getHauteur()+"]");
		}
	}
	public String showString(){
		String st="";
		for (Item item:content){
			st=st+"["+ item.getLargeur()+" , "+item.getHauteur()+"]\n";
		}
		return st ;
	}
	

}
