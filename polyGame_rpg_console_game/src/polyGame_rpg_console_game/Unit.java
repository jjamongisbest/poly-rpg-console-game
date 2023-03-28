package polyGame_rpg_console_game;

public abstract class Unit {

	private int curHp;
	private int maxHp;
	private int power;
	private String name;
	private String state = "노말";
	
	public Unit(String name, int maxhp, int power) {
		this.name = name;
		this.maxHp = maxhp;
		this.power = power;
	}
	
	public void init(int maxhp, int power) {
		this.maxHp = maxhp;
		this.curHp = maxhp;
		this.power = power;
	}
	
	public void init(String name, int maxHp, int power) {
		this.name = name;
		this.maxHp = maxHp;
		this.curHp = maxHp;
		this.power = power;
	}
	
	void attack(Unit target) {
		target.curHp -= this.power;
		System.out.println("[" + this.name + "] 이 " + "[" + target.name + "] 에게 " + this.power + "의 데미지를 입힙니다. ");
		if (target.curHp <= 0) {
			System.out.println("[" + target.name + "] 을 쳐치했습니다.");
			target.curHp = 0;
		}
	}
	
}
