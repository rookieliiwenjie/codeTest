package LeetCode.Strig;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    public static void main(String[] args) {
        RemoveComments removeComments = new RemoveComments();
        // String [] arr = new String[]{"/* Test program */"," int main ()","{"," //variable declaration "," int a , b , c ;","/* This is a test "," multiline "," comment for "," testing */"," a = b + c;","}"};
        String[] arr = new String[]{"main (){", "/*here is commments", " //still comments*/", " double s = 33;", " cout << s;", "}"};

        //System.out.println(removeComments.removeComments(new String[]{"a/*comment", "line", "more_comment*/b"}));
        //System.out.println(removeComments.removeComments(new String[]{"/*Test program */", "int main()", " // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;"}));
        //System.out.println();
        removeComments.removeComments(arr).forEach(System.out::print);

    }

    /**
     * 垃圾代码判断太多
     * @param source
     * @return
     */
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        boolean flag = true;
        for (String s : source) {
            if (s.contains("/*")) {
                int index = s.indexOf("/*");
                flag = false;
                temp.append(s.substring(0, index));
            }
            if (s.contains("//")) {
                int index = s.indexOf("//");
                int index2 = s.indexOf("/*");
                if (!flag) {
                    if (index < index2) {
                        flag = true;
                        temp = new StringBuilder();
                    } else if (index2 == -1) {
                        continue;
                    }
                }
                int index3 = s.indexOf("*/");
                if (index3 == -1 && s.substring(0, index).length() > 0) {
                    result.add(s.substring(0, index));
                }
                continue;
            }
            if (s.contains("*/")) {
                int index = s.lastIndexOf("*/");
                temp.append(s.substring(index + 2, s.length()));
                if (!temp.toString().isEmpty()) {
                    result.add(temp.toString());
                }
                temp = new StringBuilder();
                flag = true;

            }
            if (flag && !s.contains("/*") && !s.contains("*/")) {
                if (!temp.toString().isEmpty()) {
                    result.add(temp.toString());
                }
                result.add(s);
            }
        }
        return result;
    }

    public List<String> removeComments3(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        boolean flag = true;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (flag) {
                    if (s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '*') {
                        flag = false;
                        i++;
                    } else if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                        break;
                    } else {
                        temp.append(s.charAt(i));
                    }
                } else {
                    if (i + 1 < s.length() && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                        flag = true;
                        i++;
                    }
                }
            }
            if (flag && temp.length() > 0) {
                result.add(temp.toString());
                temp = new StringBuilder();
            }
        }
        return result;
    }

    public List<String> removeComments2(String[] source) {
        List<String> res = new ArrayList<String>();
        StringBuilder newLine = new StringBuilder();
        boolean inBlock = false;
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (inBlock) {
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
                        i++;
                    }
                } else {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlock = true;
                        i++;
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;
                    } else {
                        newLine.append(line.charAt(i));
                    }
                }
            }
            if (!inBlock && newLine.length() > 0) {
                res.add(newLine.toString());
                newLine.setLength(0);
            }
        }
        return res;
    }
}
