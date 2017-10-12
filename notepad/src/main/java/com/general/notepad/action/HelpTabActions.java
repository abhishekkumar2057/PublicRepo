package com.general.notepad.action;

import com.general.notepad.model.Notepad;
import com.general.notepad.model.dialog.AboutDialog;
import com.general.notepad.model.dialog.HelpDialog;

/**
 * 
 * @author Abhishek Kumar
 *
 */

public class HelpTabActions {

	private final Notepad parent;

	public HelpTabActions(Notepad parent) {
		super();
		this.parent = parent;
	}

	// Help
	public void help() {
		new HelpDialog(parent);
	}

	// About
	public void about() {
		new AboutDialog(parent);
	}
}
