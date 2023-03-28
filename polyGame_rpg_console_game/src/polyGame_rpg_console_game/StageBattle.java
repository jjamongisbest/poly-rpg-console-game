package polyGame_rpg_console_game;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle extends Stage {
	
	UserManager manager = UserManager.getInstance();
	
	ArrayList<Player> playerList;
	ArrayList<Unit> monList;
	Random ran;
	int monsterDead;
	int playerDead;
	

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
