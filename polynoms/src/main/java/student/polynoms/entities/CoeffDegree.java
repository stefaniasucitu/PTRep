package student.polynoms.entities;

public class CoeffDegree {
	private float coeff;
	int degree;
	
	
	public CoeffDegree(float c, int d){
		this.coeff=c;
		this.degree=d;
	}
	
public float getCoeff(){
	return  this.coeff;
}	
 public int getDegree(){
	 return this.degree;
	  }
 
 public int setDegree(int degree){
	 	this.degree=degree;
	 	return this.degree;
 }

 
 public float setCoeff(float coeff){
	 	this.coeff=coeff;
	 	return this.coeff;
 }
	
}
