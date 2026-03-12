package balabalaba;
import java.io.*;
public class passbyvariable {
	public static void main(String[] args) {
		try {
			BufferedReader inFile = new BufferedReader (new FileReader("input.txt"));
			String line;
			while ((line = inFile.readLine()) != null) {
				System.out.println(line);
				
			}
			inFile.close();
		}
		
		catch(FileNotFoundException e) {
		
			System.out.println("File not Found");
			
		}
		//optional because IOException Include not Found
		catch (IOException e) {
			System.out.println("Reading Error");
		}
	}

}
