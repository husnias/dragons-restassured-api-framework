package tek.api.model;

public class PrimaryAccount {
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String title;
	private String gender;
	private String maritalStatus;
	private String employmentStatus;
	private String dateOfBirth;
	
	//NoArgsConstructor
	public PrimaryAccount() {}
	//AllArgsConstructor
	
	public PrimaryAccount(Long id, String email, String firstName, String lastName, String title, String gender,
			String maritalStatus, String employmentStatus, String dateOfBirth) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.employmentStatus = employmentStatus;
		this.dateOfBirth = dateOfBirth;
	}
	//Constructor without ID
	public PrimaryAccount(String email, String firstName, String lastName, String title, String gender,
			String maritalStatus, String employmentStatus, String dateOfBirth) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.employmentStatus = employmentStatus;
		this.dateOfBirth = dateOfBirth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

}
