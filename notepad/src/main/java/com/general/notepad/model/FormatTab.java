package com.general.notepad.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * 
 * @author Abhishek Kumar
 * 
 *         Format tab formatting functionalities.
 *         Currently word wrap functionality disabled.
 *         Font selection is enabled
 *
 */

public class FormatTab extends JMenu implements ActionListener {
	
	private static final long serialVersionUID = -8266937270495824100L;
	
	private JMenuItem wrap = new JMenuItem("Word Wrap");
	private JMenuItem font = new JMenuItem("Font...");
	
	public FormatTab(Notepad parent) {
		super("Format");
		
		add(wrap);
		wrap.setEnabled(false);
		add(font);
		font.setEnabled(true);
		
		wrap.addActionListener(this);
		font.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == wrap) {
			
		} else if (e.getSource() == font) {
			
		}
	}
}
