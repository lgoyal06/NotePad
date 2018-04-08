package com.lalit.notepad.event.listener.newmenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import com.lalit.notepad.core.GlobalApplicationObjects;
import com.lalit.notepad.utils.FileUtils;

public class SaveMenuEventListener implements MouseListener {

	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 */
	public void mousePressed(MouseEvent e) {
		if (GlobalApplicationObjects.getCurrentFileLocation() != null) {
			try {
				GlobalApplicationObjects.writeToFile((new OutputStreamWriter(
						new FileOutputStream(GlobalApplicationObjects.getCurrentFileLocation()), "utf-8")));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {
			FileUtils.performSaveFileAction();
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