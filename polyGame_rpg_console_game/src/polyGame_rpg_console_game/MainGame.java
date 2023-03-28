package polyGame_rpg_console_game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainGame extends _Run {

	private static StringBuffer buffer;
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	UserManager user = UserManager.getInstance();

	public MainGame() {
		buffer = new StringBuffer();
		br = null;
		bw = null;
	}

	public void run() {

		while (true) {
			
			if(!user.isLoggedIn()) {
				userManagement();
			}
			
		}
	}
	
	private void userManagement() {

		System.out.println("[ LostYark RPG ]");
		if(user.checkLogIn() != null)
			System.out.print(user.checkLogIn());
		System.out.println("[1] 회원가입");
		System.out.println("[2] 회원탈퇴");
		System.out.println("[3] 로그인");
		System.out.println("[4] 로그아웃");
		System.out.print(": ");

		String sel = inputValue();
		int sel2 = checkString(sel);

		if (sel2 == 1) user.signUp();
		 else if(sel2 == 2) user.leave();
		 else if(sel2 == 3) user.logIn();
		 else if(sel2 == 4) user.logOut();
	}

	@SuppressWarnings("null")
	public static int checkString(String sel) {
		try {
			int select = Integer.parseInt(sel);
			return select;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (Integer) null;
	}

	public static String inputValue() {
		String input = "";
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			bw.write(buffer.toString());
			bw.flush();

			input = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return input;
	}


}
