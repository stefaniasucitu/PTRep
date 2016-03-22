package student.polynoms;
//import java.util.ArrayList;

import student.polynoms.entities.CoeffDegree;
import student.polynoms.entities.Polynom;

//import java.util.Collections;

public class Operation extends CoeffDegree {

	public Operation(int c, int d) {
		super(c, d);
		// TODO Auto-generated constructor stub
	}

	private static Polynom orderPolynom(Polynom pol) {
		CoeffDegree aux = new CoeffDegree(0, 0);
		for (int i = 0; i < pol.p1.size() - 1; i++) {
			if (pol.p1.get(i).getDegree() < pol.p1.get(i + 1).getDegree()) {
				aux = pol.p1.get(i);
				pol.p1.get(i).setDegree(pol.p1.get(i + 1).getDegree());
				pol.p1.get(i).setCoeff(pol.p1.get(i + 1).getCoeff());
				pol.p1.get(i + 1).setDegree(aux.getDegree());
				pol.p1.get(i + 1).setCoeff(aux.getCoeff());
			}
		}
		return pol;
	}

	public static Polynom addPolynoms(Polynom poly1, Polynom poly2) {
		Polynom result = new Polynom();

		int j = 0;
		for (int i = 0; i < poly1.p1.size(); i++) {
			if (poly1.p1.get(i).getDegree() == poly2.p1.get(j).getDegree()) {
				result.p1.add(new CoeffDegree((poly1.p1.get(i).getCoeff() + poly2.p1.get(j).getCoeff()),
						(poly1.p1.get(i).getDegree())));
				j++;
			}
			else if (poly1.p1.get(i).getDegree() < poly2.p1.get(j).getDegree()) {
				i++;
				result.p1.add(new CoeffDegree(poly2.p1.get(j).getCoeff(), poly2.p1.get(j).getDegree()));
			} 
			else if (poly1.p1.get(i).getDegree() > poly2.p1.get(j).getDegree()) {
				result.p1.add(new CoeffDegree(poly1.p1.get(i).getCoeff(), poly1.p1.get(i).getDegree()));
			}
		}

		for (int i = j; i < poly2.p1.size(); i++) {
			result.p1.add(new CoeffDegree(poly2.p1.get(j).getCoeff(), poly2.p1.get(j).getDegree()));
		}
		result = orderPolynom(result);
		return result;
	}

	public static Polynom substractPolynoms(Polynom poly1, Polynom poly2) {
		Polynom result = new Polynom();
		int j = 0;
		for (int i = 0; i < poly1.p1.size(); i++) {

			if (poly1.p1.get(i).getDegree() == poly2.p1.get(j).getDegree()) {
				result.p1.add(new CoeffDegree((poly1.p1.get(i).getCoeff() - poly2.p1.get(j).getCoeff()),
						(poly1.p1.get(i).getDegree())));
				j++;
			} else if (poly1.p1.get(i).getDegree() < poly2.p1.get(j).getDegree()) {
				i--;
				result.p1.add(new CoeffDegree(((poly2.p1.get(j).getCoeff())), poly2.p1.get(j).getDegree()));
			} else if (poly1.p1.get(i).getDegree() > poly2.p1.get(j).getDegree()) {
				result.p1.add(new CoeffDegree(poly1.p1.get(i).getCoeff(), poly1.p1.get(i).getDegree()));
			}
		}
		for (int i = j; i < poly2.p1.size(); i++) {
			result.p1.add(new CoeffDegree(poly2.p1.get(j).getCoeff(), poly2.p1.get(j).getDegree()));
		}
		result = orderPolynom(result);
		return result;
	}

	public static Polynom multiplyPolynoms(Polynom poly1, Polynom poly2) {
		Polynom result = new Polynom();
		for (CoeffDegree p1 : poly1.p1) {
			for (CoeffDegree p2 : poly2.p1) {
				result.p1.add(new CoeffDegree((p1.getCoeff() * p2.getCoeff()), ((p1.getDegree() + p2.getDegree()))));
			}
		}
		result = orderPolynom(result);
		for (int i = 0; i < result.p1.size() - 1; i++) {

			if (result.p1.get(i).getDegree() == result.p1.get(i + 1).getDegree()) {
				result.p1.get(i).setCoeff(result.p1.get(i).getCoeff() + result.p1.get(i + 1).getCoeff());
				result.p1.remove(i + 1);
			}
		}
		return result;
	}

	public static Polynom dividePolynoms(Polynom poly1, Polynom poly2) {
		Polynom result = new Polynom();
		for (CoeffDegree p1 : poly1.p1) {
			for (CoeffDegree p2 : poly2.p1) {
				result.p1.add(new CoeffDegree((p1.getCoeff() / p2.getCoeff()), ((p1.getDegree() / p2.getDegree()))));
			}
		}

		result = orderPolynom(result);
		for (int i = 0; i < result.p1.size() - 1; i++) {

			if (result.p1.get(i).getDegree() == result.p1.get(i + 1).getDegree()) {
				result.p1.get(i).setCoeff(result.p1.get(i).getCoeff() + result.p1.get(i + 1).getCoeff());
				result.p1.remove(i + 1);
			}
		}
		return result;
	}

	public static Polynom differentiatePolynoms(Polynom poly1) {
		Polynom result = new Polynom();

		for (CoeffDegree x : poly1.p1) {
			result.p1.add(new CoeffDegree(x.getCoeff() * x.getDegree(), (x.getDegree() - 1)));
		}
		return result;
	}

	public static Polynom integratePolynoms(Polynom poly1) {
		Polynom result = new Polynom();

		for (CoeffDegree x : poly1.p1) {
			result.p1.add(new CoeffDegree(x.getCoeff() / ((x.getDegree() + 1)), (x.getDegree() + 1)));
		}
		return result;
	}
}
