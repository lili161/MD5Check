package com.lr.CodeIt;

import java.awt.EventQueue;
import java.security.MessageDigest;
/**
 * @author Ric lee
 * 
 * @time 2020/4/14 14:23
 * 
 * @ver 1.0.1
 */

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frmCodeit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
