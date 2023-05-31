package tek.api.model;

import java.util.Date;

public class PrimaryAccount {
	private long id; 
	private String email;
	private String firstName; 
	private String lastName; 
	private String title; 
	private String gender; 
	private String maritalStatus; 
	private String employmentStatus; 
	private Date dateOfBirth; 
	private Object user; 
	
	//NoArgsConstructor
	public PrimaryAccount() {}
	//AllArgsConstructor
	public PrimaryAccount(long id, String email, String firstName, String lastName, String title, String gender,
			String maritalStatus, String employmentStatus, Date dateOfBirth, Object user) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.employmentStatus = employmentStatus;
		this.dateOfBirth = dateOfBirth;
		this.user = user;
	}
	
	//Constructor without ID
	public PrimaryAccount(String email, String firstName, String lastName, String title, String gender,
			String maritalStatus, String employmentStatus, Date dateOfBirth) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.employmentStatus = employmentStatus;
		this.dateOfBirth = dateOfBirth;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Object getUser() {
		return user;
	}
	public void setUser(Object user) {
		this.user = user;
	}
	
	
}