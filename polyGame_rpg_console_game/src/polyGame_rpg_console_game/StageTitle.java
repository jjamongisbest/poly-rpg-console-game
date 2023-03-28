package polyGame_rpg_console_game;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("==== LOST YARK ====");
		System.out.println("PRESS ANY BUTTON");
		String start = GameManager.inputValue();

		GameManager.setNextStage("LOBBY");
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
