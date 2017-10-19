package project1;

import junit.framework.TestCase;

public class Test_Point extends TestCase {
        public Test_Point() {
        	double[] coordinate;
        coordinate = new double[] {10,20};
        	 int cluster=1;
        	 Point p=new Point(coordinate,cluster);
        }
       
        public void test_GetCoordinate() {
        		double[] coordinate;
            coordinate = new double[] {10,20};
            	int cluster=1;
            	Point p=new Point(coordinate,cluster);
            	assertEquals(p.getCoordinateI(0), 10.0);
            	assertEquals(p.getCoordinateI(1), 20.0);
        }
      
        public void test_SetCoordinateI() {
          	double[] coordinate;
            coordinate = new double[] {10,20};
            	int cluster=1;
            	Point p=new Point(coordinate,cluster);
            	p.setCoordinateI(1, 50);
            	assertEquals(p.getCoordinateI(1), 50.0);
        }
        
        public void test_GetID() {
        	    double[] coordinate;
            coordinate = new double[] {10,20};
            	int cluster=1;
            	Point p=new Point(coordinate,cluster);
            	assertEquals(p.getID(), 1);
        }
        
        
        public void test_SetID() {
        	     double[] coordinate;
             coordinate = new double[] {10,20};
             int cluster=1;
             Point p=new Point(coordinate,cluster);
             p.setID(5);
             assertEquals(p.getID(), 5);
             
        }
        
        public static void test_Distance() {
        	     
             Point p1=new Point(new double[] {0,0}, 1);
             Point p2=new Point(new double[] {0,0}, 2);
             Point p3=new Point(new double[] {3,4}, 2);
             assertEquals(p1.distance(p2),0.0);
             assertEquals(p1.distance(p3),5.0);
             
        }
        
        
		
}
