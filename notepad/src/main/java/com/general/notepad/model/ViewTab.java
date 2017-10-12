package com.general.notepad.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * 
 * @author Abhishek Kumar
 * 
 *         View tab disabled now
 *
 */

public class ViewTab extends JMenu implements ActionListener {
	
	private static final long serialVersionUID = 7894759658202865021L;
	
	private JMenuItem status = new JMenuItem("Status Bar");
	
	public ViewTab(Notepad parent) {
		super("View");
		
		add(status);
		status.setEnabled(false);
		
		status.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == status) {
			
		}
	}
}
