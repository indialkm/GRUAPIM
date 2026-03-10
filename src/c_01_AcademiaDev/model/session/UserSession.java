package c_01_AcademiaDev.model.session;

import c_01_AcademiaDev.model.enums.Role;

public class UserSession {
	
	private int userId;
    private String name;
    private Role role;
	
    public UserSession(int userId, String name, Role role) {
		this.userId = userId;
		this.name = name;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
