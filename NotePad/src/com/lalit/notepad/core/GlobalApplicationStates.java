package com.lalit.notepad.core;

import javax.swing.JFrame;

public final class GlobalApplicationStates {

	private static String currentFileLocation = null;
	private static JFrame jFrame;

	private GlobalApplicationStates() {
	}

	public static synchronized String getCurrentFileLocation() {
		System.out.println("currentFileLocation" + currentFileLocation);
		return currentFileLocation;
	}

	protected static synchronized void setMainJFrame(JFrame frame) {
		jFrame = frame;
	}

	public static synchronized void updateJFrameTitle(String frameTitle) {
		jFrame.setTitle(frameTitle);
	}

	public static synchronized void resetCurrentFileLocation() {
		currentFileLocation = null;
	}

	public static synchronized void setCurrentFileLocation(String fileLocation) {
		currentFileLocation = fileLocation;
	}
}
