package polyGame_rpg_console_game;

public class StageLobby extends Stage {

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean update() {
		System.out.println("===== [LOBBY] =====");
		System.out.println("[1] 전투   [2] 종료");
		String sel = GameManager.inputValue();
		
		if(sel.equals(1))
			GameManager.setNextStage("BATTLE");
		else if(sel.equals(2))
			GameManager.setNextStage("");
		else
			GameManager.setNextStage("");
		
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	
	
}
