package fr.nkri.jobs.utils;

public enum JobsUnit {

	FARMER("Farmeur", "§a", "lvl_farmer", "xp_farmer"),
	HUNTER("Hunter", "§c", "lvl_hunter", "xp_hunter"), 
	MINER("Mineur", "§e", "lvl_miner", "xp_miner"),
	NONE("", "§7", "", ""),
	;

	private String prefix;
	private String color;
	private String lvl;
	private String exp;
	
	private JobsUnit(String prefix, String color, String lvl, String exp) {
		this.prefix = prefix;
		this.color = color;
		this.lvl = lvl;
		this.exp = exp;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String getLvl() {
		return lvl;
	}
	
	public String getExp() {
		return exp;
	}
	
	public String getDisplay() {
		return getColor() + getPrefix();
	}
}
