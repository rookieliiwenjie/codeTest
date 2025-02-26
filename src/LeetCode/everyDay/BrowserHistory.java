package LeetCode.everyDay;

import java.util.*;

/**
 * 你有一个只支持单个标签页的 浏览器 ，最开始你浏览的网页是 homepage ，
 * 你可以访问其他的网站 url ，也可以在浏览历史中后退 steps 步或前进 steps 步。
 * <p>
 * 请你实现 BrowserHistory 类：
 * <p>
 * BrowserHistory(string homepage) ，用 homepage 初始化浏览器类。
 * void visit(string url) 从当前页跳转访问 url 对应的页面  。执行此操作会把浏览历史前进的记录全部删除。
 * string back(int steps) 在浏览历史中后退 steps 步。如果你只能在浏览历史中后退至多 x 步且 steps > x ，
 * 那么你只后退 x 步。请返回后退 至多 steps 步以后的 url 。
 * string forward(int steps) 在浏览历史中前进 steps 步。
 * 如果你只能在浏览历史中前进至多 x 步且 steps > x ，那么你只前进 x 步。请返回前进 至多 steps步以后的 url 。
 */
public class BrowserHistory {
    List<String> history;
    Integer currentIndex;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        currentIndex = 0;
    }

    public void visit(String url) {
        while (history.size() > currentIndex + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        currentIndex++;

    }

    public String back(int steps) {
        currentIndex = Math.max(0, currentIndex - steps);
        return history.get(currentIndex);
    }

    public String forward(int steps) {
        currentIndex = Math.min(history.size() - 1, currentIndex + steps);
        return history.get(currentIndex);
    }
}
