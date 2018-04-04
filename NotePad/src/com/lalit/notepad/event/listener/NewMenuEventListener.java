package com.lalit.notepad.event.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.lalit.notepad.utils.FileUtils;
import com.lalit.notepad.utils.StringUtils;

public class NewMenuEventListener implements MouseListener {

	private final JTextArea textArea;

	public NewMenuEventListener(JTextArea textArea) {
		this.textArea = textArea;
	}

	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 */
	public void mousePressed(MouseEvent e) {
		// TODO Compare Saved and Current text in text area utils
		// if both are same
		// Create UnTitled file and reset current file location to null
		// else
		Object[] options = { "Save", "Don't Save", "Cancel" };
		if (textArea.getDocument().getLength() > 0) {
			int optionSelected = JOptionPane.showOptionDialog(new JFrame("NotePad"),
					"Do you want to save changes to Untitled?", "", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (optionSelected == 0) {
				FileUtils.saveFile(textArea);
			} else if (optionSelected == 1) {
				textArea.setText("");
			}
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