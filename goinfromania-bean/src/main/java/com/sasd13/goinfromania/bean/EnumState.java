package com.sasd13.goinfromania.bean;

public enum EnumState {
	NONE(-1), 
	CREATED(0), 
	STARTED(1), 
	RESUMED(2), 
	PAUSED(3), 
	STOPPED(4), 
	DESTROYED(5),;

	private int order;

	private EnumState(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public static EnumState find(int order) {
		for (EnumState state : values()) {
			if (state.order == order) {
				return state;
			}
		}

		return null;
	}
}
