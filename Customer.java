/**
	Customer.java

	Name:	Anurag Purkayastha
	Student ID:	s3805894
*/
import java.io.Serializable;

public class Customer implements Serializable{

	static int nextID = 1;
	private int custID;
	private String name;
	private int skiLevel;	//	1 == Beginner, 2 == Intermediate, 3 == Expert

	public Customer(){}

	public Customer(String name, int skiLevel){
		this.name = name;
		this.skiLevel = skiLevel;
		this.custID = nextID++;
	}

	public int getID(){
		return custID;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getSkiLevel(){
		return skiLevel;
	}

	public void setSkiLevel(int skiLevel){
		this.skiLevel = skiLevel;
	}

	@Override
	public String toString(){
		String skiLevelString;
		switch(skiLevel){
			case 1:
				skiLevelString = "Beginner";
				break;
			case 2:
				skiLevelString = "Intermediate";
				break;
			case 3:
				skiLevelString = "Expert";
				break;
			default:
				skiLevelString = "Unspecified";
		}
		return "Customer ID:\t" + custID + "\nName:\t" + name + "\nSki Level:\t" + skiLevelString;
	}
}
