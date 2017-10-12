package com.general.notepad.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.general.notepad.model.Notepad;
import com.general.notepad.model.dialog.ConfirmExitDialog;
import com.general.notepad.model.dialog.ErrorDialog;

/**
 * 
 * @author Abhishek Kumar
 *
 *
 */

public class FileTabActions {

	private final Notepad parent;

	public FileTabActions(Notepad parent) {
		super();
		this.parent = parent;
	}

	// New
	public void newTab() {
		new Notepad();
	}

	// Open
	public String open(String file) {
		
		boolean isSelected = false;
		StringBuffer sb = new StringBuffer("");
		File f = new File(file);
		String s = null;
		try {
			isSelected = (f == null) ? false : true;
			if (isSelected) {
				BufferedReader br = new BufferedReader(new FileReader(f));
				do {
					s = br.readLine();
					if (s != null)
						sb.append(s + "\n");
				} while (s != null);
				br.close();
			}
		} catch (FileNotFoundException e) {
			new ErrorDialog(parent, "Selected file does not exist!!!");
			e.printStackTrace();
		} catch (IOException e) {
			new ErrorDialog(parent, "Some internal problem. Try Later!!!");
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	// Save
	public void save(String dir, String fileName, String content) {
		File f = new File(dir, fileName);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				new ErrorDialog(parent, "Error while saving file. Try again later...");
				e.printStackTrace();
			}
		}
		try {
			FileWriter fr = new FileWriter(f);
			fr.write(content);
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Save As...
	public void saveAs(String dir, String fileName, String content) {
		save(dir, fileName, content);
	}
	
	// Page Setup
	// To implement
	
	// Print
	// To Implement
	
	// Exit
	public void exit() {
		ConfirmExitDialog exit = new ConfirmExitDialog(parent, "Confirm Exit", "Do you really wish to exit");
		if (exit.getIsOk())
			System.exit(0);
		else
			exit.dispose();
	}
}
