package polyGame_rpg_console_game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserManager {

	private String[] jobs = { "소서리스", "서머너", "인파이터", "홀리나이트", "도화가" };

	private Map<String, User> userList;

	private int log;
	private String loggedInId;

	private UserManager() {
		this.userList = new HashMap<String, User>();
		this.log = -1;
		this.loggedInId = "";
	}

	private static UserManager instance = new UserManager();

	public void signUp() {

		System.out.print("[회원가입 NAME] : ");
		String name = MainGame.inputValue();
		System.out.print("[회원가입 ID] : ");
		String id = MainGame.inputValue();
		System.out.print("[회원가입 PW] : ");
		String pw = MainGame.inputValue();

		if (!userList.containsKey(id)) {
			User user = setUser(name, id, pw);
			userList.put(id, user);

			System.out.printf("[메세지] 회원가입 완료! 어서오세요 << %s >> %s님!\n", user.getJob(), user.getId());
		} else {
			System.out.println("[메세지] 이미 가입된 회원입니다.");
		}

	}

	public void leave() {
		System.out.print("[회원탈퇴 ID] :");
		String id = MainGame.inputValue();
		System.out.print("[회원탈퇴 PW] :");
		String pw = MainGame.inputValue();

		if (userList.containsKey(id)) {
			User target = userList.get(id);
			if (target.getPassword().equals(pw)) {
				this.userList.remove(id);
				System.out.println("[메세지] 회원탈퇴가 완료되었습니다.");
			} else
				System.err.println("[메세지] 회원정보를 확인해주세요");
		}
	}

	private void printJobList() {
		for (int i = 0; i < this.jobs.length; i++)
			System.out.printf("[%d] %s\n", i + 1, jobs[i]);
	}

	public void logIn() {
		System.out.print("[로그인 ID] : ");
		String id = MainGame.inputValue();
		System.out.print("[로그인 PW] : ");
		String pw = MainGame.inputValue();

		if (userList.containsKey(id)) {
			User target = this.userList.get(id);
			if (target.getPassword().equals(pw)) {
				this.log = target.getUserKey();
				this.loggedInId = target.getId();
				System.out.printf("<< %s >> %s 님이 전장에 소환되었습니다.\n", target.getJob(), target.getId());
			}
		}
	}

	public void logOut() {
		this.log = 0;
		this.loggedInId = "";
		System.out.println("[메세지] 로그아웃이 완료되었습니다.");
	}

	public void printUserList() {
		for (User target : this.userList.values()) {
			System.out.println(target);
		}
	}

	private User setUser(String name, String id, String pw) {

		String job = "undefined";

		while (true) {
			printJobList();
			String sel = MainGame.inputValue();
			int sel2 = MainGame.checkString(sel);

			System.out.println("sel2 : " + sel2);

			if (sel2 >= 1 && sel2 <= 5) {
				if (sel2 == 1)
					job = jobs[0];
				else if (sel2 == 2)
					job = jobs[1];
				else if (sel2 == 3)
					job = jobs[2];
				else if (sel2 == 4)
					job = jobs[3];
				else if (sel2 == 5)
					job = jobs[4];

				break;
			} else
				System.err.println("[메세지] 유효한 번호를 입력해주세요");
		}

		User temp = new User();

		temp.setName(name);
		temp.setId(id);
		temp.setPassword(pw);
		temp.setUserKey(keyGenerator());
		temp.setJob(job);

		return temp;
	}

	private int keyGenerator() {
		Random ran = new Random();
		int key = -1;

		while (true) {
			key = ran.nextInt(8999) + 1000;

			boolean keyExists = false;

			for (User target : this.userList.values()) {
				if (target.getUserKey() == key) {
					keyExists = true;
					break;
				}
			}
			if (!keyExists) {
				break;
			}
		}

		return key;
	}

	public String checkLogIn() {
		if (this.log != -1) {
			User target = userList.get(this.loggedInId);
			if(target != null)
				return String.format("[ << %s >> %s 님 ]\n", target.getJob(), target.getId());
			else
				return null;
		} else
			return null;
	}
	
	public boolean isLoggedIn() {
		return this.log != -1;
	}

	public static UserManager getInstance() {
		return instance;
	}

}
