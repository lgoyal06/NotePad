package com.lalit.notepad.event.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JTextArea;

import com.lalit.notepad.core.GlobalApplicationStates;
import com.lalit.notepad.utils.FileUtils;

public class SaveMenuEventListener implements MouseListener {

	private final JTextArea textArea;

	public SaveMenuEventListener(JTextArea textArea) {
		this.textArea = textArea;
	}

	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 */
	public void mousePressed(MouseEvent e) {
		if (GlobalApplicationStates.getCurrentFileLocation() != null) {
			try {
				textArea.write(new OutputStreamWriter(
						new FileOutputStream(new File(GlobalApplicationStates.getCurrentFileLocation())), "utf-8"));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {
			FileUtils.saveFile(textArea);
		}
	}

	/**
	 * Invoked when a mouse button has been released on a component.
	 */
	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * Invoked when the mouse enters a component.
	 */
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * Invoked when the mouse exits a component.
	 */
	public void mouseExited(MouseEvent e) {
	}
}