import java.awt.geom.Line2D;

public class SpaceEfficiency {

	public static void main(String[]args) {

		int[][]given1 = {{5,0},{12,13},{5,0},{2,15}};
		int width1 = 11, height1 = 10;
		System.out.println(solution(given1, width1, height1));

		int[][]given2 = {{2,2},{8,2},{8,2},{8,8},{8,8},{2,8},{2,8},{2,2}};
		int width2 = 10, height2 = 10;
		System.out.println(solution(given2, width2, height2));

		int[][]given3 = {{3,2},{7,8},{3,8},{7,1}};
		int width3 = 10, height3 = 10;
		System.out.println(solution(given3, width3, height3));

	}

	private static boolean solution(int[][]array, int width, int height) {

		//create the rectangle
		Line2D bottomLine = new Line2D.Double(0, 0, width, 0);
		Line2D topLine = new Line2D.Double(0, height, width, height);
		Line2D leftLine = new Line2D.Double(0, 0, 0, height);
		Line2D rightLine = new Line2D.Double(0, width, width, height);

		//check if a line segment touches from end to end, up & bottom, left & right
		for(int i = 0; i < array.length; i += 2) {
			
			double x1 = array[i][0];
			double y1 = array[i][1];
			double x2 = array[i+1][0];
			double y2 = array[i+1][1];

			Line2D line = new Line2D.Double(x1, y1, x2, y2);
			if((line.intersectsLine(bottomLine) && line.intersectsLine(topLine)) ||
			   (line.intersectsLine(leftLine) && line.intersectsLine(rightLine))) {
				return true;
			}
		}
		
		//check if the lines inside form a enclosed shape
		return checkEnclosed(array);
	}

	private static boolean checkEnclosed(int[][]array) {
		//a enclosed shape needs atleast 3 line segments
		if(array.length < 6) return false;

		for(int i = 0; i < array.length; i += 2) {
			
			//compare x2 and y2 to the next x1 and y1 to check if its connected
			double x1, y1, x2, y2;
			if(i != array.length-2) {
				x1 = array[i+2][0];
				y1 = array[i+2][1];
				x2 = array[i+1][0];
				y2 = array[i+1][1];
			} else {
				x1 = array[0][0];
				y1 = array[0][1];
				x2 = array[array.length-1][0];
				y2 = array[array.length-1][1];
			}
			//if they are not equal meaning its not connected and return false
			if(!((x2 == x1) && (y2 == y1))) {
				return false;
			}	
		}
		return true;
	}	

}