package com.lr.CodeIt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * @author Ric lee
 * 
 * @time 2020/4/14 14:23
 * 
 * @ver 1.0.1
 */
@SuppressWarnings("serial")
public class FileChooser extends JFrame {

    public static String FileChooser(){  
    	int i=1;
    	 JFileChooser jfc=new JFileChooser();  
         jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
         jfc.showDialog(new JLabel(), "ѡ��");  
         File file=jfc.getSelectedFile();  
//         while(i>0) {
         if(file.isDirectory()){  
        	 tip t=new tip("��ѡ��Ϊ�ļ���,��ѡ���ļ�");
             System.out.println("�ļ���:"+file.getAbsolutePath());  
              return new FileChooser().FileChooser();
         }else if(file.isFile()){  
             System.out.println("�ļ�:"+file.getAbsolutePath());  
             return file.getAbsolutePath();  
         }  else {
        	    System.out.println(jfc.getSelectedFile().getName());
        	 return "wrong";
         }
//         }
		
          
    }

  
}