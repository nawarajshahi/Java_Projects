package Control;

import Model.Calendar;

public class CalendarManager {
	public CalendarManager() {
		
	}
	
	public void save(String strContent, int year, int month, int date) {
		String fileName = year + "-" + month + ".dat";
		Calendar cal = new Calendar();
		if (cal.load(fileName) == false)
			cal.Clear();
		
		cal.SetContent(date, strContent);
		cal.save(fileName);
	}
	
	public String load(int year, int month, int date) {
		String strContent = "";
		String fileName = year + "-" + month + ".dat";
		Calendar cal = new Calendar();
		if (cal.load(fileName) == false)
			return "Error";
		
		strContent = cal.GetContent(date);
		
		return strContent;
	}
}
