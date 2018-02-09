package aed.mergelists;

import es.upm.aedlib.Position;

import es.upm.aedlib.indexedlist.ArrayIndexedList;
import es.upm.aedlib.indexedlist.IndexedList;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;
import java.util.Comparator;


public class MergeLists {

  /**
   * Merges two lists ordered using the comparator cmp, returning
   * a new ordered list.
   * @returns a new list which is the ordered merge of the two argument lists
   */
  public static <E> PositionList<E> merge(final PositionList<E> l1,
                                          final PositionList<E> l2,
                                          final Comparator<E> comp) {
	  
	  boolean primero = l1.isEmpty();
	  boolean segundo = l2.isEmpty();
	  
	  PositionList<E> list = new NodePositionList<E>();
	  
	if(primero && segundo){
		return list;
	}
	
	else if(!primero && segundo){
		 list = nuevaPositionList(l1);
	}
	
	else if(primero && !segundo){
		 list = nuevaPositionList(l2);
	}
	
	else{
		
	          Position<E> i = l1.first();
	          Position<E> j = l2.first();
	          Position<E> posicion = list.first();
	          
	          do{
	              if (list.isEmpty()){
	                  if(comp.compare(i.element(), j.element()) < 0){
	                      list.addFirst(i.element());
	                      i = l1.next(i);
	                  }
	                  
	                  else {
	                      list.addFirst(j.element());
	                      j = l2.next(j);
	                  }
	                  
	                  posicion = list.first();
	              }
	              
	              else{
	                  if(comp.compare(i.element(), j.element()) < 0){
	                      list.addAfter(posicion, i.element());
	                      i = l1.next(i);
	                  }
	                  
	                  else {
	                      list.addAfter(posicion, j.element());
	                      j = l2.next(j);
	                  }
	                  posicion = list.next(posicion);
	              }
	              
	          }while(i!=null && j!=null);
	          
	          if(i!=null){
	        	  
	        	  do{
	              list.addAfter(posicion, i.element());
	              i = l1.next(i);
	              posicion = list.next(posicion);
	        	  }while(i!=null);
	          }
	          
	          if(j!=null){
	        	  do{
	              list.addAfter(posicion, j.element());
	              j = l2.next(j);
	              posicion = list.next(posicion);
	        	  }while(j!=null);
	          }
		
		
	}
	   
    return list;
  }

  /**
   * Merges two lists ordered using the comparator cmp, returning
   * a new ordered list.
   * @returns a new list which is the ordered merge of the two argument lists
   */
  public static <E> IndexedList<E> merge(final IndexedList<E> l1,
                                         final IndexedList<E> l2,
                                         final Comparator<E> comp) {
	  
	  boolean primero = l1.isEmpty();
	  boolean segundo = l2.isEmpty();
	  
	  
	  IndexedList<E> list = new ArrayIndexedList<E>();

	  if(primero && segundo){
			return list;
		}
		
		else if(!primero && segundo){
			list = nuevaIndexedList(l1);
		}
		
		else if(primero && !segundo){
			list = nuevaIndexedList(l2);
		}
	  
      else{
    	  
          int i = 0;
          int j = 0;
          int posicion = 0;
          
          
         do{
              if(comp.compare(l1.get(i), l2.get(j)) < 0){
                  list.add(posicion, l1.get(i));
                  i++;
              }
              else{
                  list.add(posicion, l2.get(j));
                  j++;
              }
              
              posicion++;
              
          }while(i<l1.size() && j<l2.size());
    
          if(i<l1.size()){
        	  
        	  for(int h=i ; h<l1.size(); h++){
              list.add(posicion, l1.get(h));
              posicion++;
        	  }
          }
          
          if(j<l2.size()){
        	  
        	  for(int h=j ; h<l2.size(); h++){
              list.add(posicion, l2.get(h));
              posicion++;
        	  }
          }
      }
	  
    return list;
	 
  }

private static <E> PositionList<E> nuevaPositionList(final PositionList<E> lista){
	
    PositionList<E> list = new NodePositionList<E>();
    
    Position<E> i = lista.first();
    list.addFirst(i.element());
    i = lista.next(i);
    
    if(i!=null){
    	
    	do{
        list.addLast(i.element());
        i = lista.next(i);
    }while(i!=null);
    	
    }
    return list;
}

private static <E> IndexedList<E> nuevaIndexedList(final IndexedList<E> lista){
	
    IndexedList<E> list = new ArrayIndexedList<E>();
    
    for (int i=0; i<lista.size(); i++){
        list.add(i, lista.get(i));
    }

    return list;
}
}

