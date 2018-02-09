package aed.recursion;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.*;


public class RecursiveUtils {


  /**
   * Return a^n. 
   * @return a^n.
   */
  public static int power(int a, int n) {
	  
	  
	  
	  	if(n==0){
	  		
	  		return 1;
	  	}
	  	
		if(n==1){
			
			return a;
		}
		
		else{	
		
		int resultado;
		
		resultado = a * power(a, n-1);
			
		return  resultado;
		}
  }

  /**
   *  Returns true if the list parameter does not contain a null element.
   * @return true if the list does not contain a null element.
   */
  public static <E> boolean allNonNull(PositionList<E> l) {
	 
	  Position<E> nodo = l.first();
	  
	  if(nodo==null){
		  
		  return true;
	  }
		
		return allNonNullRec(l, nodo);
  
  }

  /**
   *  Returns the number of non-null elements in the parameter list.
   * @return the number of non-null elements in the parameter list.
   */
  public static <E> int countNonNull(PositionList<E> l) {
	 
	  	int cuenta = 0;
	  	
		Position<E> nodo = l.first();
		
		if (nodo == null){
			
			return 0;		
		}
		
		return countNonNullRec(l, nodo, cuenta);
  }
  private static <E> boolean allNonNullRec(PositionList<E> l, Position<E> posicion){
	 
	 
	  if (posicion.element() == null){
		  
		  return false;
	  }
	  
		if (l.next(posicion) == null){
			
			return true;
		}
		
		posicion = l.next(posicion);
		
		return allNonNullRec(l, posicion);
		
  }
  
  private static <E> int countNonNullRec(PositionList<E> l, Position<E> posicion, int cuenta){
	  
		if (posicion.element() != null){
			
			cuenta=cuenta+1;
		}
		
		if (l.next(posicion) == null){
			
			return cuenta;
		}
		
		posicion = l.next(posicion);
		
		return countNonNullRec(l, posicion, cuenta);
	  
	}
}
