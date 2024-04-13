package 前缀树;

public class Trie {
 //每个树的节点
   class TrieNode{
       public int pass;
       public int end;
       public TrieNode[] nexts;
       //构造函数
       public TrieNode(){
           pass = 0;
           end = 0;
           nexts = new TrieNode[26];
       }
   }
   //头节点
   private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    //插入字符串到前缀树中
    public void insert(String word) {
        TrieNode node = this.root;
        node.pass++;
        for (int i = 0; i < word.length(); i++) {
            int path;
            path = word.charAt(i) - 'a';
            //如果当前节点没有指向path的指针，则创建一个
            if (node.nexts[path] == null) {
                node.nexts[path] = new TrieNode();
            }
            //指向下一个节点
            node = node.nexts[path];
            node.pass++;
        }
        //遍历完之后
        node.end++;
    }
   //返回某个单词是否在字典树中
    public int search(String word){
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            int path;
            path = word.charAt(i) - 'a';
            if(node.nexts[path]==null){
                return 0;
            }
            node = node.nexts[path];
        }
        return  node.end;
    }
    //返回某个前缀的单词数量
    public  int prefixNumber(String pref){
        TrieNode node = this.root;
        for (int i = 0; i < pref.length(); i++) {
        int path;
        path = pref.charAt(i) - 'a';
        if(node.nexts[path]==null){
            return 0;
        }
        node = node.nexts[path];
        }
        return node.pass;
    }
    //从前缀树中移除某个单词
    public void delete(String word){
        if(search(word)>0){
            TrieNode node =  this.root;
            node.pass--;
            for (int i = 0; i < word.length(); i++) {
                int path;
                path = word.charAt(i) - 'a';
                if(--node.nexts[path].pass==0){
                    node.nexts[path] = null;
                    return;
                }
                //如果遍历到最后一个节点
                node = node.nexts[path];
            }
            node.end--;
        }

    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcd");
        trie.insert("abcd");
        trie.insert("abcd");
        trie.insert("abcd");
        trie.insert("abcd");
        System.out.println(trie.search("abcd"));
        System.out.println(trie.prefixNumber("abcde"));
        trie.delete("abcd");
        System.out.println(trie.search("abc"));
        System.out.println(trie.prefixNumber("abcd"));
    }
}
