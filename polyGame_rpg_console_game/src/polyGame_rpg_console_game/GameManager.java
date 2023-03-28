package polyGame_rpg_console_game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {

	private static GameManager instance = new GameManager();
	
	private static StringBuffer buffer;
	public static BufferedReader br;
	public static BufferedWriter bw;

	private Random ran;
	private static Scanner sc;
	private static String nextStage;
	private String CurStage;
	
	Map<String, Stage> stageList = new HashMap<>();

	private GameManager() {
		this.ran = new Random();
		this.sc = new Scanner(System.in);
		this.nextStage = "TITLE";
		
		this.stageList.put("TITLE", new StageTitle());
		buffer = new StringBuffer();
		br = null;
		bw = null;
		
	}

	public static GameManager getInstance() {
		return instance;
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
	
	public static void setNextStage(String stage) {
		nextStage = stage;
	}

}
