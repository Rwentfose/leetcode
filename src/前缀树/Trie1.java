package 前缀树;

import java.util.HashMap;
import java.util.Map;

public class Trie1 {

    class TrieNode{

        public int pass;

        public int end;

        public Map<Integer,TrieNode> nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    public  TrieNode root;

    public Trie1() {
        root = new TrieNode();
    }

    // 方法1
    public void insert(String word) {
        TrieNode node = this.root;
        node.pass++;
        for (int i = 0; i < word.length(); i++) {
            int path;
            //获取word单词的每一个字母
            path = word.charAt(i);
            //查询有没有下一个节点
           if (!node.nexts.containsKey(path)){
               //没有就创建
               node.nexts.put(path,new TrieNode());
           }
           //有就向下遍历
           node = node.nexts.get(path);
           //记录路径
           node.pass++;
        }
        //记录单词的结束位置
        node.end++;

    }
    // 方法2

    public int search(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            int path = word.charAt(i);
            if(!node.nexts.containsKey(path)){
                return 0;
            }
            //得出下一个节点
            node = node.nexts.get(path);
        }
        //返回最终路径下的单词数量
        return node.end;
    }

    public int prefixNumber(String pre) {
        TrieNode node = this.root;
        for (int i = 0; i < pre.length(); i++) {
            int path = pre.charAt(i);
          if(!node.nexts.containsKey(path)){
              return  0;
          }
            node = node.nexts.get(path);
        }
        return node.pass;
    }

    public void delete(String word) {
      TrieNode node = this.root;
      node.pass--;
      for (int i = 0; i < word.length(); i++) {
          int path = word.charAt(i);
          if(--node.nexts.get(path).pass == 0){
              node.nexts.remove(path);
              return;
          }
          node = node.nexts.get(path);
      }
          node.end--;
    }

    public static void main(String[] args) {
        Trie1 trie1 = new Trie1();
        trie1.insert("asdf");
        trie1.insert("asdf");
        trie1.insert("qwer");
        System.out.println(trie1.search("asdf"));
        System.out.println(trie1.prefixNumber("qw"));
        trie1.delete("asdf");
        System.out.println(trie1.search("qwer"));
    }
}
