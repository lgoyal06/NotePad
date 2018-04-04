package com.lalit.notepad.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.lalit.notepad.core.GlobalApplicatinStates;

public class FileUtils {

	public static void saveFile(JTextArea textArea) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save");
		if (fileChooser.showSaveDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try {
				textArea.write(new OutputStreamWriter(new FileOutputStream(selectedFile), "utf-8"));
				GlobalApplicatinStates.setCurrentFileLocation(selectedFile.getAbsolutePath());
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
	}

	public static void openFile(JTextArea textArea) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Open");
		if (fileChooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try {
				textArea.read(new InputStreamReader(new FileInputStream(selectedFile), "utf-8"), "txt");
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
	}

}
