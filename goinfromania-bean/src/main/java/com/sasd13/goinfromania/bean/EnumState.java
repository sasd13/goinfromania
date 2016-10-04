package com.sasd13.goinfromania.bean;

public enum EnumState {
	NONE(0),
	CREATED(1), 
	STARTED(2), 
	RESUMED(3), 
	PAUSED(4), 
	STOPPED(5), 
	DESTROYED(6),
	;

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
