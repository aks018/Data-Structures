package Trie;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Node{
    Node[] children;
    boolean terminal;
    char label;
    String word;

    private static int ALPHABET_SIZE = 26;

    public Node()
    {
        this.children = new Node[ALPHABET_SIZE];
    }

    public Node(char c)
    {
        this();
        this.label = c;
    }
}
/*
Traverse through the Trie.Trie to find the node which stores the last character of the prefix.
Two cases may occur
Either the prefix gets exhausted
We reach a null node.
If we reach a null node then there are no words with this prefix so return
If the prefix gets exhausted at a node TN, then the whole sub tree of TN qualifies for the result.
Print all the paths to all leaves from this node. (You can use any technique to print all paths from a given node, here we will use a queue.
 */
public class TrieWithCharArray {
    private Node root;

    public TrieWithCharArray() {
        this.root = new Node(' ');
    }

    public String[] wordsByPrefix(String prefix) {
        char[] cArray = prefix.toCharArray();
        Node temp = root;
        Node tn = null;
        int index = 0;

        do{
            tn = temp.children[cArray[index] - 'a'];
            if(tn==null)
                return null;

            index++;
            temp = tn;
        } while(index < cArray.length);

        List<String> words = new ArrayList<>();
        Deque<Node> dq = new ArrayDeque<>();
        dq.addLast(temp);
        while(!dq.isEmpty()) {
            Node first = dq.removeFirst();
            if (first.terminal)
                words.add(first.word);

            for (Node node : first.children) {
                if (node != null)
                    dq.add(node);
            }
        }

        return words.toArray(new String[0]);

    }

    /*
    Start from the root of the Trie.Trie
    For the first character in the word, find if there exist a child node to the root containing that character.
    If no node is present, then add a node with the first character of the word, and subsequently add child nodes for the following characters.
    For e.g. If AGRA was the first word to be added, we add the node with A as a child of the root and subsequent children for G, R and A
    If the node is found, move to the next character in the word and the child node in the Trie.Trie.
    Repeat this process until either the word is exhausted or we reach to a null child node.
    For e.g. In an attempt to add AJMER after adding AGRA, we start from the root, and discover that the node with label A exists. Where A is the first character in AJMER.
    Then we move to the node A and try to find J in its children list. But we do not find J, instead if we try to fetch a node with J which is the child of node A, we will get a null node.
    If reached a null child and there is still part of the word remaining, just add it child nodes  one after the other. SO J becomes the child of A, M gets to be the child of J and so on.
     */
    public void addWord(String word)
    {
        char[] cArray = word.toCharArray();
        Node temp = root;
        Node tn = null;
        int index = 0;

        do{
            tn = temp.children[cArray[index]-'a'];
            if(tn!=null)
            {
                temp = tn;
                index++;

                if(index>=word.length())
                {
                    temp.terminal = true;
                    temp.word = word;
                    return;
                }
            }

        }while(tn!=null);

        for(; index<cArray.length; index++)
        {
            temp.children[cArray[index]-'a'] = new Node(cArray[index]);
            temp = temp.children[cArray[index] - 'a'];
        }

        temp.terminal = true;
        temp.word = word;

    }
}
