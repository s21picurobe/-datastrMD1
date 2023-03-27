package models;

public class Student extends Person {
	//variables
	private Faculty faculty;
	
	//getters
	public long getId() {return id;}
	public String getName() {return name;}
	public String getSurname() {return surname;}
	public Faculty getFaculty() {return faculty;}
	public String getPersonCode() {return personCode;}
	
	//setters
	public void setFaculty(Faculty faculty) {
		if (faculty != null) {
			this.faculty = faculty;
		} else {
			this.faculty = Faculty.NA;
		}
	}

	//constructors
	public Student() {
		super();
		setFaculty(Faculty.NA);
	}
	
	public Student(String name, String surname, Faculty faculty, String personCode) { 
		super(name, surname, personCode);
		setFaculty(Faculty.NA);
	}
	
	//to string
	public String toString() {
		return "\u001b[31m student{" + id + ": " + name + " " + surname + ", " + personCode + ", " + faculty + "} \u001b[0m";
	}
}