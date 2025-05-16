import java.io.*;
import java.util.Arrays;

public class ImageByteArrayCon {
    public static void main(String[] args) {
        String sourceImagePath = "source.jpeg";
        String targetImagePath = "copy.jpeg";

        try {
            byte[] imageBytes = readImageToByteArr(sourceImagePath);

            writeByteArrToImage(imageBytes, targetImagePath);

            boolean isIdentical = compareFiles(sourceImagePath, targetImagePath);
            System.out.println("\nAre images identical? " + isIdentical);
        } catch (IOException e) {
            System.out.println("I/O Error = " + e.getMessage());
        }
    }

    public static byte[] readImageToByteArr(String filePath) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
        }
        System.out.println("Image successfully read into byte array");
        return baos.toByteArray();
    }

    public static void writeByteArrToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        FileOutputStream fos = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }

        System.out.println("Image successfully written from byte array to " + outputPath);
    }

    public static boolean compareFiles(String path1, String path2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(path1);
        FileInputStream fis2 = new FileInputStream(path2)) {
            byte[] file1Bytes = fis1.readAllBytes();
            byte[] file2Bytes = fis2.readAllBytes();

            return Arrays.equals(file1Bytes, file2Bytes);
        }
    }
}