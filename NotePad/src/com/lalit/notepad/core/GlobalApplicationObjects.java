package com.lalit.notepad.core;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public final class GlobalApplicationObjects {

	private static String currentFileLocation = null;
	private static JFrame jFrame;
	private static JTextArea jTextArea;

	private GlobalApplicationObjects() {
	}

	public static synchronized String getCurrentFileLocation() {
		return currentFileLocation;
	}

	protected static synchronized void setMainJFrame(JFrame frame) {
		jFrame = frame;
	}

	protected static synchronized void setMainJTextArea(JTextArea textArea) {
		jTextArea = textArea;
	}

	public static synchronized String getTextAreaText() {
		return jTextArea.getText();
	}

	public static synchronized int getTextAreaLength() {
		return jTextArea.getDocument().getLength();
	}

	public static synchronized void setTextAreaText(String text) {
		jTextArea.setText(text);
	}

	public static synchronized void writeToFile(OutputStreamWriter osw) {
		try {
			jTextArea.write(osw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void writeToTextArea(InputStreamReader isr, Object desc) {
		try {
			jTextArea.read(isr, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void updateJFrameTitle(String frameTitle) {
		jFrame.setTitle(frameTitle);
	}

	public static synchronized String getCurrentTextOnTextArea() {
		return jTextArea.getText();
	}

	public static synchronized void resetCurrentFileLocation() {
		currentFileLocation = null;
	}

	public static synchronized void setCurrentFileLocation(String fileLocation) {
		currentFileLocation = fileLocation;
	}
}
