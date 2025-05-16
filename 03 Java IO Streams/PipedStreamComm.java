import java.io.*;

public class PipedStreamComm {
    public static void main(String[] args) {
        try (PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos)) {

            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));

            writerThread.start();
            readerThread.start();

            writerThread.join();
            readerThread.join();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error = " + e.getMessage());
        }
    }

    static class Writer implements Runnable {
        private final OutputStream os;

        public Writer(OutputStream os) {
            this.os = os;
        }

        public void run() {
            try {
                String msg = "Hello from Writer thread";
                os.write(msg.getBytes());
                os.flush();
                os.close();
                System.out.println("Writer: Message sent");
            } catch (IOException e) {
                System.out.println("Writer error = " + e.getMessage());
            }
        }
    }

    static class Reader implements Runnable {
        private final InputStream is;

        public Reader(InputStream is) {
            this.is = is;
        }

        public void run() {
            try {
                int data;
                System.out.println("Reader: Message received - ");
                while ((data = is.read()) != -1) {
                    System.out.println((char) data);
                }
                System.out.println();
                is.close();
            } catch (IOException e) {
                System.out.println("Reader error = " + e.getMessage());
            }
        }
    }
}
