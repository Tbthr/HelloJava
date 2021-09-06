package programming.io;

import java.io.*;
import java.time.Clock;
import java.util.Random;

/**
 * @author lyq_power
 * @date 2019/12/7 15:44 11s
 */
public class TimeCompare {
    public static void main(String[] args) {
        Random random = new Random();
        try {
            FileWriter fw = new FileWriter("dbcp.txt");
            long start = System.currentTimeMillis();
            for (int i = 1; i <= 10000; i++) {
                fw.write(random.nextInt(1000));
                fw.flush();
            }
            fw.close();
            System.out.println("FileWriter:" + (System.currentTimeMillis() - start));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("dbcp.txt"));
            long start = System.currentTimeMillis();
            for (int i = 1; i <= 10000; i++) {
                bw.write(random.nextInt(1000));
                bw.flush();
            }
            bw.close();
            System.out.println("BufferedWriter:" + (System.currentTimeMillis() - start));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fr = new FileReader("dbcp.txt");
            long start = Clock.systemUTC().millis();
            char[] temp = new char[10];
            int len = fr.read(temp);
            while (len != -1) {
                len = fr.read(temp, 0, len);
            }
            fr.close();
            System.out.println("FileReader:" + (Clock.systemUTC().millis() - start));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("dbcp.txt"));
            long start = Clock.systemUTC().millis();
            char[] temp = new char[10];
            int len = br.read(temp);
            while (len != -1) {
                len = br.read(temp, 0, len);
            }
            br.close();
            System.out.println("BufferedReader:" + (Clock.systemUTC().millis() - start));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
