package aed.find;

import es.upm.aedlib.tree.Tree;



import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;
import java.util.Iterator;


public class Find {

  /**
   * Busca ficheros con nombre igual que fileName dentro el arbol directory,
   * y devuelve un PositionList con el nombre completo de los ficheros
   * (incluyendo el camino).
   */
  public static void find(String fileName, Tree<String> directory) {

	  if(directory.isEmpty()){
		  
		  return;
	  }
	  else
	  {  
		  
          Position<String> cursor = directory.root();            
          
          PositionList<String> caminos = new NodePositionList<String>(findInPos(fileName, directory, cursor));
          
          Printer.enableOutput();
          
          for(String camino : caminos){
        	  
        	  Printer.println(camino);
          }
      }
  }
  
  private static PositionList<String> findInPos(String fileName, Tree<String> directory, Position<String> cursor){
	  
      PositionList<String> path = new NodePositionList<String>();     
      
      Iterable<Position<String>> hijo = directory.children(cursor);
      Iterator<Position<String>> it = hijo.iterator();
     
      if(cursor.element().equals(fileName)){
          
          String camino = "/"; 
          camino = camino + cursor.element();
          path.addLast(camino);
      }
          
          while(it.hasNext()){
              
        	  
              Position<String> nodo = it.next();
              
              Iterable<String> busqueda = findInPos(fileName, directory, nodo);

              for (String caminos : busqueda) {
            	  
                  path.addLast("/" + cursor.element() + caminos);
                 
              }
          }
          return path;
  }
}