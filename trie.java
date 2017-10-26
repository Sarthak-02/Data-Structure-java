package Trie;
import java.util.*;
import java.io.*;
public class trie {
	
	class Node{
		Map<Character,Node> children;
		boolean endOfWord;
		Node(){
			children = new HashMap<>();
			endOfWord = false;
		}
	}
	Node root ;
	trie(){
		root = new Node();
	}
	
	//insert a string
	public void insert(String word) {
		Node curr = root;
		for(int i=0;i<word.length();i++) {
			Node node  = curr.children.get(word.charAt(i));
			if(node==null) {
				node = new Node();
				curr.children.put(word.charAt(i), node);
			}
			curr = node;
		}
		
		curr.endOfWord = true;
	}
	
	//search a word 
	
	public boolean search(String word) {
		Node curr = root;
		for(int i=0;i<word.length();i++) {
			Node node = curr.children.get(word.charAt(i));
			if(node==null) {
				return false;
			}
			curr = node;
		}
		return curr.endOfWord;
	}
	
	//search a prefix
	
	public boolean prefix(String word) {
		Node curr = root;
		for(int i=0;i<word.length();i++) {
			Node node = curr.children.get(word.charAt(i));
			if(node==null) {
				return false;
			}
			curr = node;
		}
		
		return true;
	}
	
	//delete word from trie
	
	public void delete(String word) {
			delete(root,word,0);
	}
	
	//Return true if word can be deleted
	public boolean delete(Node curr,String word,int index) {
		if(index == word.length()) {
			//when end of word is reached only delete if current.endOfWord is true
			if(!curr.endOfWord) {
				return false;
			}
			curr.endOfWord=false;
			
			return curr.children.size()==0;
		}
		
		char ch = word.charAt(index);
		Node node = curr.children.get(ch);
		if(node==null) {
			return false;//word doesnt exist
		}
		boolean shouldDeleteCurrNode = delete(node,word,index+1);
		
		if(shouldDeleteCurrNode) {
			curr.children.remove(ch);
			//return true if no mappings are left in the map.
			return curr.children.size()==0;
		}
		return false;
	}
	public static void main(String[] args) {
		trie t = new trie();
		t.insert("Sarthak");
		System.out.println(t.search("Sarthak"));
		System.out.println(t.prefix("Sarth"));
		t.delete("Sarthak");
		System.out.println(t.search("Sarthak"));
	}
}
