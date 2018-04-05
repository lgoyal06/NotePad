package com.lalit.notepad.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.lalit.notepad.core.GlobalApplicationStates;

public final class FileUtils {

	public static final void saveFile(JTextArea textArea) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save As");
		if (fileChooser.showSaveDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try {
				textArea.write(new OutputStreamWriter(new FileOutputStream(selectedFile), "utf-8"));
				GlobalApplicationStates.setCurrentFileLocation(selectedFile.getAbsolutePath());
				GlobalApplicationStates.updateJFrameTitle(selectedFile.getName());
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
	}

	public static final void openFile(JTextArea textArea) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Open");
		if (fileChooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try {
				textArea.read(new InputStreamReader(new FileInputStream(selectedFile), "utf-8"), "txt");
				GlobalApplicationStates.updateJFrameTitle(selectedFile.getName());
				GlobalApplicationStates.setCurrentFileLocation(selectedFile.getAbsolutePath());
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
	}

	public static final String readFile(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}

}
