package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class ResponseHeaderUtil {

  public static void main(String[] args) {

    try {
    PrintWriter writer1 = null;
    writer1 = new PrintWriter(new File("testout.txt"));// file lưu kq header và body
	URL obj = new URL("https://github.com/LukWebsForge/JustMail");
	URLConnection conn = obj.openConnection(); // mở kết nối đến URL
	Map<String, List<String>> map = conn.getHeaderFields(); // Lấy ra kết quả header
	
	
    
	System.out.println("Printing Response Header...\n");

	for (Map.Entry<String, List<String>> entry : map.entrySet()) {
		writer1.println(entry.getKey() + " : " + entry.getValue()); // Viết vào file kq phần header
		System.out.println(entry.getKey() + " : " + entry.getValue());
	}
	
	System.out.println("\nGet Response Header By Key ...\n");
	String server = conn.getHeaderField("Server");

	if (server == null) {
		System.out.println("Key 'Server' is not found!");
	} else {
		System.out.println("Server - " + server);
	}

	System.out.println("\n Done");
	BufferedReader in = new BufferedReader(new InputStreamReader(
            conn.getInputStream())); // lấy phần body
	String inputLine;
	while ((inputLine = in.readLine()) != null) {
		writer1.println(inputLine);// ghi ra file body
		System.out.println(inputLine);
        }
	in.close();
	writer1.close();

    } catch (Exception e) {
	e.printStackTrace();
    }
    
  }
}
