import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataStructuresConstants constants = new DataStructuresConstants();

        //Testing Trie
        Trie trie = new Trie();
        for (String word : constants.getDictionary(constants.dictionaryArr)) {
            trie.insert(word);
        }

        //Let's check if some words exist in the trie now
        System.out.println("Does word what exist in the dictionary? " + trie.search("what"));
        System.out.println("Does word scientists exist in the dictionary? " + trie.search("scientists"));
        System.out.println("Does word be exist in the dictionary? " + trie.search("be"));
        System.out.println("Does word backk exist in the dictionary? " + trie.search("back"));
        System.out.println("Does word social exist in the dictionary? " + trie.search("social"));

        System.out.println("---------------------------------------------------------------------------");

        //Let's check if some prefix's exist in our trie.
        System.out.println("Does prefix he exist in the dictionary? " + trie.startsWith("he"));
        System.out.println("Does prefix lo exist in the dictionary? " + trie.startsWith("lo"));
        System.out.println("Does prefix jk exist in the dictionary? " + trie.startsWith("jk"));
        System.out.println("Does prefix a exist in the dictionary? " + trie.startsWith("a"));
        System.out.println("Does prefix an exist in the dictionary? " + trie.startsWith("an"));

        System.out.println("---------------------------------------------------------------------------");

        //Now let's build a trie to help us work with an autocomplete function
        System.out.println("Autocompelte Trie: ");
        AutocompleteTrie t = new AutocompleteTrie();
        t.insert("amazon");
        t.insert("amazon prime");
        t.insert("amazing");
        t.insert("amazing spider man");
        t.insert("amazed");
        t.insert("alibaba");
        t.insert("ali express");
        t.insert("ebay");
        t.insert("walmart");
        List a= t.autocomplete("amaz");
        System.out.print("Results for query amaz: ");
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");

        //Another autocomplete trie using char[]
        System.out.println("Autocompelte Trie Using Char[]: ");
        TrieWithCharArray tc = new TrieWithCharArray();
        tc.addWord("amazon");
        tc.addWord("amazonprime");
        tc.addWord("amazing");
        tc.addWord("amazingspiderman");
        tc.addWord("amazed");
        tc.addWord("alibaba");
        tc.addWord("aliexpress");
        tc.addWord("ebay");
        tc.addWord("walmart");
        String[] ans= tc.wordsByPrefix("amazo");
        System.out.print("Results for query amazo: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");

    }
}
