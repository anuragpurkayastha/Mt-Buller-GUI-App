/**
	TravelPackage.java

	Name:	Anurag Purkayastha
	Student ID:	s3805894
*/
import java.time.LocalDate;
import java.io.Serializable;

public class TravelPackage implements Serializable{

	private Accommodation accommodation;
	private int lesson;
	private int liftPass;
	private Customer customer;
	private int duration;
	private LocalDate startDate;
	private static int nextID = 1;
	private int packageID;

	public TravelPackage(){
		packageID = nextID++;
		liftPass = 0;
		lesson = 0;
	}

	public TravelPackage(Customer customer){
		this();
		this.customer = customer;
	}

	public TravelPackage(Customer customer, Accommodation accommodation){
		this(customer);
		this.accommodation = accommodation;
	}

	public TravelPackage(Customer customer, Accommodation accommodation, LocalDate startDate ){
		this(customer, accommodation);
		this.startDate = startDate;
	}

	public TravelPackage(Customer customer, Accommodation accommodation, LocalDate startDate, int duration ){
		this(customer, accommodation, startDate);
		this.duration = duration;
	}

	public int getID(){
		return packageID;
	}

	public Accommodation getAccommodation(){
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation){
		this.accommodation = accommodation;
	}

	public int getLesson(){
		return lesson;
	}

	public void addLesson(int numLessons){

		int costPerLesson = 0;

		//	Set the cost per lesson according to the customer's skill level.
		switch(this.getCustomer().getSkiLevel()){
			case 1:
				/*	Beginner 	*/
				costPerLesson = 25;
				break;
			case 2:
				/*	Intermediate	*/
				costPerLesson = 20;
				break;
			case 3:
				/*	Expert 	*/
				costPerLesson = 15;
				break;
			default:
				System.out.println("Ski level undefined.");
		}
		this.lesson += costPerLesson * numLessons;
	}

	public int getLiftPass(){
		return liftPass;
	}

	public void addLiftPass(int liftPass){
		this.liftPass += liftPass;
	}

	public Customer getCustomer(){
		return customer;
	}

	public void setCustomer(Customer customer){
		this.customer = customer;
	}

	public int getDuration(){
		return duration;
	}

	public void setDuration(int duration){
		this.duration = duration;
	}

	public LocalDate getStartDate(){
		return startDate;
	}

	public void setStartDate(LocalDate startDate){
		this.startDate = startDate;
	}

	@Override
	public String toString(){
		return "Customer:\t\t" + customer.getName()  + "(ID: " + customer.getID() + ")" + "\nPackage ID:\t\t" + packageID + "\nLessons:\t\t$" + lesson + "\nLift Pass:\t\t$" + liftPass + "\nAccommodation ID:\t" + accommodation.getID() + "\nStart Date:\t\t" + startDate + "\nDuration:\t\t" + duration + " days";
	}
}
