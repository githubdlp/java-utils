package com.dlp.java.utils;

import java.awt.geom.Point2D;

/**
 * This class checks if a given point lies inside or outside of a polygon.
 * 
 * @author dlp
 *
 */
public class PointInPolygonChecker {
	private final Point2D.Double[] polygonCordinates;

	public PointInPolygonChecker(Point2D.Double[] polygonCordinates) {
		this.polygonCordinates = polygonCordinates;
	}

	/**
	 * Checks if the point lies inside/outside of polygon. Point on the boundary
	 * of the polygon is considered as outside
	 * 
	 * @param testPoint
	 *            point in test
	 * @return true if point lies inside polygon, false otherwise
	 */
	public boolean containsByAlgorithmA(Point2D.Double testPoint) {
		boolean result = false;
		for (int i = 0, j = polygonCordinates.length - 1; i < polygonCordinates.length; j = i++) {
			if ((polygonCordinates[i].y > testPoint.y) != (polygonCordinates[j].y > testPoint.y)
					&& (testPoint.x < (polygonCordinates[j].x - polygonCordinates[i].x)
							* (testPoint.y - polygonCordinates[i].y)
							/ (polygonCordinates[j].y - polygonCordinates[i].y)
							+ polygonCordinates[i].x)) {
				result = !result;
			}
		}

		return result;
	}

	/**
	 * Checks if the point lies inside/outside of polygon. Point on the boundary
	 * of the polygon is considered as inside
	 * 
	 * @param testPoint
	 *            point in test
	 * @return true if point lies inside polygon, false otherwise
	 */
	public boolean containsByAlgorithmB(Point2D.Double testPoint) {
		boolean oddNodes = false;
		int j = polygonCordinates.length - 1;
		for (int i = 0; i < polygonCordinates.length; i++) {
			if ((polygonCordinates[i].y < testPoint.y
					&& polygonCordinates[j].y >= testPoint.y || polygonCordinates[j].y < testPoint.y
					&& polygonCordinates[i].y >= testPoint.y)
					&& (polygonCordinates[i].x <= testPoint.x || polygonCordinates[j].x <= testPoint.x)) {

				// This is the code without using precalculations
				oddNodes ^= (polygonCordinates[i].x
						+ (testPoint.y - polygonCordinates[i].y)
						/ (polygonCordinates[j].y - polygonCordinates[i].y)
						* (polygonCordinates[j].x - polygonCordinates[i].x) < testPoint.x);

				// This is the code using precalculations
				// oddNodes ^= (y * polygon.multiples[i] + polygon.constants[i]
				// < x);
			}
			j = i;
		}
		return oddNodes;
	}

	public static void main(String[] args) {
		Point2D.Double[] polygonCordinates = new Point2D.Double[4];
		// Rectangle
		polygonCordinates[0] = new Point2D.Double(1.5, -1.5);
		polygonCordinates[1] = new Point2D.Double(1.5, 1.5);
		polygonCordinates[2] = new Point2D.Double(3.5, 1.5);
		polygonCordinates[3] = new Point2D.Double(3.5, -1.5);
		PointInPolygonChecker pointInPolygonChecker = new PointInPolygonChecker(
				polygonCordinates);

		System.out.println("(1.5, 2.5) : "
				+ pointInPolygonChecker
						.containsByAlgorithmA(new Point2D.Double(1.5, 2.5)));
		System.out.println("(2.5, 1.5) : "
				+ pointInPolygonChecker
						.containsByAlgorithmA(new Point2D.Double(2.5, 1.5)));
		System.out.println("(2.5, 0.5) : "
				+ pointInPolygonChecker
						.containsByAlgorithmA(new Point2D.Double(2.5, 0.5)));

		System.out.println("\n(1.5, 2.5) : "
				+ pointInPolygonChecker
						.containsByAlgorithmB(new Point2D.Double(1.5, 2.5)));
		System.out.println("(2.5, 1.5) : "
				+ pointInPolygonChecker
						.containsByAlgorithmB(new Point2D.Double(2.5, 1.5)));
		System.out.println("(2.5, 0.5) : "
				+ pointInPolygonChecker
						.containsByAlgorithmB(new Point2D.Double(2.5, 0.5)));
	}
}
