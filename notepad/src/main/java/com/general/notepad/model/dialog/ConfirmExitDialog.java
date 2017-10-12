package com.general.notepad.model.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.general.notepad.model.Notepad;

/**
 * 
 * @author Abhishek Kumar
 * 
 *         Exit confirmation dialog box
 *
 */

public class ConfirmExitDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = -7016853159664574560L;
	
	private JButton ok = new JButton("OK");
	private JButton cancel = new JButton("Cancel");
	private JLabel label = new JLabel("Do You Wish To Exit", JLabel.CENTER);
	private boolean isOk = false;
	
	public ConfirmExitDialog(Notepad parent) {
		this(parent, "Please Confirm", "Sure?");
	}
	
	public ConfirmExitDialog(Notepad parent, String title, String question) {
		super(parent, title, true);
		label.setText(question);
		setup();
		ok.addActionListener(this);
		cancel.addActionListener(this);
		addWindowListener(new WindowCloser(this));
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
		buttons.add(cancel);
		setLayout(new BorderLayout());
		add("Center", label);
		add("South", buttons);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		isOk = e.getSource() == ok;
		if (e.getSource() == ok) {
			setVisible(false);
		} else if (e.getSource() == cancel) {
			this.dispose();
		}
	}
	
	private class WindowCloser extends WindowAdapter {
		
		private ConfirmExitDialog parent;
		
		public WindowCloser(ConfirmExitDialog parent) {
			super();
			this.parent = parent;
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			parent.isOk = false;
			if (parent.isOk)
				parent.dispose();
		}
	}
	
	public boolean getIsOk() {
		return isOk;
	}
}
