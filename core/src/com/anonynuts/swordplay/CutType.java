package com.anonynuts.swordplay;

/**
 * Various cut types.
 */
public enum CutType {

	REST(""),
	FEDENTE ("Fendente"),
	MONTANTE ("Montante"),
	TONDO ("Tondo"),
	RIVERSO_TONDO ("Riverso Tondo");

	private final String display;

	CutType(String display) {
		this.display = display;
	}

	String display() {
		return this.display;
	}

}
