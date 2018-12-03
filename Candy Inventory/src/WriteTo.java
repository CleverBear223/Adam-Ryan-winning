

import java.io.*;
import static java.lang.System.*;


public class WriteTo {

	public static void main(String[] args) {
		File log = new File("log.txt");
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(log, true));
			
			pw.println("Quantity");
			
			pw.close();
		}catch(IOException e) {
			out.println("error");
			}
		
	}

}
