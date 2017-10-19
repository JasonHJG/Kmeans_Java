package project1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Kmeans {
	final double  MAXDIS=200;
	final static int MAXROUND=100;
	final int  NUMBEROFCLUSTERS=500;
	final int  SPACE=100;
	final int THRESHOLD=19;
	final static double TOL=0.01;
	boolean verbose=false;
	protected double loss;
	public  ArrayList<Point> allPoints;
	public  ArrayList<Cluster> allClusters;
    int[] GRID=new int[] {SPACE-1,SPACE-1};

   
	
	public Kmeans() {
    	     this.loss=0;
    	     this.allPoints=new ArrayList<Point>(SPACE*SPACE);
    	     this.allClusters=new ArrayList<Cluster>(NUMBEROFCLUSTERS);
    }
	
	
	//initiate all a cluster of all the points
	//the points have correct coordinate, but not cluster number
	//initiate all the clusters
	//the cluster center are assigned to a random number
	//cluster 0-499
	public void init() {
		for(int i=0;i!=SPACE;i++) {
			for(int j=0; j!=SPACE;j++) {
				Point one=new Point(new double[] {i,j}, 0);
				one.setPointID(SPACE*i+j);
				this.allPoints.add(one);
			}
		}
		for(int i=0;i!=NUMBEROFCLUSTERS; i++) {
			
			double[] loc=Misc.randVec(GRID);
			this.allClusters.add(new Cluster(new Point(loc, i)));
		}
		
	}
	
	
	//set the class ID for each group
	//for each point in arraylist1
	//find its distance to each cluster by calling distance
	//so as to find the nearest cluster
	//change the ID of the point to the ID of the cluster
	//push the point into the arraylist in that cluster 
	//by finding the corresponding postion in that arraylist2
	public void group() {
		for(int i=0; i!=this.allPoints.size();i++) {
			
			double dis=MAXDIS;
			int clu_id=-1;
			for(int j=0;j!=this.allClusters.size();j++) {
				double dd=this.allPoints.get(i).distance(this.allClusters.get(j).getCentroid());
				if(dd<dis) {
					dis=dd;
					clu_id=this.allClusters.get(j).getID();
					this.allPoints.get(i).setID(clu_id);
				}
			}
			allClusters.get(clu_id).add(this.allPoints.get(i));
			
			}
		
		
	}
	
	
	//for each cluster in arraylist2, find the new centroid by calling findcentroid
	//find the loss by calling totalDis()
	//loss+=totalDis
	//update the cluster by calling setCentroid
	//remove all points from the cluster
	public double updating() {
		loss=0;
		for(int i=0;i!=this.allClusters.size();i++) {
			
			this.allClusters.get(i).updateCentroid();
			loss+=this.allClusters.get(i).totalDistance();
			this.allClusters.get(i).plot(verbose);
			this.allClusters.get(i).clear();
		}
	    for(int i=0;i!=this.allPoints.size();i++) {
	    	  this.allPoints.get(i).setState(false);
	    }
		return loss/SPACE/SPACE;
	}
	
	
	
	
	
	//for all cluster centroied
	//find the distance from the centroid to all points 
	//sort
	//take the first 20 with isOccupied=False
	//push them into the cluster
	public void group_2() {
		for(int i=0;i!=this.allClusters.size();i++) {
			
			//add the points and their dis to the centroid into list
			//sort the list based on dis
			LinkedList<Pair<Point,Double>> list = new LinkedList<Pair<Point,Double>>();
			for(int j=0;j!=this.allPoints.size();j++) {
			double dis=this.allClusters.get(i).centroid.distance(this.allPoints.get(j));
			//the pointID is copied into the linkedlist 
			Pair<Point,Double> pair = new Pair<Point,Double>(this.allPoints.get(j) , dis );
			list.add(pair);
			}
			//the actual sorting
			Collections.sort(
					list,
					new Comparator<Pair<Point,Double>>(){
						@Override
						public int compare(Pair<Point,Double> o1, Pair<Point,Double> o2) {
							return o1.getSecondObject().compareTo( o2.getSecondObject() );
						}
					}
				);
			//take the first 20
			//push them into the cluster
			for(int k=0; k!=list.size();k++) {
				
				if(this.allClusters.get(i).getSize()<=THRESHOLD) {
					
				    if(list.get(k).getFirstObject().getState()==false) {
		
				    	this.allClusters.get(i).add(list.get(k).getFirstObject());
				    	    int id=list.get(k).getFirstObject().getPointID();
				    	    this.allPoints.get(id).setState(true);
				    }
			     }
			}
			
		}
	}
	
	
	public void kMeans(int version) {
		if(version==0) {
			Kmeans KM=new Kmeans();
			KM.init();
			ArrayList<Double> error = new ArrayList<Double>();
			for(int i=0;i<MAXROUND;i++) {
				System.out.println("==========Iteration=========");
				System.out.println("=========="+(i+1)+"=========");
				KM.group();
				double err=KM.updating();
				if(i>0 && Math.abs((err-error.get(error.size()-1)))==0.0) {
					break;
				}
				error.add(err);
			}
			System.out.println("==========Method 1=========");
			System.out.println("The loss looks like: ");
			for(int i=0;i!=error.size();i++) {
				
				System.out.println("Iteration "+(i+1)+" "+error.get(i));
				
			}
		}
		
		else if(version==1) {

			Kmeans KM1=new Kmeans();
			KM1.init();
			ArrayList<Double> error1 = new ArrayList<Double>();
			for(int i=0;i<MAXROUND;i++) {
				System.out.println("==========Iteration=========");
				System.out.println("=========="+(i+1)+"=========");
				KM1.group_2();
				double err=KM1.updating();
				if(i>0 && Math.abs((err-error1.get(error1.size()-1)))<TOL) {
					error1.add(err);
					break;
				}
				error1.add(err);
			}
			System.out.println("==========Method 2=========");
			System.out.println("The loss looks like: ");
			for(int i=0;i!=error1.size();i++) {
				System.out.println("Iteration "+(i+1)+" "+error1.get(i));
				
			}
			
		}
		
	}
	
	
   //create a Kmeans object and do a testing
	public static void main(String []args) {
	
		int version=Integer.parseInt(args[0]);
		Kmeans obj=new Kmeans();
		obj.kMeans(version);
		
	}
	
}
