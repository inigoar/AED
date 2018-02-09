package aed.laberinto;

import es.upm.aedlib.lifo.*;
import java.util.Iterator;

public class Exploradora {

/**
 * Busca un tesoro en el laberinto, empezando en el lugar
 * inicial: inicialLugar. 
 * @return un Objeto tesoro encontrado, o null, si ningun
 * tesoro existe en la parte del laberinto que es alcanzable
 * desde la posicion inicial.
 */
  public static Object explora(Lugar inicialLugar) {
    LIFO<Lugar> faltaPorExplorar = new LIFOList<Lugar>();
    
    // Modificar el resto de este metodo
    
    Lugar miPosicion = inicialLugar;
    faltaPorExplorar.push(miPosicion);
    
    if(faltaPorExplorar.isEmpty()){
    	
    	return null;
    	
    }
    
    else
    	
    {
    	
    while (!faltaPorExplorar.isEmpty()){
    	
    	miPosicion = faltaPorExplorar.pop();
    	
        Iterable<Lugar> t = miPosicion.caminos();
        Iterator<Lugar> it = t.iterator();
        
        if (!miPosicion.sueloMarcadoConTiza()){
            
            if (miPosicion.tieneTesoro()){
            	
                return miPosicion.getTesoro();
            }
            
            miPosicion.marcaSueloConTiza();
            
        }
        
        while (it.hasNext()){
        	
            Lugar posicionSiguiente = it.next();
            
            if (!posicionSiguiente.sueloMarcadoConTiza()){
            	
                faltaPorExplorar.push(posicionSiguiente);
            }
        }
    	}
    }

    return null;
}  
}

