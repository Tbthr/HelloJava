package programming.IO;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        System.out.println(in.nextInt());
        System.out.println(in.next());
        System.out.println(in.nextLine());
    }
}
