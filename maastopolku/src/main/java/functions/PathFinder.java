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
    public List<MapPoint> findPath(double x1,double y1,double x2,double y2,MapHandler map, int unit);
}
