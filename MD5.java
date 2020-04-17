package com.lr.CodeIt;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.security.*;

/**
 * @author Ric lee
 * 
 * @time 2020/4/14 14:23
 * 
 * @ver 1.0.1
 */

public class MD5 {

	public static void fileCheck(String filePath, String Md5) throws NoSuchAlgorithmException, FileNotFoundException{
		MessageDigest m = MessageDigest.getInstance("MD5");
		File f = new File(filePath);
		if (!f.exists()) {
			new tip("文件不存在");
		} else {
			InputStream in = new FileInputStream(f);
			try {
				
				m.update(in.readAllBytes());
				byte s[] = m.digest();
				String result = "";
				for (int i = 0; i < s.length; i++) {
					result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
				}
				if (result.equals(Md5)) {
					new tip("<html><body>文件MD5：" + result + "<br/>" + "输入的：" + Md5 + "<br/>检测通过，文件为原文件</body></html>");
				} else {
					new tip("<html><body>文件MD5：" + result + "<br/>" + "输入的：" + Md5
							+ "<br/><b>检测未通过，文件极可能被修改</b></body></html>");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static String getMd5(String sourceStr) throws NoSuchAlgorithmException, IOException {
		if (sourceStr.charAt(1) == ':' && sourceStr.charAt(2) == '\\') {
			System.out.println("是文件");
			String result = "";
			MessageDigest m = MessageDigest.getInstance("MD5");
			File f = new File(sourceStr);
			
			if (!f.exists()) {
				new tip("文件不存在");
			} else {
				if(f.length()<=300000000) {
				InputStream in = new FileInputStream(f);
				BufferedInputStream bin=new BufferedInputStream(in);
//					String str = new String(in.readAllBytes());
					m.update(bin.readAllBytes());
					byte s[] = m.digest();
					for (int i = 0; i < s.length; i++) {
						result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
					}
				}
				else {
					new tip("文件太大了");
					result="内存超限,目前仅适配了300M以内的文件。";
				}
			}
			return result;
		}else {
			System.out.println("是文本");
			String result = "";
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(sourceStr.getBytes("UTF-8"));
			byte s[] = m.digest();
			for (int i = 0; i < s.length; i++) {
				result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
			}
			
			return result;
		}
	}
}
