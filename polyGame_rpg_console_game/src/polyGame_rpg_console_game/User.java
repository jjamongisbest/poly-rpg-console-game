package polyGame_rpg_console_game;

public class User {

	private String id;
	private String password;
	private String name;
	private int userKey;
	private String job;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%s : %s / %s", this.name, this.id, this.password);
	}
	
	public int getUserKey() {
		return this.userKey;
	}
	
	public void setUserKey(int userKey) {
		this.userKey = userKey;
	}
	
	public String getJob() {
		return this.job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}

}
