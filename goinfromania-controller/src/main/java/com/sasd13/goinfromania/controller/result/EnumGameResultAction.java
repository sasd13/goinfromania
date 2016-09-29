package com.sasd13.goinfromania.controller.result;

public enum EnumGameResultAction {
	REPLAY("REPLAY"),
	END("END"),
	;

	private String code;

	private EnumGameResultAction(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static EnumGameResultAction find(String code) {
		for (EnumGameResultAction action : values()) {
			if (action.code.equalsIgnoreCase(code)) {
				return action;
			}
		}

		return null;
	}
}
