package fr.nkri.jobs.utils;

public enum JobsUnit {

	FARMER("Farmeur", "§a"),
	HUNTER("Hunter", "§c"), 
	MINER("Mineur", "§e"),
	NONE("", "§7"),
	;
	
	private String prefix;
	private String color;
	
	private JobsUnit(String prefix, String color) {
		this.prefix = prefix;
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String getDisplay() {
		return getColor() + getPrefix();
	}
}
