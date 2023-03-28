package polyGame_rpg_console_game;

import java.util.ArrayList;

public class UnitManager {

	private static UnitManager instance = new UnitManager();

	private ArrayList<Unit> mon_list = new ArrayList<>();

	private String path = "polyGame_rpg_console_game."; // 패키지명 + .

	String mons[] = { "UnitOgre", "UnitMimic", "UnitHydra", "UnitGriffin", "UnitLich" };

	private UnitManager() {
	}

	public static UnitManager getInstance() {
		return instance;
	}

}
