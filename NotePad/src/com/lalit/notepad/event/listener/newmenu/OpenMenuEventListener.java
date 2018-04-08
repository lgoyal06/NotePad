package com.lalit.notepad.event.listener.newmenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lalit.notepad.core.GlobalApplicationObjects;
import com.lalit.notepad.utils.FileUtils;
import com.lalit.notepad.utils.StringUtils;

public class OpenMenuEventListener implements MouseListener {

	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 */
	public void mousePressed(MouseEvent e) {
		if (GlobalApplicationObjects.getCurrentFileLocation() != null) {
			String currentFileData = FileUtils.readFile(GlobalApplicationObjects.getCurrentFileLocation());
			if (!StringUtils.compare(GlobalApplicationObjects.getCurrentTextOnTextArea(), currentFileData)) {
				Object[] options = { "Save", "Don't Save", "Cancel" };
				int optionSelected = JOptionPane.showOptionDialog(new JFrame("NotePad"),
						"Do you want to save changes it?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, options, options[0]);
				if (optionSelected == 0) {
					try {
						GlobalApplicationObjects.writeToFile((new OutputStreamWriter(
								new FileOutputStream(GlobalApplicationObjects.getCurrentFileLocation()), "utf-8")));
						FileUtils.performOpenFileAction();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (optionSelected == 1) {
					FileUtils.performOpenFileAction();
				}
			} else {
				FileUtils.performOpenFileAction();
			}
		} else if (GlobalApplicationObjects.getTextAreaLength() > 0) {
			Object[] options = { "Save", "Don't Save", "Cancel" };
			int optionSelected = JOptionPane.showOptionDialog(new JFrame("NotePad"), "Do you want to save changes it?",
					"", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (optionSelected == 0) {
				FileUtils.performSaveFileAction();
				FileUtils.performOpenFileAction();
			} else if (optionSelected == 1) {
				FileUtils.performOpenFileAction();
			}
		} else {
			FileUtils.performOpenFileAction();
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