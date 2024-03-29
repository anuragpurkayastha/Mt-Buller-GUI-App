/**
	Accommodation.java

	Name:	Anurag Purkayastha
	Student ID:	s3805894
*/
import java.io.Serializable;

public class Accommodation implements Serializable{

	private static int nextID = 1;
	private int accommodationID;
	private int price;
	private String type;
	private boolean isAvailable;

	public Accommodation(){
		accommodationID = nextID++;
		isAvailable = true;
	}

	public Accommodation(int price){
		this();
		this.price = price;
	}

	public Accommodation(int price, String type){
		this(price);
		this.type = type;
	}

	public int getID(){
		return accommodationID;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}

	public boolean getIsAvailable(){
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable){
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString(){
		return "ID:\t" + accommodationID + "\nPrice:\t$" + price + "\nType:\t" + type + "\nAvailable:\t" + isAvailable;
	}
}
