import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Trie built using LinkedList
 class AutocompleteTrieNode {
        char data;
        LinkedList<AutocompleteTrieNode> children;
        AutocompleteTrieNode parent;
        boolean isEnd;

        public AutocompleteTrieNode(char c) {
            data = c;
            children = new LinkedList();
            isEnd = false;
        }

        public AutocompleteTrieNode getChild(char c) {
            if (children != null)
                for (AutocompleteTrieNode eachChild : children)
                    if (eachChild.data == c)
                        return eachChild;
            return null;
        }

        protected List getWords() {
            List list = new ArrayList();
            if (isEnd) {
                list.add(toString());
            }

            if (children != null) {
                for (int i=0; i< children.size(); i++) {
                    if (children.get(i) != null) {
                        list.addAll(children.get(i).getWords());
                    }
                }
            }
            return list;
        }

        public String toString() {
            if (parent == null) {
                return "";
            } else {
                return parent.toString() + new String(new char[] {data});
            }
        }
    }

    class AutocompleteTrie {
        private AutocompleteTrieNode root;

        public AutocompleteTrie() {
            root = new AutocompleteTrieNode(' ');
        }

        public void insert(String word) {
            if (search(word) == true)
                return;

            AutocompleteTrieNode current = root;
            AutocompleteTrieNode pre;
            for (char ch : word.toCharArray()) {
                pre = current;
                AutocompleteTrieNode child = current.getChild(ch);
                if (child != null) {
                    current = child;
                    child.parent = pre;
                } else {
                    current.children.add(new AutocompleteTrieNode(ch));
                    current = current.getChild(ch);
                    current.parent = pre;
                }
            }
            current.isEnd = true;
        }

        public boolean search(String word) {
            AutocompleteTrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (current.getChild(ch) == null)
                    return false;
                else {
                    current = current.getChild(ch);
                }
            }
            if (current.isEnd == true) {
                return true;
            }
            return false;
        }

        public List autocomplete(String prefix) {
            AutocompleteTrieNode lastNode = root;
            for (int i = 0; i< prefix.length(); i++) {
                lastNode = lastNode.getChild(prefix.charAt(i));
                if (lastNode == null)
                    return new ArrayList();
            }

            return lastNode.getWords();
        }
    }

