package com.general.notepad.action;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.general.notepad.model.Notepad;
import com.general.notepad.model.dialog.ConfirmExitDialog;

/**
 * 
 * @author Abhishek Kumar
 * 
 *         Implementation to close the window
 *
 */

public class WindowCloser extends WindowAdapter {

	private final Notepad parent;

	public WindowCloser(Notepad parent) {
		this.parent = parent;
	}

	@Override
	public void windowClosing(WindowEvent we) {
		ConfirmExitDialog exit = new ConfirmExitDialog(parent, "Confirm Exit", "Do you really wish to exit");
		
		if (parent.getText().trim() == "") {
			System.exit(0);
		} else {
			if (exit.getIsOk()) {
				exit.dispose();
			}
		}
	}
}
