package com.general.notepad.model;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.general.notepad.action.FileTabActions;
import com.general.notepad.model.dialog.ErrorDialog;

/**
 * 
 * @author Abhishek Kumar
 * 
 *         File tab provides file related functionalities like save, open etc.
 *
 */

public class FileTab extends JMenu implements ActionListener {
	
	private static final long serialVersionUID = 7097761872123107509L;
	
	private JMenuItem newF = new JMenuItem("New");
	private JMenuItem open = new JMenuItem("Open");
	private JMenuItem save = new JMenuItem("Save");
	private JMenuItem saveAs = new JMenuItem("Save As...");
	private JMenuItem pageSetup = new JMenuItem("Page Setup");
	private JMenuItem print = new JMenuItem("Print");
	private JMenuItem exit = new JMenuItem("Exit");
	
	private final Notepad parent;
	private StringBuffer txt;
	private FileTabActions actions;
	
	public FileTab(Notepad parent) {
		super("File");
		this.parent = parent;
		
		add(newF);
		newF.setEnabled(true);
		add(open);
		open.setEnabled(true);
		add(save);
		save.setEnabled(true);
		add(saveAs);
		saveAs.setEnabled(true);
		addSeparator();
		add(pageSetup);
		pageSetup.setEnabled(false);
		add(print);
		print.setEnabled(false);
		addSeparator();
		add(exit);
		exit.setEnabled(true);
		
		newF.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		saveAs.addActionListener(this);
		pageSetup.addActionListener(this);
		print.addActionListener(this);
		exit.addActionListener(this);
		
		actions = new FileTabActions(parent);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newF) {
			actions.newTab();
		} else if (e.getSource() == open) {
			FileDialog fd = new FileDialog(parent, "Open File", FileDialog.LOAD);
			fd.setVisible(true);
			StringBuffer fileContent = new StringBuffer("");
			fileContent.append(fd.getDirectory() + fd.getFile());
			if (!fileContent.toString().contains("null")) {
				
				txt = new StringBuffer(actions.open(fileContent.toString()));
				parent.setText(txt.toString());
			} else {
				new ErrorDialog(parent, "Error in Opening selected File");
			}
		} else if (e.getSource() == save) {
			FileDialog fd = new FileDialog(parent, "Save File", FileDialog.SAVE);
			fd.setVisible(true);
			
			String file = new String(fd.getDirectory() + fd.getFile());
			
			if (!file.toString().contains("null")) {
				
				txt = new StringBuffer(parent.getText());
				actions.save(fd.getDirectory(), fd.getFile(), txt.toString());
			}
		} else if (e.getSource() == saveAs) {
			FileDialog fd = new FileDialog(parent, "Save File", FileDialog.SAVE);
			fd.setVisible(true);
			
			String file = new String(fd.getDirectory() + fd.getFile());
			if (!file.toString().contains("null")) {
				txt = new StringBuffer(parent.getText());
				actions.saveAs(fd.getDirectory(), fd.getFile(), txt.toString());
			}
		} else if (e.getSource() == pageSetup) {
			
		} else if (e.getSource() == print) {

		} else if (e.getSource() == exit) {
			if (parent.getText().trim() == "") {
				System.exit(0);
			} else
				actions.exit();
		}
	}
}
