package com.general.notepad.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.general.notepad.action.HelpTabActions;

/**
 * 
 * @author Abhishek Kumar
 * 
 *         Help tab contains general queries and their solutions regarding the
 *         application
 * 
 *         About tab contains the summary of the application and compliance
 *
 */

public class HelpTab extends JMenu implements ActionListener {
	
	private static final long serialVersionUID = 1410862320122486913L;
	
	private JMenuItem view = new JMenuItem("View Help");
	private JMenuItem about = new JMenuItem("About Notepad");
	
	private HelpTabActions actions;
	
	public HelpTab(Notepad parent) {
		super("Help");
		
		add(view);
		view.setEnabled(true);
		add(about);
		about.setEnabled(true);
		
		view.addActionListener(this);
		about.addActionListener(this);
		actions = new HelpTabActions(parent);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view) {
			actions.help();
		} else if (e.getSource() == about) {
			actions.about();
		}
	}
}
