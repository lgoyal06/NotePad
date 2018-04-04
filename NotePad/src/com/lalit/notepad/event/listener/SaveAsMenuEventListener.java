package com.lalit.notepad.event.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextArea;

import com.lalit.notepad.utils.FileUtils;

public class SaveAsMenuEventListener implements MouseListener {

	private final JTextArea textArea;

	public SaveAsMenuEventListener(JTextArea textArea) {
		this.textArea = textArea;
	}

	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 */
	public void mousePressed(MouseEvent e) {
		FileUtils.saveFile(textArea);
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