import java.util.*;

public class Hashing {

	public static void main(String args[]) {
		// Create a hash map
		Hashtable grade = new Hashtable();
		Enumeration names;
		String str;
		double gr;

		grade.put("Pratyush", new Double(7.1));
		grade.put("Sarthak", new Double(7.8));
		grade.put("Virani", new Double(7.4));
		grade.put("Yuvraj", new Double(7.3));
		names = grade.keys();
		while (names.hasMoreElements()) {
			str = (String) names.nextElement();
			System.out.println(str + ": " + grade.get(str));
		}
		System.out.println();
		gr = ((Double) grade.get("Sarthak")).doubleValue();
		grade.put("Sarthak", new Double(gr + 0.11));
		System.out.println("Updated");
		System.out.println("Sarthak : "+grade.get("Sarthak"));
	}
}
