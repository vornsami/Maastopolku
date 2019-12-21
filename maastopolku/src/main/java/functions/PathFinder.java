/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.util.List;
import map.MapHandler;
import map.MapPoint;

/**
 *
 * @author Sami
 */
public interface PathFinder {

    /**
     * Finds the shortest path between points 1 and 2
     *
     * @param x1 x coordinate of point 1
     * @param y1 y coordinate of point 1
     * @param x2 x coordinate of point 2
     * @param y2 y coordinate of point 2
     * @param map map to be searched
     * @param unit the distance between points searched
     * 
     * @return returns a list containing the points of the shortest path in order.
     */
    public List<MapPoint> findPath(double x1, double y1, double x2, double y2, MapHandler map, int unit);

    /**
     *
     * @return Returns all points the algorithm created
     */
    public MapPoint[][] getVisited();

    /**
     *
     * @return Returns amount of points visited
     */
    public long getVisitCount();

    /**
     *
     * @return Returns algorithms name
     */
    public String getName();
}
