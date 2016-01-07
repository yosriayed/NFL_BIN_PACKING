

import java.util.ArrayList;

public class Bin {
	private double remainingWidth ;
	private double remainingHeight ;
	private double maxHeight ;
	private ArrayList<Item> content ; 
	
	
	public Bin() {
		remainingWidth = 1;
		remainingHeight = 1;
		maxHeight = 0;
		content = new ArrayList<Item>();
	}
	public Bin(Item item){
		this();
		maxHeight = item.getHauteur();
		addItem(item);
	}

	public double getRemainingWidth() {
		return remainingWidth;
	}
	
	public void setRemainingWidth(double remainingWidth) {
		this.remainingWidth = remainingWidth;
	}
	
	public double getRemainingHeight() {
		return remainingHeight;
	}
	
	public void setRemainingHeight(double remainingHeight) {
		this.remainingHeight = remainingHeight;
	}

	public ArrayList<Item> getContent() {
		return content;
	}

	public void setContent(ArrayList<Item> content) {
		this.content = content;
	}
	
	public boolean addItem(Item item){
		boolean success = false;
		if (item.getLargeur() <= remainingWidth){
			content.add(item);
			remainingWidth-= item.getLargeur();
			if (maxHeight<item.getHauteur())
				maxHeight = item.getHauteur();
			success = true;
		}
		else if(item.getHauteur()<= (remainingHeight-maxHeight)){
			content.add(item);
			remainingWidth = 1- item.getLargeur();
			remainingHeight -= maxHeight;
			maxHeight = item.getHauteur();
			success = true;
		}
		else {
			success = false;
		}
		return success;
	}

	public double getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(double maxHeight) {
		this.maxHeight = maxHeight;
	}
	
	public void show(){
		for (Item item:content){
			System.out.println("["+ item.getLargeur()+" , "+item.getHauteur()+"]");
		}
	}
	public String showString(){
		String x ="";
		for (Item item:content){
			x=x+"["+ item.getLargeur()+" , "+item.getHauteur()+"]\n";
		}
		return x ;
	}

}
