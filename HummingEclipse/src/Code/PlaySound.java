package Code;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Creates a byte array for playing a .wav file from a directory.
 * Will be called in the Hummingbird's playClip() method.
 */
public class PlaySound {

    /**
     * 
     * @param fileInput the complete file path (not relative to a .wav file)
     * @return the byte array for the specified file 
     */
    public static byte[] fileToByte(String fileInput) {
        //Creates a File object containing the audio directory
        File input = new File(fileInput);
        //Initializes the byte[] object with input's file size
        byte[] bytesArray = new byte[(int) input.length()];
        //This didn't work at first until it was in a try-catch
        try {
            FileInputStream file = new FileInputStream(input);
            //FileInputStream.read() is, in fact, not ignored
            file.read(bytesArray); //Read file into bytes[]
            file.close();
        } catch (IOException e) {
            System.out.println("1");
            System.out.println(e);
        }

        return bytesArray;
    }
}
