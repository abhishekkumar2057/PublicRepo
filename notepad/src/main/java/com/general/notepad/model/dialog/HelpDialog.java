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
 *         Help Dialog Window for help contents
 *
 */

public class HelpDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = -6808097203108509303L;
	
	private static final String HELP = "How to save document?\nAns: Click on File tab, then click on save option.";
	
	private JButton ok = new JButton("OK");
	private JLabel label = new JLabel("Help", JLabel.CENTER);
	private boolean isOk = false;
	
	public HelpDialog(Notepad parent) {
		this(parent, "Help", HELP);
	}
	
	public HelpDialog(Notepad parent, String title, String question) {
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
