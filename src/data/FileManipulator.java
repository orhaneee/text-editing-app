package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class FileManipulator {
	
    /**
     * Writing directly to a file with current date.
     * @param content JSON string passed from Project Manager.
     */
    public void writeToFile(String content) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File("SavedText.txt"));
            os.write(content.getBytes(), 0, content.length());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                assert os != null;
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Reads file which is in given path
     * @param path file path
     * @return file content
     * @throws FileNotFoundException
     */
    public String readFile(String path) {
    	Scanner in;
		try {
			in = new Scanner(new FileReader(path));
	    	StringBuilder sb = new StringBuilder();
	        while (in.hasNext()) {
	            sb.append(in.next());
	        }
	        in.close();
	        return sb.toString();
		} catch (FileNotFoundException e) {
			System.out.println("Given file name : " + path + " not found!\n");
			return null;
		}
    }
}
