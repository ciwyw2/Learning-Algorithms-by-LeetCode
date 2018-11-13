import java.util.*;

// https://leetcode-cn.com/problems/word-ladder-ii/description/
// 还是 TLE 解，继续努力啊
public class Solution2 {

    private List<List<String>> res = new ArrayList<>();
    private Set<String> wordSet;


    private int maxDepth = 0;

    // 只返回与它相差一个字符的元素，使用缓存存起来
    private List<String> onlyOne(String word) {
        List<String> nextWords = new ArrayList<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char[] wordUnits = word.toCharArray();

            for (char j = 'a'; j <= 'z'; j++) {
                wordUnits[i] = j;
                String temp = new String(wordUnits);
                if (wordSet.contains(temp)) {
                    nextWords.add(temp);
                }
            }
        }
        return nextWords;
    }


    private class Pair {
        private String word;
        private Integer step;

        public Pair(String word, Integer step) {
            this.word = word;
            this.step = step;
        }
    }


    private void calculateMaxDepth(String beginWord, String endWord) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(beginWord, 1));
        while (!queue.isEmpty()) {
            Pair curPair = queue.removeFirst();
            String curWord = curPair.word;
            Integer curStep = curPair.step;
            curStep++;
            List<String> nextWords = onlyOne(curWord);
            for (String nextWord : nextWords) {
                wordSet.remove(nextWord);
                if (nextWord.equals(endWord)) {
                    this.maxDepth = curStep;
                    return;
                }
                queue.addLast(new Pair(nextWord, curStep));
            }
        }
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        wordSet = new HashSet<>(wordList);
        if (wordSet.contains(beginWord)) {
            wordSet.remove(beginWord);
        }

        // 计算最大的深度
        calculateMaxDepth(beginWord, endWord);
        System.out.println("最大深度是 " + maxDepth);

        // 重新初始化访问的集合
        wordSet = new HashSet<>(wordList);
        if (wordSet.contains(beginWord)) {
            wordSet.remove(beginWord);
        }
        List<String> pre = new ArrayList<>();
        pre.add(beginWord);
        dfs(beginWord, endWord, 1, pre);

        return res;
    }


    private void dfs(String beginWord, String endWord, int depth, List<String> pre) {
        if (depth > maxDepth) {
            return;
        }
        if (depth == maxDepth && beginWord.equals(endWord)) {
            res.add(new ArrayList<>(pre));
            return;
        }
        List<String> nextWords = onlyOne(beginWord);
        for (String nextWord : nextWords) {
            wordSet.remove(nextWord);
            pre.add(nextWord);
            dfs(nextWord, endWord, depth + 1, pre);
            wordSet.add(nextWord);
            pre.remove(pre.size() - 1);
        }
    }


    public static void main(String[] args) {
        // write your code here
        // write your code here

//        List<String> wordList = new ArrayList<>();
//        wordList.add("hot");
//        wordList.add("dot");
//        wordList.add("dog");
//        wordList.add("lot");
//        wordList.add("log");
//        wordList.add("cog");
//
//
//        Solution2 solution = new Solution2();
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
//        System.out.println(res);


//        String[] words = {"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};
//        List<String> wordList = new ArrayList<>();
//
//        for (String word : words) {
//            wordList.add(word);
//        }
//        Solution2 solution2 = new Solution2();
//        String beginWord = "qa";
//        String endWord = "sq";
//        List<List<String>> res = solution2.findLadders(beginWord, endWord, wordList);
//        System.out.println("最终解是：");
//        System.out.println(res);

//
//        String[] words = {"rex", "ted", "tex", "tad", "tax"};
//        List<String> wordList = new ArrayList<>();
//
//        for (String word : words) {
//            wordList.add(word);
//        }
//        Solution2 solution = new Solution2();
//        String beginWord = "red";
//        String endWord = "tax";
//        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
//        System.out.println(res);


//        String[] words = {"b", "c"};
//        List<String> wordList = new ArrayList<>();
//
//        for (String word : words) {
//            wordList.add(word);
//        }
//        Solution2 solution = new Solution2();
//        String beginWord = "a";
//        String endWord = "c";
//        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
//        System.out.println(res);


        String[] words = {"kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob"};

        System.out.println(words.length);

        List<String> wordList = new ArrayList<>();

        for (String word : words) {
            wordList.add(word);
        }
        Solution2 solution = new Solution2();
        String beginWord = "cet";
        String endWord = "ism";
        System.out.println("开始搜索。。。。");
        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(res);

    }
}
