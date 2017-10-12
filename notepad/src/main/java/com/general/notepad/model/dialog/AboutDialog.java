package com.general.notepad.model.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.general.notepad.model.Notepad;

/**
 * 
 * @author Abhishek Kumar
 * 
 *         About window
 *
 */

public class AboutDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 3166220675727215460L;
	
	private static final String ABOUT = "This is Java application. Java 8 and above required to run it successfully";
	
	private JButton ok = new JButton("OK");
	private JLabel label = new JLabel("About", JLabel.CENTER);
	private boolean isOk = false;
	
	public AboutDialog(Notepad parent) {
		this(parent, "About", ABOUT);
	}
	
	public AboutDialog(Notepad parent, String title, String question) {
		super(parent, title, true);
		label.setText(question);
		setup();
		ok.addActionListener(this);
		setResizable(false);
		pack();
		int x = parent.getLocation().x + (parent.getSize().width - getSize().width) / 2;
		int y = parent.getLocation().y + (parent.getSize().height - getSize().height) / 2;
		x = Math.min(getToolkit().getScreenSize().width - getSize().width, x);
		y = Math.min(getToolkit().getScreenSize().height - getSize().height, y);
		setLocation(Math.max(0, x), Math.max(0, y));
		setVisible(true);
	}
	
	private void setup() {
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(ok);
		setLayout(new BorderLayout());
		add("Center", label);
		add("South", buttons);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		isOk = e.getSource() == ok;
		if (e.getSource() == ok) {
			this.dispose();
		}
	}
	
	public boolean getIsOk() {
		return isOk;
	}
}
