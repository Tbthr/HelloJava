package programming.classLoad.hot_deploy;

import java.io.*;

public class BinaryFileUtils {

    public static void copy(InputStream input, OutputStream output) throws IOException {
        byte[] buf = new byte[4096];
        int bytesRead = 0;
        while ((bytesRead = input.read(buf)) != -1) {
            output.write(buf, 0, bytesRead);
        }
    }

    public static byte[] readFileToByteArray(String fileName) throws IOException {
        try (InputStream input = new FileInputStream(fileName)) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            copy(input, output);
            return output.toByteArray();
        }
    }

    public static void writeByteArrayToFile(String fileName, byte[] data) throws IOException {
        try (OutputStream output = new FileOutputStream(fileName)) {
            output.write(data);
        }
    }
}