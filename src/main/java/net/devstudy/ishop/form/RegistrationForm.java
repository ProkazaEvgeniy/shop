package net.devstudy.ishop.form;

public class RegistrationForm {
	private String name;
	private String email;
	private String avatarUrl;
	public RegistrationForm() {
		super();
	}
	public RegistrationForm(String name, String email, String avatarUrl) {
		super();
		this.name = name;
		this.email = email;
		this.avatarUrl = avatarUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
}
