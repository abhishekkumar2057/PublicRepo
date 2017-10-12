package com.general.notepad.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * 
 * @author Abhishek Kumar
 * 
 *         Edit tab provides functionalities for edit like cut copy paste etc.
 *
 */

public class EditTab extends JMenu implements ActionListener {
	
	private static final long serialVersionUID = -3704562284933307108L;
	
	private JMenuItem undo = new JMenuItem("Undo");
	private JMenuItem cut = new JMenuItem("Cut");
	private JMenuItem copy = new JMenuItem("Copy");
	private JMenuItem paste = new JMenuItem("Paste");
	private JMenuItem delete = new JMenuItem("Delete");
	private JMenuItem find = new JMenuItem("Find");
	private JMenuItem findNext = new JMenuItem("Find Next...");
	private JMenuItem replace = new JMenuItem("Replace");
	private JMenuItem goTo = new JMenuItem("Go To...");
	private JMenuItem selectAll = new JMenuItem("Select All");
	private JMenuItem dateTime = new JMenuItem("Time/Date");
	
	private Stack<String> clipBoard = new Stack<>();
	private final Notepad parent;
	
	public EditTab(Notepad parent) {
		super("Edit");
		this.parent = parent;
		
		add(undo);
		undo.setEnabled(true);
		addSeparator();
		add(cut);
		cut.setEnabled(false);
		add(copy);
		copy.setEnabled(false);
		add(paste);
		paste.setEnabled(false);
		add(delete);
		delete.setEnabled(true);
		addSeparator();
		add(find);
		find.setEnabled(true);
		add(findNext);
		findNext.setEnabled(true);
		add(replace);
		replace.setEnabled(true);
		add(goTo);
		goTo.setEnabled(true);
		addSeparator();
		add(selectAll);
		selectAll.setEnabled(true);
		add(dateTime);
		dateTime.setEnabled(true);
		
		undo.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		delete.addActionListener(this);
		find.addActionListener(this);
		findNext.addActionListener(this);
		replace.addActionListener(this);
		goTo.addActionListener(this);
		selectAll.addActionListener(this);
		dateTime.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == undo) {
			
		} else if (e.getSource() == cut) {
			
		} else if (e.getSource() == copy) {
			
		} else if (e.getSource() == paste) {
			
		} else if (e.getSource() == delete) {
			
		} else if (e.getSource() == find) {
			
		} else if (e.getSource() == findNext) {
			
		} else if (e.getSource() == replace) {
			
		} else if (e.getSource() == goTo) {
			
		} else if (e.getSource() == selectAll) {
			
		} else if (e.getSource() == dateTime) {
			
		}
	}
}
