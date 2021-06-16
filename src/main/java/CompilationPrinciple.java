import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompilationPrinciple {
    List<String> keyValue = Arrays.asList("String", "float", "double", "char", "int");
    List<String> booleanValue = Arrays.asList("false", "true", "False", "Ture");
    int sum = 0;

    public static void main(String[] args) {
        String a = "asdtj'v''''i_oc\"reo";
        CompilationPrinciple cp = new CompilationPrinciple();
        cp.resolve("const count=10, 9_sum=81.5,  char='f', string1='hj', max=+16.9, v=6, ll=false;");
    }

    public void resolve(String s) {
        if (!s.startsWith("const") || !s.endsWith(";"))
            System.out.println("不是一个常量声明语句!");
        else {
            String replace = s.replace(",", " ")
                    .replace(" +", " ")
                    .replace(";", "");
            System.out.println("replace = " + replace);
            List<String> strings = Arrays.stream(replace.split(" "))
                    .filter(a -> !a.equals("") && !a.equals("const"))
                    .collect(Collectors.toList());
            System.out.println("strings = " + strings);
            for (String string : strings) {
                String[] split = string.split("=");
                System.out.println("split = " + Arrays.toString(split));
                if (keyValue.contains(split[0])) {
                    System.out.println("关键字不能作为变量名！");
                    continue;
                }
                String rule = "^([a-zA-Z]|_)\\w*";
                if (!split[0].matches(rule)) {
                    System.out.println(split[0] + " 的变量名不合法！");
                    continue;
                }
                if (split[1].startsWith("'") && split[1].endsWith("'")) {
                    if (split[1].length() != 3) {
                        System.out.println("不符合字符型规则！");
                    } else {
                        System.out.println("type:char" + " 常量名:" + split[0] + " 常量值:" + split[1]);
                        sum++;
                    }
                    continue;
                }
                if (split[1].startsWith("\"") && split[1].endsWith("\"")) {
                    System.out.println("type:String" + " 常量名:" + split[0] + " 常量值:" + split[1]);
                    sum++;
                    continue;
                }
                if (split[1].matches("^[+-]?(0|([1-9]\\d*))\\.(\\d+)?$")) {
                    if (split[1].endsWith("L") || split[1].endsWith("l")) {
                        System.out.println("type:Double" + " 常量名:" + split[0] + " 常量值:" + split[1]);
                    } else {
                        System.out.println("type:float" + " 常量名:" + split[0] + " 常量值:" + split[1]);
                    }
                    sum++;
                    continue;
                }
                if (split[1].matches("[+-]?\\d+$")) {
                    System.out.println("type:int" + " 常量名:" + split[0] + " 常量值:" + split[1]);
                    sum++;
                    continue;
                }
                if (booleanValue.contains(split[1])) {
                    System.out.println("type:boolean" + " 常量名:" + split[0] + " 常量值:" + split[1]);
                    sum++;
                    continue;
                }
                if (split[1].matches("^(?=.*[0-9])(?=.*[a-z]).*$")) {
                    System.out.println("数据错误！");
                }
            }
            System.out.println("变量的个数为：" + sum);
        }
    }
}
