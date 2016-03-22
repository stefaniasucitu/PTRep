package student.polynoms.tests;

import static org.junit.Assert.*;

import java.rmi.server.Operation;
import org.junit.Test;

import student.polynoms.entities.CoeffDegree;
import student.polynoms.entities.Polynom;
public class addTest {
	private Polynom result=new Polynom();
	
		
		
	
	@Test
	public void testAdd() {
		
		Operation op=new Operation(null);
		this.result.p1.add(new CoeffDegree(3,3));
		this.result.p1.add(new CoeffDegree(1,2));
		this.result.p1.add(new CoeffDegree(1,1));
		
	
	}

}
