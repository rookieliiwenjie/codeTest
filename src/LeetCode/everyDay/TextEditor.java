package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.List;

/**
 * 请你设计一个带光标的文本编辑器，它可以实现以下功能：
 * <p>
 * 添加：在光标所在处添加文本。
 * 删除：在光标所在处删除文本（模拟键盘的删除键）。
 * 移动：将光标往左或者往右移动。
 * 当删除文本时，只有光标左边的字符会被删除。光标会留在文本内，
 * 也就是说任意时候 0 <= cursor.position <= currentText.length 都成立。
 * <p>
 * 请你实现 TextEditor 类：
 * <p>
 * TextEditor() 用空文本初始化对象。
 * void addText(string text) 将 text 添加到光标所在位置。添加完后光标在 text 的右边。
 * int deleteText(int k) 删除光标左边 k 个字符。返回实际删除的字符数目。
 * string cursorLeft(int k) 将光标向左移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 * string cursorRight(int k) 将光标向右移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 */
public class TextEditor {
    StringBuilder texts;
    int curronIndex;

    public TextEditor() {
        texts = new StringBuilder();
        curronIndex = 0;
    }



    //addText(string text) 将 text 添加到光标所在位置。添加完后光标在 text 的右边。
    public void addText(String text) {
        texts.insert(curronIndex, text);
        curronIndex += text.length();
    }

    //int deleteText(int k) 删除光标左边 k 个字符。返回实际删除的字符数目
    public int deleteText(int k) {
        int reulst = curronIndex - k > 0 ? k : curronIndex;
        texts.delete(Math.max(curronIndex - k, 0), curronIndex);
        curronIndex = Math.max(curronIndex - k, 0);
        return reulst;
    }

    //string cursorLeft(int k) 将光标向左移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
    public String cursorLeft(int k) {
        int index = Math.max(curronIndex - k, 0);
        curronIndex = index;
        return texts.substring(index >= 10 ? index - 10 : 0, index);
    }

    //string cursorRight(int k) 将光标向右移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
    public String cursorRight(int k) {
        int index = Math.min(curronIndex + k, texts.length());
        curronIndex = index;
        return texts.substring(index >= 10 ? index - 10 : 0, Math.min(index, texts.length()));
    }


    class Node {
        char val;
        Node prev, next;

        Node(char val) {
            this.val = val;
        }

        void insert(char val) {
            Node node = new Node(val);
            node.next = this;
            node.prev = this.prev;
            if (this.prev != null) {
                this.prev.next = node;
            }
            this.prev = node;
        }

        void remove() {
            Node node = this.prev;
            this.prev = node.prev;
            if (node.prev != null) {
                node.prev.next = this;
            }
        }

        String range(Node end) {
            StringBuilder sb = new StringBuilder();
            Node node = this;
            while (node != end) {
                sb.append(node.val);
                node = node.next;
            }
            return sb.toString();
        }
    }

    class TextEditor2 {
        private Node cursor;

        public TextEditor2() {
            cursor = new Node('\0'); // 空字符表示光标位置
        }

        public void addText(String text) {
            for (char c : text.toCharArray()) {
                cursor.insert(c);
            }
        }

        public int deleteText(int k) {
            int count = 0;
            while (k > 0 && cursor.prev != null) {
                cursor.remove();
                k--;
                count++;
            }
            return count;
        }

        public String cursorLeft(int k) {
            while (k > 0 && cursor.prev != null) {
                cursor = cursor.prev;
                k--;
            }
            Node head = cursor;
            for (int i = 0; i < 10 && head.prev != null; i++) {
                head = head.prev;
            }
            return head.range(cursor);
        }

        public String cursorRight(int k) {
            while (k > 0 && cursor.next != null) {
                cursor = cursor.next;
                k--;
            }
            Node head = cursor;
            for (int i = 0; i < 10 && head.prev != null; i++) {
                head = head.prev;
            }
            return head.range(cursor);
        }
    }

}
