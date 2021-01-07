package data_config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadData {
	public static Map<String, String> readDataFromFile() throws IOException {
		List<String> text = Files.readAllLines(Paths.get("src/config.txt"));
		Map<String,String> config = new HashMap<String, String>();
		for(String line : text) {
			String[] arr = line.split("=", 2);
			if(arr.length > 1) {
				config.put(arr[0], arr[1]);
			} else {
				config.put(arr[0], "");
			}
		}
		
		return config;
	}
	//khong su dung
}
