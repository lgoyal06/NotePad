package com.lalit.notepad.event.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.lalit.notepad.core.GlobalApplicationStates;
import com.lalit.notepad.utils.FileUtils;
import com.lalit.notepad.utils.StringUtils;

public class OpenMenuEventListener implements MouseListener {

	private final JTextArea textArea;

	public OpenMenuEventListener(JTextArea textArea) {
		this.textArea = textArea;
	}

	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 */
	public void mousePressed(MouseEvent e) {
		if (GlobalApplicationStates.getCurrentFileLocation() != null) {
			String currentFileData = FileUtils.readFile(GlobalApplicationStates.getCurrentFileLocation());
			if (!StringUtils.compare(textArea.getText(), currentFileData)) {
				Object[] options = { "Save", "Don't Save", "Cancel" };
				int optionSelected = JOptionPane.showOptionDialog(new JFrame("NotePad"),
						"Do you want to save changes it?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, options, options[0]);
				if (optionSelected == 0) {
					try {
						textArea.write(new OutputStreamWriter(
								new FileOutputStream(GlobalApplicationStates.getCurrentFileLocation()), "utf-8"));
						FileUtils.openFile(textArea);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (optionSelected == 1) {
					FileUtils.openFile(textArea);
				}
			} else {
				FileUtils.openFile(textArea);
			}
		} else if (textArea.getDocument().getLength() > 0) {
			Object[] options = { "Save", "Don't Save", "Cancel" };
			int optionSelected = JOptionPane.showOptionDialog(new JFrame("NotePad"), "Do you want to save changes it?",
					"", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (optionSelected == 0) {
				FileUtils.saveFile(textArea);
			} else if (optionSelected == 1) {
				FileUtils.openFile(textArea);
			}
		} else {
			FileUtils.openFile(textArea);
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