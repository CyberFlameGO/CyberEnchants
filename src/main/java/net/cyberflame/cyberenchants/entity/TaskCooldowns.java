package net.cyberflame.cyberenchants.entity;

import java.util.UUID;

public class TaskCooldowns {

	//Variables
	private UUID uuid;
	private String effect;
	private Integer idTask;
	
	//Constructor
	public TaskCooldowns(UUID uuid, String effect, Integer idTask) {
		super();
		this.uuid = uuid;
		this.effect = effect;
		this.idTask = idTask;
	}

	public TaskCooldowns() {
		
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public Integer getIdTask() {
		return idTask;
	}

	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}

	
}
