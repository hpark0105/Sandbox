package Contacts;

import java.util.*;

class Result {

  public static class TrieNode {
    HashMap<Character, TrieNode> node;
    int size;

    public TrieNode() {
      node = new HashMap();
      size = 0;
    }

    public void add(Character c) {
      node.putIfAbsent(c, new TrieNode());
    }

    public TrieNode get(Character c) {
      return node.get(c);
    }
  }

  public static class Trie {
    TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    public void add(String word) {
      TrieNode curr = root;
      for (char c : word.toCharArray()) {
        curr.add(c);
        curr.size++;
        curr = curr.get(c);
      }
    }

    public int find(String prefix) {
      TrieNode curr = root;
      for (char c : prefix.toCharArray()) {
        curr = curr.get(c);
        if (curr == null) {
          return 0;
        }
      }
      return curr.size;
    }
  }

  /*
   * Complete the 'contacts' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts 2D_STRING_ARRAY queries as parameter.
   */
  public static List<Integer> contacts(List<List<String>> queries) {
    Trie trie = new Trie();
    List<Integer> resultList = new ArrayList<>();
    // loop through the queries
    for (List<String> query : queries) {
      // validate first word for command
      if (query.get(0).equals("add")) {
        System.out.println("adding " + query.get(1));
        trie.add(query.get(1));
      } else if (query.get(0).equals("find")) {
        System.out.println("finding " + query.get(1));
        resultList.add(trie.find(query.get(1)));
      } else {
        System.out.println("Wrong command");
        continue;
      }
      System.out.println();
    }
    return resultList;
  }
}
