package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

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
     * @throws IOException
     */
    public String readFile(String path) {
        String content = null;
        File file = new File(path);
        FileReader reader = null;
        
        if (file.exists()) {
            try {
                reader = new FileReader(file);
                char[] chars = new char[(int) file.length()];
                reader.read(chars);
                content = new String(chars);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(reader != null){
                    try {
    					reader.close();
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
                }
            }
        }
        else {
        	System.out.println("Given path : " + path + " not found!\n");
        }
        
        return content;
    }
}
