package project1;

public class Point {
	
		// a point should have
		//x and y coordinate
		//cluster_ID
	    protected double[] coordinate;
	    protected int clusterID;
	    protected boolean occupied;
	    protected int pointID;
	   
	    //give the point the cluster it belongs to
	    public Point(double[] coordinates, int id) {
		   this.coordinate=coordinates;
		   this.clusterID=id;
		   occupied=false;
		   pointID=0;
	   }
	    
	    //get the pointID
	    public int getPointID() {
	    	   return this.pointID;
	    }
	    
	    //set the pointID
	    public void setPointID(int id) {
	    	   this.pointID=id;
	    }
	    
	    //get the occupied state
	    public boolean getState() {
	    	  return this.occupied;
	    }
	    
	    //set the state of occupied
	    public void setState(boolean state) {
	    	  this.occupied=state;
	    }
	    //get the dimension
	    public int getDim() {
	    	 return this.coordinate.length;
	    }
	    
	  
	    
	    //set coordinate at pos i to be var
	    public void setCoordinateI(int i,double var) {
	    	 	this.coordinate[i]=var;
	    }
	    

	    
	    //return the var of coordinates at pos i
	    //0:x. 1:y
	    public double getCoordinateI(int i) {
		   return this.coordinate[i];
	   }
	    
	  
	    
	    //return the cluster ID
	    public int getID() {
	     	return this.clusterID;
	    }
	    
	    //set cluster ID
	    public void setID(int id) {
	    	  	this.clusterID=id;
	    }
	    
	
	    //return the Euclidean distance between the point and a coordinate
	    public  double distance(Point two) {
	    	    double dis=0;
	    	    int len1=this.coordinate.length;
	    	    int len2=two.coordinate.length;
	    	    if(len1 != len2) 
	    	    	throw new ArithmeticException("two points are of different length");
	    	    
	    	    for(int i=0;i!=len1; i++) {
	    	    	   double j=this.getCoordinateI(i);
	    	    	   double k=two.getCoordinateI(i);
	    	    	   dis+=(j-k)*(j-k);
	    	    }
	    	    		
	    	    	return Math.sqrt(dis);
	    	 
	    	    }
	    
	    
	    	    
	    
}
