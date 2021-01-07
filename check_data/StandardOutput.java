package check_data;

public class StandardOutput {
	public static String formatString(String string) {
		String[] arrayWord = string.trim().split("\\s+");
		for(int i = 0; i < arrayWord.length; i++) {
			arrayWord[i] = arrayWord[i].substring(0, 1).toUpperCase() 
					+ arrayWord[i].substring(1).toLowerCase();
		}
		return String.join(" ", arrayWord);
	}
}
