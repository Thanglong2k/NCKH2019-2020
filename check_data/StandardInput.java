package check_data;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class StandardInput {
	
	
	public static boolean isName(String name) {
		name = name.trim();
		String regex = "^\\d{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		if (matcher.find()) {
			return true;
		}
		return false;
	}
	
	public static boolean isNumber(String number)
	{
		number = number.trim();
		float num = -1;
		try {
			num = Float.parseFloat(number);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return false ;
		}
		return true;
	}

	public static boolean isNumber(String number, float lowerBound, float upperBound) {
		number = number.trim();
		float num = -1;
		try {
			num = Float.parseFloat(number);
			if (num < lowerBound || num > upperBound) {
				return false;
			}
			return true;

		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isNumber(String number, int lowerBound, int upperBound) {
		number = number.trim();
		int num = -1;
		try {
			num = Integer.parseInt(number);
			if (num < lowerBound || num > upperBound) {
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean checkText(String text)
	{
		text = text.trim();
		if (text.equals("") == true) {
			return false;
		}
		String pattern = "^[A-Za-z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\\s+]+$";
		return Pattern.matches(pattern, text);
	}
	
	public static boolean checkName(String name) {
		name = name.trim();
		if (name.equals("") == true) {
			return false;
		}
		String pattern = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\\s+]+$";
		return Pattern.matches(pattern, name);
	}

	public static boolean checkDate(String date) {

		String pat = "^\\d{4}-\\d{2}-\\d{2}";
		if (!Pattern.matches(pat, date.trim())) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		Date currDate = (Date) Calendar.getInstance().getTime();
		Date yDate = (Date) sdf.parse(date, new ParsePosition(0));
		return (yDate != null && currDate.after(yDate));
	}
	
	public static boolean checkEmail(String email){
		email=email.trim();
		String regex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
		Pattern pattern =Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if(matcher.find()) {
			return true;
		}
		return false;
		
	}
	
	public static boolean checkPhonenumber(String DT) {
		DT=DT.trim();
		String regex = "^0\\d{9}$";
		Pattern pattern =Pattern.compile(regex);
		Matcher matcher = pattern.matcher(DT);
		if(matcher.find()) {
			return true;
		}
		return false;
	}
	
	public static boolean checkCMND(String cmnd) {
		cmnd=cmnd.trim();
		String regex = "^\\d{12}$";
		Pattern pattern =Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cmnd);
		if(matcher.find()) {
			return true;
		}
		return false;
	}
	
	public static boolean checkUserName(String username) {
		String regexUsername = "^[a-zA-Z0-9._-]{3,}$";
		return Pattern.matches(regexUsername, username);
	}
	
	public static boolean checkPassWord(String password) {
		String regexPassWord = ".{6,}";
		return Pattern.matches(regexPassWord, password);
	}
	
	public static int validateRegistrationData(String userName, String passWord, String rePassWord) {
		String regexUsername = "^[a-zA-Z0-9._-]{3,}$";
		String regexPassWord = ".{6,}";
		if(!Pattern.matches(regexUsername, userName)) {
			return 1;
		}
		if(!Pattern.matches(regexPassWord, passWord)) {
			return 2;
		}
		if(!passWord.equals(rePassWord)) {
			return 3;
		}
		return 0;
	}
	
	public static boolean checkString(String string) {
		if (string.trim().equals("") == true) {
			return false;
		}
		String pattern = "^([\\.\\-\\/0-9A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\\s+])+$";
		return Pattern.matches(pattern, string);
	}
	
	public static boolean checkMa(String ma) {
		ma = ma.trim();
		if (ma.equals("") == true) {
			return false;
		}
		String pattern = "^\\d{1}$";
		return Pattern.matches(pattern, ma);
	}
	
}
