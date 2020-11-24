package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Calendar {
	private String[] contents;
	
	public Calendar() {
		contents = new String[31];
		for (int i = 0; i < 31; i++)
			contents[i] = "";
	}
	
	public boolean load(String fileName) {
		File f = new File(fileName); 
		try {
			InputStream fis = new FileInputStream(f);
			for (;;) {
				byte b = (byte)fis.read();
				if (b == (byte)'<') {
					break;
				}
			}
			for (int i = 0; i < 31; i++) {
				for (;;) {
					byte eb = (byte)fis.read();
					if (eb == (byte)'>')
						break;
				}
				
				byte[] readBytes = new byte[10000];
				int count = 0;
				for (;;) {
					int ret = fis.read();
					byte b = (byte)ret;
					if (b == (byte)'<' || ret == -1) {
						break;
					}
					readBytes[count] = b;
					count++;
				}
				
				if (count == 0) {
					contents[i] = "";					
				} else {
					byte[] readBytesFinal = new byte[count];
					for (int j = 0; j < count; j++)
						readBytesFinal[j] = readBytes[j];
					
					contents[i] = new String(readBytesFinal);
				}				
			}
			fis.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean save(String fileName) {
		File f = new File(fileName); 
		try {
			OutputStream fos = new FileOutputStream(f, false);
			for (int i = 0; i < 31; i++) {
				String dateHeader = "<Date" + i + ">";
				byte[] bytes = dateHeader.getBytes();
				for (int j = 0; j < bytes.length; j++)
					fos.write(bytes[j]);
				
				bytes = contents[i].getBytes();
				for (int j = 0; j < bytes.length; j++)
					fos.write(bytes[j]);
			}
			
			fos.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void Clear() {
		for (int i = 0; i < 31; i++) {
			contents[i] = "";
		}
	}
	
	public String GetContent(int date) {
		return contents[date - 1];
	}
	
	public void SetContent(int date, String strContent) {
		contents[date - 1] = strContent;
	}
}
