import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class test {

    private static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        testFileDirOrName("D:\\Studying\\计协RPZ\\计算机技能大赛\\作品提交\\rpz");
        System.out.println("res = " + res);
        System.out.println("res.size() = " + res.size());
    }

    private static void testFileDirOrName(String path) {
        File dirFile = new File(path);
        if (dirFile.exists()) {
            File[] files = dirFile.listFiles();
            if (files != null) {
                for (File fileChildDir : files) {
                    //输出文件名或者文件夹名
                    String name = fileChildDir.getName();
                    if (name.length() > 13) {
                        int i = name.indexOf("_");
                        res.add('\'' + name.substring(i + 1, i + 11) + '\'');
                    }
                    System.out.println(fileChildDir.getName());
                    if (fileChildDir.isDirectory()) {
                        System.out.println("=============================");
                        //通过递归的方式,可以把目录中的所有文件全部遍历出来
                        testFileDirOrName(fileChildDir.getAbsolutePath());
                    }
                    if (fileChildDir.isFile()) {
//                        System.out.println(" :  此为文件名");
                    }
                }
            }
        } else {
            System.out.println("你想查找的文件不存在");
        }
    }
}
