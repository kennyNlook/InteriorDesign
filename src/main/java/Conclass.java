
public class Conclass {
	private String Register,Phone,gender,location;

	public Conclass() {
		super();
	}

	public Conclass(String register, String phone, String gender, String location) {
		super();
		Register = register;
		Phone = phone;
		this.gender = gender;
		this.location = location;
	}

	public String getRegister() {
		return Register;
	}

	public void setRegister(String register) {
		Register = register;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
