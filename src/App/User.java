package App;

import java.io.IOException;
import java.util.ArrayList;

public class User {

	// Properties For User
	String Name;
	String Password;
	String Email;

	ArrayList<Player> allPlayers = new ArrayList<>();

	public User(String Name, String password, String email) {
		this.Name = Name;
		this.Password = password;
		this.Email = email;
	}

	public User() {

	}

	// Getters and setters for User
	public String getUserName() {
		return this.Name;
	}

	public void setUserName(String userName) {
		this.Name = userName;
	}

	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public boolean login() throws IOException, IOException {
		return false;
	}
}
