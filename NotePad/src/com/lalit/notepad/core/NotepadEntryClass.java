package com.lalit.notepad.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

import com.lalit.notepad.component.builder.MenuBarBuilder;
import com.lalit.notepad.event.listener.newmenu.ExitMenuEventListener;
import com.lalit.notepad.event.listener.newmenu.NewMenuEventListener;
import com.lalit.notepad.event.listener.newmenu.OpenMenuEventListener;
import com.lalit.notepad.event.listener.newmenu.SaveAsMenuEventListener;
import com.lalit.notepad.event.listener.newmenu.SaveMenuEventListener;

public class NotepadEntryClass {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Untitled - NotePad");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextArea textArea = new JTextArea();
		textArea.setOpaque(true);
		textArea.setPreferredSize(new Dimension(880, 500));

		// Fluent Design API Patteren
		JMenuBar menuBar = new MenuBarBuilder().addMenu("File", true, new Color(54, 165, 127))
				.addMenuItems("New    Ctrl+N", true, new Color(14, 165, 127))
				.addMouseListener(new NewMenuEventListener())
				.addMenuItems("Open   Ctrl+O", true, new Color(14, 165, 127))
				.addMouseListener(new OpenMenuEventListener())
				.addMenuItems("Save   Ctrl+S", true, new Color(14, 165, 127))
				.addMouseListener(new SaveMenuEventListener()).addMenuItems("Save As", true, new Color(14, 165, 127))
				.addMouseListener(new SaveAsMenuEventListener())
				.addMenuItems("Page SetUp...", true, new Color(14, 165, 127))
				.addMenuItems("Print  Ctrl+P", true, new Color(14, 165, 127))
				.addMenuItems("Exit", true, new Color(14, 165, 127)).addMouseListener(new ExitMenuEventListener())
				.build();

		menuBar = new MenuBarBuilder(menuBar).addMenu("Edit", true, new Color(54, 165, 127))
				.addMenuItems("Undo", true, new Color(14, 165, 127)).addMenuItems("Cut", true, new Color(14, 165, 127))
				.addMenuItems("Copy", true, new Color(14, 165, 127))
				.addMenuItems("Paste", true, new Color(14, 165, 127))
				.addMenuItems("Delete", true, new Color(14, 165, 127))
				.addMenuItems("Find...", true, new Color(14, 165, 127))
				.addMenuItems("Find Next", true, new Color(14, 165, 127))
				.addMenuItems("Replace...", true, new Color(14, 165, 127))
				.addMenuItems("Go To...", true, new Color(14, 165, 127))
				.addMenuItems("Select All", true, new Color(14, 165, 127))
				.addMenuItems("Time/Date", true, new Color(14, 165, 127)).build();

		menuBar = new MenuBarBuilder(menuBar).addMenu("Format", true, new Color(54, 165, 127))
				.addMenuItems("Word Wrap", true, new Color(14, 165, 127))
				.addMenuItems("Font...", true, new Color(14, 165, 127)).build();

		menuBar = new MenuBarBuilder(menuBar).addMenu("View", true, new Color(54, 165, 127))
				.addMenuItems("Status Bar", true, new Color(14, 165, 127)).build();

		menuBar = new MenuBarBuilder(menuBar).addMenu("Help", true, new Color(54, 165, 127))
				.addMenuItems("View Help", true, new Color(14, 165, 127))
				.addMenuItems("About Notepad", true, new Color(14, 165, 127)).build();

		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);

		GlobalApplicationObjects.setMainJFrame(frame);
		GlobalApplicationObjects.setMainJTextArea(textArea);
	}
}