package fr.nkri.jobs.managers.jobs;

import org.bukkit.entity.Player;

import fr.nkri.jobs.utils.JobsUnit;

public class PlayerJob {

	private Player player;
	private int xp, lvl;
	private JobsUnit jobsUnit;
	
	public PlayerJob(Player player) {
		this.player = player;
		this.xp = 0;
		this.lvl = 0;
		this.jobsUnit = JobsUnit.NONE;
	}
	
	public PlayerJob(Player player, int xp, int lvl, JobsUnit jobs) {
		this.player = player;
		this.xp = xp;
		this.lvl = lvl;
		this.jobsUnit = jobs;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getLvl() {
		return lvl;
	}
	
	public int getXp() {
		return xp;
	}
	
	public JobsUnit getJobsUnit() {
		return jobsUnit;
	}
	
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	
	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public void setJobsUnit(JobsUnit jobsUnit) {
		this.jobsUnit = jobsUnit;
	}
	
	public void addLvl(int lvl) {
		this.lvl += lvl;
	}
	
	public void addXp(int xp) {
		this.xp += xp;
	}
}
