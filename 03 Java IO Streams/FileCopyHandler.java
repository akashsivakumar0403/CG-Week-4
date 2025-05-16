import java.io.*;

public class FileCopyHandler {
    public static void copyFile(String sourcePath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File sourceFile = new File(sourcePath);

            if (!sourceFile.exists()) {
                System.out.println("Source file does not exist = " + sourcePath);
                return;
            }

            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destPath);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully from " + sourcePath + " to " + destPath);
        } catch (IOException e) {
            System.out.println("An I/O error occurred = " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fis.close();
            } catch (IOException e) {
                System.out.println("Error closing streams = " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "copy.txt";

        copyFile(sourceFile, destFile);
    }
}
