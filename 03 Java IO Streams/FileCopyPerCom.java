import java.io.*;

public class FileCopyPerCom {
    private static final int BUFFER_SIZE = 4096;

    public static void copyUsingUnbuffered(String sourcePath, String destPath) {
        try (FileInputStream fis = new FileInputStream(sourcePath);
        FileOutputStream fos = new FileOutputStream(destPath)) {
            long start = System.nanoTime();

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();
            System.out.println("Unbuffered copy time = " + (end - start) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("Unbuffered copy failed = " + e.getMessage());
        }
    }

    public static void copyUsingBuffered(String sourcePath, String destPath) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath))) {
            long start = System.nanoTime();

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();
            System.out.println("Buffered copy time = " + (end - start) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("Buffered copy failed = " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sourceFile = "largeFile.txt";
        String unbufferedCopy = "unbufferedCopy.txt";
        String bufferedCopy = "bufferedCopy.txt";

        System.out.println("Starting copy using unbuffered streams...");
        copyUsingUnbuffered(sourceFile, unbufferedCopy);

        System.out.println("Starting copy using buffered streams...");
        copyUsingUnbuffered(sourceFile, bufferedCopy);
    }
}
