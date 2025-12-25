/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		double x1 = 0.0 , y1 = 0.0;
		double x2 = 1.0 , y2 = 0.0;
		double x3 = 0.5 , y3 = Math.sqrt(3)/2;
		StdDraw.setPenColor(StdDraw.BLACK);
		double [] x = {x1,x2,x3};
		double [] y = {y1,y2,y3};
		StdDraw.filledPolygon(x, y);
		sierpinski(n, x1, x2, x3, y1, y2, y3);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n == 0) {
			return;
		}

		
		double x12 = (x1+x2)/2;
		double x13 = (x1+x3)/2;
		double x23 = (x2+x3)/2;
		
		double y12 = (y1+y2)/2;
		double y13 = (y1 +y3)/2;
		double y23 = (y2 +y3)/2;

		StdDraw.setPenColor(StdDraw.WHITE);
		double [] x ={x12,x13,x23};
		double [] y ={y12,y13,y23};
		
		StdDraw.filledPolygon(x, y);

		sierpinski(n-1,x1,x12,x13,y1,y12,y13);

		sierpinski(n-1,x2,x12,x23,y2,y12,y23);

		sierpinski(n-1,x3,x13,x23,y3,y13,y23);
	}
}
