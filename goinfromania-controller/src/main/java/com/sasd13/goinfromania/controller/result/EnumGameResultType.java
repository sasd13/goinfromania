package com.sasd13.goinfromania.controller.result;

public enum EnumGameResultType {
	REPLAY("REPLAY"),
	END("END"),
	;

	private String code;

	private EnumGameResultType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static EnumGameResultType find(String code) {
		for (EnumGameResultType type : values()) {
			if (type.code.equalsIgnoreCase(code)) {
				return type;
			}
		}

		return null;
	}
}
