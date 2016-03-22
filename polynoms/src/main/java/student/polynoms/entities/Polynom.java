package student.polynoms.entities;

import java.util.ArrayList;

public class Polynom {
	public ArrayList<CoeffDegree> p1 = new ArrayList<CoeffDegree>();

	public Polynom() {
	}

	public Polynom(String read) {
		textParsing(read);
	}

	public void textParsing(String read) {

		String[] mono;
		String[] parts;
		String[] first;
		String pieces="";
		float coefficient = 0;
		int degreePol = 0;
		first=read.split("[-]");
		int i=0;
		for (String w:first)
		{
			if (i==0){
			pieces+= w;
			i++;}
			else pieces+="+-"+ w;
		}
		mono=pieces.split("[+]");
		for (String x : mono) {
			if (x.equals(""))
				continue;
			parts = x.split("[x^]");
			int index = 0;
			for (String y : parts) {
				if (y.equals(""))
					continue;
				if (index == 0) {
					coefficient = Integer.parseInt(y);
					index++;
				} else {
					degreePol = Integer.parseInt(y);
					index = 0;
					p1.add(new CoeffDegree(coefficient, degreePol));
				}

			}
		}
	}
}
