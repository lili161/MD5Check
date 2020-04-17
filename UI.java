package com.lr.CodeIt;
/**
 * @author Ric lee
 * 
 * @time 2020/4/14 14:23
 * 
 * @ver 1.0.1
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import java.awt.Label;import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.AttributedCharacterIterator;

import javax.swing.JSeparator;
import java.awt.Canvas;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextPane;
import java.awt.Toolkit;

public class UI {
	MD5 md5 =new MD5();
	JFrame frmCodeit;
	private JTextField fileName;
	private JTextField md5Value;
	Label md5index = new Label("\u8BF7\u8F93\u5165MD5\u503C:");
	JLabel labelMain = new JLabel("MD5\u6587\u4EF6\u6821\u9A8C");
	JPanel panel = new JPanel();
	JMenuBar menuBar = new JMenuBar();
	private final JLabel jiaoyan = new JLabel("\u6821\u9A8C");
	private JTextField FileName2;
	JTextPane result = new JTextPane();

	/**
	 * Launch the application.
	 */
//	public static void ui() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UI window = new UI();
//					window.frmCodeit.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCodeit = new JFrame();
		frmCodeit.setIconImage(Toolkit.getDefaultToolkit().getImage(UI.class.getResource("/com/lr/CodeIt/icon.png")));
		frmCodeit.setResizable(false);
		frmCodeit.setTitle("CodeIt              --ver1.0.1");
		frmCodeit.setBounds(100, 100, 964, 594);
		frmCodeit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCodeit.getContentPane().setLayout(null);
		frmCodeit.setVisible(true);

	
		
		
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 950, 39);
		frmCodeit.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		menuBar.setBounds(0, 0, 950, 29);
		panel.add(menuBar);
		
		JButton btnNewButton = new JButton("MD5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(btnNewButton);
		
	
		labelMain.setFont(new Font("新宋体", Font.BOLD, 25));
		labelMain.setBounds(20, 51, 184, 39);
		frmCodeit.getContentPane().add(labelMain);
		
		fileName = new JTextField();
		fileName.setBounds(53, 100, 554, 21);
		frmCodeit.getContentPane().add(fileName);
		fileName.setColumns(10);
		
		JButton button_1 = new JButton("\u9009\u62E9\u6587\u4EF6");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String a="";
				a = new FileChooser().FileChooser();
				fileName.setText(a);
				System.out.println(a);
				
			}
		});
		button_1.setBounds(617, 99, 93, 23);
		frmCodeit.getContentPane().add(button_1);
		
		md5Value = new JTextField();
		md5Value.setBounds(194, 154, 516, 21);
		frmCodeit.getContentPane().add(md5Value);
		md5Value.setColumns(10);
		
		md5index.setBounds(53, 154, 129, 23);
		frmCodeit.getContentPane().add(md5index);
		jiaoyan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.err.println("校验");
				String fileSource=fileName.getText();
				String uMd5=md5Value.getText();
				if(fileSource.equals("")||uMd5.equals("")||uMd5.length()!=32) {
					new tip("请填入正确的文件或MD5值");
				}else {
					try {
						md5.fileCheck(fileSource, uMd5);
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		jiaoyan.setIcon(new ImageIcon(UI.class.getResource("/com/lr/CodeIt/jiaoyan.png")));
		jiaoyan.setBackground(Color.GRAY);
		jiaoyan.setFont(new Font("宋体", Font.BOLD, 21));
		jiaoyan.setHorizontalAlignment(SwingConstants.CENTER);
		jiaoyan.setBounds(729, 100, 211, 65);
		
		frmCodeit.getContentPane().add(jiaoyan);
		
		JLabel labelMain2 = new JLabel("\u67E5 \u8BE2 MD5 \u503C");
		labelMain2.setFont(new Font("新宋体", Font.BOLD, 25));
		labelMain2.setBounds(20, 266, 184, 39);
		frmCodeit.getContentPane().add(labelMain2);
		
		JDesktopPane line = new JDesktopPane();
		line.setForeground(Color.BLACK);
		line.setBorder(new CompoundBorder());
		line.setBackground(Color.BLACK);
		line.setBounds(0, 246, 950, 1);
		frmCodeit.getContentPane().add(line);
		
		FileName2 = new JTextField();
		FileName2.setColumns(10);
		FileName2.setBounds(53, 315, 554, 21);
		frmCodeit.getContentPane().add(FileName2);
		
		JButton chooseFile2 = new JButton("\u9009\u62E9\u6587\u4EF6");
		chooseFile2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String a = "";
				a = new FileChooser().FileChooser();
				FileName2.setText(a);
			}
		});
		chooseFile2.setBounds(729, 313, 93, 23);
		frmCodeit.getContentPane().add(chooseFile2);
		
		JButton findMd = new JButton("\u67E5\u8BE2");
		findMd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String source=FileName2.getText();
				if(source.equals("")) {
					new tip("请填入正确的文件或文本值");
				}else {
					String finalCode = "";
					try {
						finalCode = md5.getMd5(source);
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					result.setText(finalCode);
				}
			}
		});
		findMd.setBounds(847, 313, 93, 23);
		frmCodeit.getContentPane().add(findMd);
		
		
		result.setBounds(133, 367, 651, 21);
		frmCodeit.getContentPane().add(result);
		
		JLabel lblMd = new JLabel(" MD5 \u503C\uFF1A");
		lblMd.setFont(new Font("宋体", Font.BOLD, 21));
		lblMd.setHorizontalAlignment(SwingConstants.CENTER);
		lblMd.setBounds(0, 367, 135, 21);
		frmCodeit.getContentPane().add(lblMd);
		
		JLabel label = new JLabel("\u5199\u5165\u6587\u672C\u6216");
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		label.setBounds(635, 314, 93, 21);
		frmCodeit.getContentPane().add(label);
		
		JLabel lblWriteByRic = new JLabel("Write by Ric Lee");
		lblWriteByRic.setFont(new Font("宋体", Font.ITALIC, 20));
		lblWriteByRic.setHorizontalAlignment(SwingConstants.CENTER);
		lblWriteByRic.setBounds(675, 480, 347, 52);
		frmCodeit.getContentPane().add(lblWriteByRic);
		
		JLabel lblVersion = new JLabel("version 1.0.1");
		lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersion.setFont(new Font("宋体", Font.ITALIC, 20));
		lblVersion.setBounds(675, 505, 347, 52);
		frmCodeit.getContentPane().add(lblVersion);
		
		JLabel label_1 = new JLabel("<html><body><a href=\"www.baidu.com\">123 </body></html>");
		label_1.setBounds(719, 447, 54, 15);
		frmCodeit.getContentPane().add(label_1);
		
	
		
	}
}
