package project1;

//create a random vector of length limit
public class Misc {
    static double[] randVec(int[] limit) {
    	  
    	    int min=0;
    	    int len=limit.length;
    	    double[] randvec=new double[len];
      	for(int i=0;i!=len;i++) {
      		randvec[i]=(double)(int)(Math.random()*(limit[i] - min)) + min;
      	}
      	return randvec;
    }
    
    

    public static void main(String []args) {
    	    int []limit=new int[] {10,20};
    	    System.out.println(randVec(limit)[0]);
    	    System.out.println(randVec(limit)[1]);
    	     
    }
}
