package models;

public class Person {
	//variables
	protected long id;
	protected String name;
	protected String surname;
	protected String personCode;
	protected static long idCounter = 0;
	
	//getters
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getPersonCode() {
		return personCode;
	}
	public static long getIdCounter() {
		return idCounter;
	}
	
	//setters
	public void  setName(String name) {
		if (name.matches("[A-ZĀĒŪĪŠĢĶĻŽŅČ]{1}[a-zāēūīšģķļžņč]+[ ]?([A-ZĀĒŪĪŠĢĶĻŽŅČ]{1}[a-zāēūīšģķļžņč]+)?")) {
			this.name = name;
		} else {
			this.name = "Unknown";
		}
	}
	
	public void  setSurname(String surname) {
		if (name.matches("[A-ZĀĒŪĪŠĢĶĻŽŅČ]{1}[a-zāēūīšģķļžņč]+([-][A-ZĀĒŪĪŠĢĶĻŽŅČ]{1}[a-zāēūīšģķļžņč]+)?")) {
			this.surname = surname;
		} else {
			this.surname = "Unknown";
		}
	}
	
	public void  setPersonCode(String personCode) {
		if (personCode != null && personCode.matches("([0-9]{6}[-][0-9]{5})")) {
			this.personCode = personCode;
		} else {
			this.personCode = "Unknown";
		}
	}
	
	public void setId() {
		id = idCounter;
		idCounter++;
	}
	
	//constructors
		public Person() {
			setId();
			setName("Default");
			setSurname("Default");
			setPersonCode("000000-00000");
		}
		
		public Person(String name, String surname, String personCode) { 
			setId();
			setName(name);
			setSurname(surname);
			setPersonCode(personCode);
		}
	
}