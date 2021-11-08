package edu.umb.cs680.hw04;

public class Student {

	private String name;
	private String usAddress;
	private String foreignAddress;
	private String state;
	private int i20Number;
	private int yearsInState;
	private float tuitionFee;
	private StudentFactory status;

	

	private Student(String name, String usAddress, String foreignAddress,String state, int i20Number, int yearsInState,
			 StudentFactory status) {

		this.name = name;
		this.usAddress = usAddress;
		this.foreignAddress = foreignAddress;
		this.state = state;
		this.i20Number = i20Number;
		this.yearsInState = yearsInState;
		this.status = status;
	}
	
	public static Student createInStateStudent(String name, String usAddress) {
		return new Student(name, usAddress, null, null, 0,0, StudentFactory.INSTATE);
	}

	public static Student createOutStateStudent(String name, String usAddress, int yearsInState,String state) {
		return new Student(name, usAddress, null, state, 0, yearsInState, StudentFactory.OUTSTATE);
	}

	public static Student createIntlStudent(String name, String usAddress, int i20, String foreignAddress) {
		return new Student(name, usAddress, foreignAddress, null, i20, 0, StudentFactory.INTERNATIONAL);
	}
	
	
	public String getName() {
		return name;
	}

	public String getUsAddress() {
		return usAddress;
	}

	public String getForeignAddress() {
		return foreignAddress;
	}
	
	public String getState() {
		return state;
	}

	public int getI20Number() {
		return i20Number;
	}

	public int getYearsInState() {
		return yearsInState;
	}
	
	public float getTuition() {
		if (status.equals(StudentFactory.INSTATE))
			return 9000;
		else if (status.equals(StudentFactory.OUTSTATE))
			return 12000;
		else
			return 17000;
	}

	public StudentFactory getStatus() {
		return status;
	}

	public static void main(String[] args) {
		Student internationalStudent = createIntlStudent("bano", "Nashua", 1234, "Andhra Pradesh");
		System.out.println("Status of student: " + internationalStudent.getStatus() +"\n"
				             +"Name of student : "+internationalStudent.getName()+ "\n"
				             +"US address : "+internationalStudent.getUsAddress()+"\n"
				             +"I20 number : "+internationalStudent.getI20Number()+ "\n"
				             +"Student tuitionFee : "+internationalStudent.getTuition() + "\n");
		
		System.out.println("Updated international student Successfully"+"\n");
		
		Student InStateStudent = createInStateStudent("John","Chicago");
		System.out.println("Status of student: " + InStateStudent.getStatus() +"\n"
				             +"Name of student : "+InStateStudent.getName()+ "\n"
				             +"US address : "+InStateStudent.getUsAddress()+"\n"
				             +"Student tuitionFee : "+InStateStudent.getTuition()+"\n");
		
		

	}

}