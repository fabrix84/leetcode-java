package LeetCode;

import java.util.*;

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
}

public class MaxPointsOnLine {
	public static int maxPoints(Point[] points) {
		if(points.length==0) return 0;
		if(points.length==1) return 1;
		if(points.length==2) return 2;
		int max = 2;
		for(int i=0;i<points.length;i++) {
			int dup = 1;
			Map<Double,Integer> slopes = new HashMap<Double,Integer>();
			slopes.put(Double.MIN_VALUE, 0);
			for(int j=0;j<points.length;j++) {
				if(i==j) continue;
				else if(points[i].x==points[j].x && points[i].y==points[j].y) {
					//System.out.println("Add dup "+points[i]+" i:"+i+" j:"+j);
					dup++;
					continue;
				}
				//System.out.println("("+points[i].y+"-"+points[j].y+")/("+points[i].x+"-"+points[j].x+")="+(points[i].y-points[j].y)/(points[i].x-points[j].x));
				double slope = (points[i].x-points[j].x==0)? Double.MAX_VALUE : (points[i].y*1.0-points[j].y)/(points[i].x-points[j].x);
				if(slopes.containsKey(slope)) {
					//System.out.println("add slope +1 i:"+i+" j:"+j);
					slopes.put(slope, slopes.get(slope)+1);
				}
				else {
					//System.out.println("put slope 1 i:"+i+" j:"+j);
					slopes.put(slope, 1);
				}
				//System.out.println(slopes);
			}
			for(Double k: slopes.keySet()) {
				if(slopes.get(k)+dup>max) {
					//System.out.println("Max i:"+i+" max:"+max+" Val:"+ slopes.get(k)+" Dup:"+dup);
					max = slopes.get(k)+dup;
				}
			}
		}
		return max;
	}
	public static boolean aligned(Point l1, Point l2, Point p) {
		// Ax * (By - Cy) + Bx * (Cy - Ay) + Cx * (Ay - By) < epsilon;
		//System.out.println(l1+" "+l2+" "+p);
		//System.out.println(l1.x+" * ("+l2.y+" - "+p.y+") + "+l2.x+" * ("+p.y+" - "+l1.y+") + "+p.x+" * ("+l1.y+" - "+l2.y+")");
		//System.out.println("Area="+(l1.x * (l2.y - p.y) + l2.x * (p.y - l1.y) + p.x * (l1.y - l2.y)));
		return (Math.abs(l1.x * (l2.y - p.y) + l2.x * (p.y - l1.y) + p.x * (l1.y - l2.y)) < 0.000001)? true : false;
	}
	public static void main(String[] args) {
		Point p1 = new Point(84,250);
		Point p2 = new Point(0,0);
		Point p3 = new Point(1,0);
		Point p4 = new Point(0,-70);
		Point p5 = new Point(0,-70);
		Point p6 = new Point(1,-1);
		Point p7 = new Point(21,10);
		Point p8 = new Point(42,90);
		Point p9 = new Point(-42,-230);
		//Point p4 = new Point(2,2);
		Point[] points = {p1,p2,p3,p4,p5,p6,p7,p8,p9};
		/*
		Point p1 = new Point(0,9);
		Point p2 = new Point(138,429);
		Point p3 = new Point(115,359);
		Point p4 = new Point(115,359);
		Point p5 = new Point(-30,-102);
		Point p6 = new Point(230,709);
		Point p7 = new Point(-150,-686);
		Point p8 = new Point(-135,-613);
		Point p9 = new Point(-60,-248);
		Point p10 = new Point(-161,-481);
		Point p11 = new Point(207,639);
		Point p12 = new Point(23,79);
		Point p13 = new Point(-230,-691);
		Point p14 = new Point(-115,-341);
		Point p15 = new Point(92,289);
		Point p16 = new Point(60,336);
		Point p17 = new Point(-105,-467);
		Point p18 = new Point(135,701);
		Point p19 = new Point(-90,-394);
		Point p20 = new Point(-184,-551);
		Point p21 = new Point(150,774);
		Point[] points = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21};
		*/
		System.out.println(maxPoints(points));
		//System.out.println(aligned(p1,p2,p3));
	}
}
