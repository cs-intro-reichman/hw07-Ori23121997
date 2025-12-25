/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// curve(Integer.parseInt(args[0]),
		// 	  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		//       Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		

		
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n==0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}

		double px1 = x1 + (x2-x1)/3;
		double px2 = x2 -(x2-x1)/3;
		double py1 = y1 + (y2-y1)/3;
		double py2 = y2 - (y2-y1)/3;

		double c = Math.sqrt(3)/6;
		double p3x = c * (y1-y2)+((x1+x2)/2);
		double p3y = c * (x2-x1) + ((y1+y2)/2); 

		curve(n-1, x1, y1, px1, py1);

		curve(n-1, px2, py2, x2, y2);

		curve(n-1, px1, py1, p3x, p3y);

		curve(n-1, p3x, p3y, px2, py2);

	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		 double x1 = 0.1 , y1 = 0.35;
		 double x2 = 0.9 , y2 = 0.35;

		 double side = x2 -x1;
		 double hight = side * Math.sqrt(3)/2;

		 double x3 = 0.55;
		 double y3 = y1+ hight;
		curve(n-1, x3, y3, x2, y2);

		curve(n-1, x2, y2, x1, y1);

        curve(n-1, x1, y1, x3, y3);
	}
}
