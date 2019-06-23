import java.util.HashMap;

// https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
// 前缀树的实现其实很简单，不要畏难
public class Trie {

    private Node root;

    // 只在内部使用，因此访问控制符是 root
    private class Node {
        private boolean isWord;
        // 不要忘记写上构造方法初始化 next 所对应的 Hash 表
        private HashMap<Character, Node> next;

        public Node() {
            this.isWord = false;
            this.next = new HashMap<>();
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        // 根节点不表示任何字符
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!curNode.next.containsKey(c)) {
                curNode.next.put(c, new Node());
            }
            curNode = curNode.next.get(c);
        }
        // 如果之前没有设置过，才设置成 true
        if (!curNode.isWord) {
            curNode.isWord = true;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (curNode.next.containsKey(c)) {
                curNode = curNode.next.get(c);
            } else {
                // 中途就出错了
                return false;
            }
        }
        // 到了末尾还要判断一下
        return curNode.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (curNode.next.containsKey(c)) {
                curNode = curNode.next.get(c);
            } else {
                return false;
            }
        }
        // 能走完就说明有这个前缀
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        // 返回 true
        boolean search1 = trie.search("apple");
        System.out.println(search1);
        // 返回 false
        boolean search2 = trie.search("app");
        System.out.println(search2);
        // 返回 true
        boolean startsWith = trie.startsWith("app");
        System.out.println(startsWith);
        trie.insert("app");
        // 返回 true
        boolean search3 = trie.search("app");
        System.out.println(search3);
    }
}
