package project1;

import junit.framework.TestCase;

public class Test_Kmeans extends TestCase {
	 public void test_Init() {
		 Kmeans KM=new Kmeans();
		 KM.init();
		 
		 assertEquals(KM.allClusters.size(),500);
		 assertEquals(KM.allClusters.get(0).getCentroid().getID(),0);
		 assertEquals(KM.allPoints.get(100).getID(),0);
		 assertEquals(KM.allPoints.get(1).getCoordinateI(0),0.0);
		 assertEquals(KM.allPoints.get(1).getCoordinateI(1),1.0);
		 assertEquals(KM.allPoints.get(100).getCoordinateI(1),0.0);
		 assertEquals(KM.allPoints.get(101).getPointID(),101);
		 assertEquals(KM.allPoints.get(0).getPointID(),0);
	 }
}


