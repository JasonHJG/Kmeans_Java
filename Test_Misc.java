package project1;

import junit.framework.TestCase;

public class Test_Misc extends TestCase {
	 public void test_RandVec() {
		 int []limit=new int[] {99,99};
		 double[] bound=Misc.randVec(limit);
		 assert(bound[0]<99);
		 assert(bound[1]<99); 	 
	 }
	 
}
