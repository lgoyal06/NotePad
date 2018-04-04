package com.lalit.notepad.core;

public final class GlobalApplicatinStates {

	private static String currentFileLocation = null;

	private GlobalApplicatinStates() {
	}

	public static synchronized String getCurrentFileLocation() {
		return currentFileLocation;
	}

	public static synchronized void setCurrentFileLocation(String fileLocation) {
		currentFileLocation = fileLocation;
	}

}
