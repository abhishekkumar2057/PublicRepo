package com.general.notepad.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

import com.general.notepad.action.WindowCloser;

/**
 * 
 * @author Abhishek Kumar
 * 
 *         Notepad is a windows provided similar Java Swing UI Frame based application.
 *         It provides similar applications
 *
 */

public class Notepad extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 642776011892716190L;

	private final FileTab fileMenu;
	private final EditTab editMenu;
	private final FormatTab formatMenu;
	private final ViewTab viewMenu;
	private final HelpTab helpMenu;
	
	private JTextArea txt = new JTextArea();
	
	private final WindowCloser closer;
	
	public Notepad() {
		super("Notepad");
		
		fileMenu = new FileTab(this);
		editMenu = new EditTab(this);
		formatMenu = new FormatTab(this);
		viewMenu = new ViewTab(this);
		helpMenu = new HelpTab(this);
		
		closer = new WindowCloser(this);
		
		JMenuBar menu = new JMenuBar();
		menu.add(fileMenu);
		menu.add(editMenu);
		menu.add(formatMenu);
		menu.add(viewMenu);
		menu.add(helpMenu);
		setJMenuBar(menu);
		
		txt.setEditable(true);
		setLocation(300, 200);
		setSize(1200, 615);
		setVisible(true);
		add(txt);
		addWindowListener(closer);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fileMenu) {
			fileMenu.actionPerformed(e);
		} else if (e.getSource() == editMenu) {
			editMenu.actionPerformed(e);
		} else if (e.getSource() == formatMenu) {
			formatMenu.actionPerformed(e);
		} else if (e.getSource() == viewMenu) {
			viewMenu.actionPerformed(e);
		} else if (e.getSource() == helpMenu) {
			helpMenu.actionPerformed(e);
		}
	}
	
	public String getText() {
		return txt.getText();
	}
	
	public void setText(String text) {
		txt.setText(text);
	}
}
