package project1;
import java.util.ArrayList;
import java.util.Arrays;



public class Cluster {

   protected Point centroid;
   public  ArrayList<Point> points;
   protected int ID;
   
   //constructor
   //build the cluster based on the centroid
   public Cluster(Point one) {
	  this.centroid=one;
	  this.ID=one.getID();
	  this.points= new ArrayList<Point>();
	 
   }

   
   //print the ID of the cluster
   public int getID() {
	   return this.ID;
   }
   
   //print centroid of the cluster
   public Point getCentroid() {
	   return this.centroid;
   }
   
   //set ID of the cluster
   public void setID(int id) {
	   this.ID=id;
	   
   }
   
   //set the centroid of the cluster
   public void setCentroid(Point cent) {
	   this.centroid=cent;
   }
   
   //add point to points arraylist
   public void add(Point p) {
	   this.points.add(p);
   }
   
   //find the size of the cluster
   public int getSize() {
	   return this.points.size();
   }
   
   
   //find the new centroid based on the points in arraylist points
   //set the old centroid to the new centroid
   public void updateCentroid() {
	  int size=this.points.size();
	  if(size==0) {
		  return;
	  }
      int dim=this.centroid.getDim();
      double[] updateArr=new double[dim];
      Arrays.fill(updateArr,new Double(0));
	  for (int i=0; i!=dim; i++) {
		  for(int j=0;j!=size;j++) {
			  updateArr[i]+=this.points.get(j).getCoordinateI(i);
		  }
		 this.centroid.setCoordinateI(i,updateArr[i]/size); 
	  }
	  
   }
   
   //calculate the total distance from the centroid to all points in the cluster
   public double totalDistance() {
	   int size=this.points.size();
	   double dis=0;
	   for (int i=0; i!=size; i++) {
			dis+=this.centroid.distance(points.get(i));
		  }
	   return dis;
   }
   
   //clean all the points in the cluster
   public void clear() {
	   this.points.clear();
   }
   
   
   //print all the points in the cluster
   public void plot(boolean point) {
	   System.out.println("The cluster is "+ this.ID);
	   System.out.println("It has "+this.points.size()+" points inside");
	   System.out.println("The centroid for the cluster is "+ this.centroid.getCoordinateI(0)+","+ this.centroid.getCoordinateI(0));
	   if(point==true)
	   for(Point p : points) {
		   System.out.println("The point for the cluster is "+ p.getCoordinateI(0)+","+ p.getCoordinateI(1));
		}
   }
   
   public static void main (String []args) {
	     Point p=new Point(new double[]  {0,0},0);
		 Cluster c=new Cluster(p);
		 Point p1=new Point(new double[] {1,0},1);
		 Point p2=new Point(new double[] {2,0},2);
		 Point p3=new Point(new double[] {4,3},2);
		 c.add(p1);
	 	 c.add(p2);
	 	 c.add(p3);
		 c.plot(false);
   }
}
