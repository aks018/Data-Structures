/*
A trie and sometimes even radix tree or prefix tree is an ordered tree structure, which takes advantage of the keys it stores;
usually strings. A node's position in the tree defines the key with which that node is associated, which makes tries
different in comparison to binary search trees, in which a node stores a key that corresponds only to that node. All descendants of a node
have a common prefix of a String associated with that node, whereas the root is associated with an empty String.
 */

import java.util.*;

class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    char c;
    boolean isWord;

    public TrieNode(){}

    public TrieNode(char c){
        this.c = c;
    }

}

public class Trie {
    private TrieNode root;

    public Trie()
    {
        root = new TrieNode();
    }

    public void insert(String word)
    {
        //Get the children for the current root.
        HashMap<Character, TrieNode> children = root.children;

        //Loop through the word to be inserted
        for(int i=0; i<word.length(); i++)
        {
            //Pull out the character at the given index
            char c = word.charAt(i);
            TrieNode t;

            //Now check if the map of children for the node contains the current character
            //If it does, then we can keep going down the trie
            //If the character does not exist in the childrens map then lets create a new node and add it into the children map.
            if(children.containsKey(c)) {
                t = children.get(c);
            }
            else
            {
                t = new TrieNode(c);
                children.put(c,t);
            }

            //Update children to be of the new AutocompleteTrieNode
            children = t.children;

            //If we reach the end of the word, set the trie node of this word to be true so when we search for it we are able to find it.
            if(i==word.length()-1)
            {
                t.isWord = true;
            }
        }

    }

    //Lets go ahead and check if the trie contains the word.
    public boolean search(String word)
    {
        TrieNode t = searchNode(word);

        if(t!=null && t.isWord)
            return true;
        else
            return false;
    }

    //Lets go ahead and check if the trie contains any word that starts with the given prefix
    public boolean startsWith(String word)
    {
        if(searchNode(word) == null)
            return false;
        return true;
    }

    //Search the Trie for the word passed
    public TrieNode searchNode(String word)
    {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            if(children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            }
            else
                return null;
        }
        return t;
    }



}


