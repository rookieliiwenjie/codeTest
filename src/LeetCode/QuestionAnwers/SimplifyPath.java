package LeetCode.QuestionAnwers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 71. 简化路径
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），
 * 请你将其转化为 更加简洁的规范路径。
 * 在 Unix 风格的文件系统中规则如下：
 * <p>
 * 一个点 '.' 表示当前目录本身。
 * 此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
 * 任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
 * 任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
 * <p>
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 */
public class SimplifyPath {
    public static void main(String[] args) {
//        String s = "/../";
        String s = "/.../a/../b/c/../d/./";//   "/.../b/d"
        //"/a/./b/../../c/" "/c"
        //
//        String s= "/../";

        System.out.println(simplifyPath(s));
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        //双端队列
        Deque<String> strings = new ArrayDeque<>();
        for (String x : split) {
            if (x.equals(".") || x.length() <= 0) {
                continue;
            } else if (x.equals("..")) {
                strings.pollLast();
            } else {
                strings.offerLast(x);
            }

        }
        StringBuilder res = new StringBuilder();
        if (strings.isEmpty()) {
            res.append('/');
        } else {
            while (!strings.isEmpty()) {
                res.append('/');
                res.append(strings.pollFirst());
            }
        }
        return res.toString();
    }

    public String simplifyPath3(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }


    /**
     * 提取特征 按照/ 切割
     *
     * @param path
     * @return
     */
    public static String simplifyPath2(String path) {
        StringBuilder nowSring = new StringBuilder();
        int pathLength = path.length();
        while (pathLength > 0) {

        }
        return nowSring.toString();
    }
}
