package programming.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lyq_power
 * @date 2019/12/2 21:44 51s
 */
public class dirCopy {

    public void copyDir(File file, String newPath) {
        String oldFilePath = file.getAbsolutePath();
        String[] s = oldFilePath.split("\\\\");
        String newFilePath = newPath + "\\" + s[s.length - 1];
        File newFile = new File(newFilePath);
        File[] files = file.listFiles();
        if (files != null) {
            if (newFile.mkdir()) System.out.println("文件夹复制成功！");
            for (File f : files) {
                this.copyDir(f, newPath + "\\" + s[s.length - 1]);
            }
        } else {
            FileInputStream fileInputStream = null;
            FileOutputStream fileOutputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                fileOutputStream = new FileOutputStream(newFile);
                byte[] bytes = new byte[1024];
                int cnt = fileInputStream.read(bytes);
                while (cnt != -1) {
                    fileOutputStream.write(bytes, 0, cnt);
                    fileOutputStream.flush();
                    cnt = fileInputStream.read(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        var copy = new dirCopy();
        copy.copyDir(new File("C:\\Users\\刘以强\\Desktop\\Java语言程序设计\\Java实验报告\\a"), "D:\\test");
    }

}
