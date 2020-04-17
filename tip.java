package com.lr.CodeIt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
/**
 * @author Ric lee
 * 
 * @time 2020/4/14 14:23
 * 
 * @ver 1.0.1
 */

public class tip  {

	private JFrame frame;
	private static JLabel tiptext = new JLabel("");
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//				new tip("123");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public tip(String s) {
		try {
			initialize(s);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws InterruptedException 
	 */
	private void initialize(String s) throws InterruptedException {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(tip.class.getResource("/com/lr/CodeIt/icon.png")));
		frame.setTitle("\u63D0\u793A");
		frame.setBounds(100, 100, 437, 206);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTiptext(s);
		tiptext.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(tiptext, BorderLayout.CENTER);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}
	public static void setTiptext(String s) {
		tiptext.setText(s);
		
	}

}
