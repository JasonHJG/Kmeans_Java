package project1;

import junit.framework.TestCase;

public class Test_Cluster extends TestCase {

	 public void test_PrintID() {
		 Point p=new Point(new double[] {1,2},1);
	   	  Cluster c=new Cluster(p);
	   	 assertEquals(c.getID(), 1);
	 }
	 
	 
	 //do not need to change the equal function here, since 
	 //even two centroid overlap, they are since considered as 
	 //two distinct entities
	 public void test_GetCentroid() {
		 Point p=new Point(new double[] {1,2},0);
	   	  Cluster c=new Cluster(p);
	   	assertEquals(c.getCentroid(), p);
	 }
	 
	 public void test_SetID() {
		Point p=new Point(new double[] {1,2},0);
	   	Cluster c=new Cluster(p);
	   	c.setID(2);
	   	assertEquals(c.getID(), 2);
	   	
	 }
	 
	 public void test_SetCentroid() {
		Point p=new Point(new double[] {1,2},0);
	   	Point p1=new Point(new double[] {1,2},0);
	   	Cluster c=new Cluster(p);
	   	c.setCentroid(p1);
	   	assertEquals(c.getCentroid(), p1);
	 }
	 
	
	 
	 public void test_Add() {
		 Point p=new Point(new double[] {1,2},0);
		 Point p1=new Point(new double[] {1,3},1);
		 Point p2=new Point(new double[] {1,4},2);
	 	Cluster c=new Cluster(p);
	 	c.add(p1);
	 	c.add(p2);
	 	assertEquals(c.points.get(0).getID(), 1);
	 	assertEquals(c.points.get(1).getID(), 2);
	 }
	 
	 public void test_UpdateCentroid() {
		 Point p=new Point(new double[] {0,0,1},0);
		 Point p1=new Point(new double[] {2,4,1},1);
		 Point p2=new Point(new double[] {2,4,1},2);
		 Point p3=new Point(new double[] {5,4,1},2);
	 	 Cluster c=new Cluster(p);
	 	 c.add(p1);
	 	 c.add(p2);
	 	 c.add(p3);
	 	 c.updateCentroid();
	 	assertEquals(c.getCentroid().getCoordinateI(0),3.0 );
	 	assertEquals(c.getCentroid().getCoordinateI(1),4.0 );
	 	assertEquals(c.getCentroid().getCoordinateI(2),1.0 );
	 }
	 
	 
	 
	 public void test_TotalDistance() {
		 Point p=new Point(new double[]  {0,0},0);
		 Point p1=new Point(new double[] {1,0},1);
		 Point p2=new Point(new double[] {2,0},2);
		 Point p3=new Point(new double[] {4,3},2);
	 	 Cluster c=new Cluster(p);
	 	 c.add(p1);
	 	 c.add(p2);
	 	 c.add(p3);
	 	assertEquals(c.totalDistance(), 8.0);
	 	
	 }
	 
	 public void test_GetSize(){
		 Point p=new Point(new double[]  {0,0},0);
		 Point p1=new Point(new double[] {1,0},1);
		 Point p2=new Point(new double[] {2,0},2);
		 Point p3=new Point(new double[] {4,3},2);
		 Cluster c=new Cluster(p);
	 	 c.add(p1);
	 	 c.add(p2);
	 	 c.add(p3);
	 	 assertEquals(c.getSize(),3);
		 
	 }
	 
	 public void test_Clear(){
		 Point p=new Point(new double[]  {0,0},0);
		 Point p1=new Point(new double[] {1,0},1);
		 Point p2=new Point(new double[] {2,0},2);
		 Point p3=new Point(new double[] {4,3},2);
		 Cluster c=new Cluster(p);
	 	 c.add(p1);
	 	 c.add(p2);
	 	 c.add(p3);
	 	 c.clear();
	 	 assertEquals(c.getSize(),0);
		 
	 }
	 
	 
}
