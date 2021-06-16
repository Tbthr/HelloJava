package programming.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author lyq_power
 * @date 2019/12/7 16:08 24s
 */
public class LetterFrequencyCount {
    private long[] cnt = new long[26];
    private long sum = 0;

    public void loadFile(String filename) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            char[] temp = new char[1024];
            int len = bufferedReader.read(temp);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(temp, 0, len);
            while (len != -1) {
                len = bufferedReader.read(temp);
                stringBuilder.append(temp);
            }
            bufferedReader.close();
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) >= 'a' && stringBuilder.charAt(i) <= 'z') {
                    sum++;
                    cnt[stringBuilder.charAt(i) - 'a']++;
                }
                if (stringBuilder.charAt(i) >= 'A' && stringBuilder.charAt(i) <= 'Z') {
                    sum++;
                    cnt[stringBuilder.charAt(i) - 'A']++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getFrequency(char a) {
        if (a >= 'a' && a <= 'z') {
            return cnt[a - 'a'] * 1.0 / sum * 100;
        } else if (a >= 'A' && a <= 'Z') {
            return cnt[a - 'A'] * 1.0 / sum * 100;
        } else return 0;
    }

    public void printFrequencies() {
        if (sum == 0) {
            System.out.println("文件中无字母！");
            return;
        }
        for (int i = 0; i < 26; i++) {
            System.out.printf("%c-Frequency: %.2f %%\n", (char) ('A' + i), cnt[i] * 1.0 / sum * 100);
        }
    }

    public static void main(String[] args) {
        LetterFrequencyCount letterFrequencyCount = new LetterFrequencyCount();
        letterFrequencyCount.loadFile("C:\\Users\\刘以强\\Desktop\\Java语言程序设计\\test.txt");
        System.out.println("A-Frequency:" + letterFrequencyCount.getFrequency('a') + "%" + "\n");
        letterFrequencyCount.printFrequencies();
    }
}
