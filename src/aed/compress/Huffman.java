package aed.compress;

import es.upm.aedlib.Position;


import es.upm.aedlib.Entry;
import es.upm.aedlib.tree.*;
import es.upm.aedlib.priorityqueue.*;


public class Huffman {
  private BinaryTree<Character> huffmanTree;
  

  public Huffman(String text) {
    this.huffmanTree = constructHuffmanTree(text);
  }
  
  private BinaryTree<Character> constructHuffmanTree(String text) {
    // CAMBIA este metodo
	  
      int[] charCode = countChars(text);
      
      PriorityQueue<Integer, AttachableLinkedBinaryTree<Character>> queue = new SortedListPriorityQueue<Integer, AttachableLinkedBinaryTree<Character>>();
      for (int i = 0; i < charCode.length; i++) {
          if (charCode[i] > 0) {
              AttachableLinkedBinaryTree<Character> auxTree = new AttachableLinkedBinaryTree<Character>();
              auxTree.addRoot((char) i);
              queue.enqueue(charCode[i], auxTree);
          }
      }
      if (queue.isEmpty()) return null;

      while (queue.size() > 1) {
          Entry<Integer, AttachableLinkedBinaryTree<Character>> left = queue.dequeue();
          Entry<Integer, AttachableLinkedBinaryTree<Character>> right = queue.dequeue();
          AttachableLinkedBinaryTree<Character> aux = new AttachableLinkedBinaryTree<Character>();
          aux.addRoot(' ');
          aux.attach(aux.root(), left.getValue(), right.getValue());
          queue.enqueue((left.getKey() + right.getKey()), aux);
      }
      return queue.dequeue().getValue();
  }

  public static int[] countChars(String text) {
    // CAMBIA este metodo
	  
	int arr[] = new int[256];
		
		for(int i = 0; i<text.length(); i++){
			
			int num = text.charAt(i);
			arr[num] = arr[num]+1;
		
	}
	
    return arr;
    
  }
}



