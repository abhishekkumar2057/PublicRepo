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
 *         Error message popup window
 *
 */

public class ErrorDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1948533297496089446L;
	
	private JButton ok = new JButton("OK");
	private JLabel label = new JLabel("ERROR!!!", JLabel.CENTER);
	private boolean isOk = false;
	
	public ErrorDialog(Notepad parent, String errorMsg) {
		super(parent, errorMsg);
		label.setText(errorMsg);
		setup();
		ok.addActionListener(this);
		addWindowListener(new WindowCloser());
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
			setVisible(false);
		}
	}
	
	private class WindowCloser extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			ErrorDialog.this.isOk = false;
			ErrorDialog.this.dispose();
		}
	}
	
	public boolean getIsOk() {
		return isOk;
	}
}
