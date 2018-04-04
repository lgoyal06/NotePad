package com.lalit.notepad.component.builder;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public final class MenuBarBuilder {
	private final JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItems;

	public MenuBarBuilder(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public MenuBarBuilder() {
		this(new Color(154, 165, 127), true, new Dimension(200, 20));
	}

	private MenuBarBuilder(Color rbg, boolean isOpaque, Dimension dimension) {

		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(isOpaque);
		menuBar.setBackground(rbg);
		menuBar.setPreferredSize(dimension);
		this.menuBar = menuBar;
	}

	public MenuBarBuilder addMenu(String name, boolean isVisible, Color rbg) {
		JMenu menu = new JMenu(name);
		menu.setVisible(isVisible);
		menu.setBackground(rbg);
		menuBar.add(menu);
		this.menu = menu;
		return this;
	}

	public MenuBarBuilder addMenuItems(String name, boolean isVisible, Color rbg) {
		JMenuItem menuItems = new JMenuItem(name);
		menuItems.setVisible(isVisible);
		menuItems.setBackground(rbg);
		menu.add(menuItems);
		this.menuItems = menuItems;
		return this;
	}

	public MenuBarBuilder addMouseListener(java.awt.event.MouseListener listener) {
		menuItems.addMouseListener(listener);
		return this;
	}

	public JMenuBar build() {
		return menuBar;
	}
}
