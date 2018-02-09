package aed.loops;

public class Utils {
  public static int maxNumRepeated(Integer[] l, Integer elem)  {	  
	
	 int seguido = 0;
	 int num = 0;
	 
	 if(l.length==0){
		 
		 return 0;
	 }
	 
	 for(int i=0; i<l.length; i++){
		 
		 if(l[i].equals(elem)){
			 
			 seguido=seguido+1;
		 }
		 else{
			 
			 seguido=0;
			 
		 }
		 if(num<seguido){
			 
			 num=seguido;
		 }
	 }
    return num;  
  }
}