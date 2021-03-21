package servletapp.model;

import java.time.LocalDate;

public class User {

	private int id;
	private String name;
	private String lastName;
	// private LocalDate dateBirth;
	private String email;
	private String password;
	
	public static class Builder {
		private int id;
		private String name;
		private String lastName;
		
		private String email;
		private String password;
		
		public Builder id(int id) {
			this.id = id;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
	public User(Builder builder) {
		id = builder.id;
		name = builder.name;
		lastName = builder.lastName;
		email = builder.email;
		password = builder.password;
	}

	public User(String name, String lastName, String email, String password) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
