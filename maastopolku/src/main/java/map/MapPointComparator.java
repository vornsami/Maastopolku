/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.Comparator;

/**
 *
 * @author Sami
 */
public class MapPointComparator implements Comparator {

    @Override
    public int compare(Object t, Object t1) {
        return (int) ((((MapPoint) t).distanceScore * 10) - (((MapPoint) t1).distanceScore) * 10); // kerrotaan kymmenella erottaaksemme pienet erot
    }
    
    public int compare(MapPoint mp, MapPoint mp1) {
        return (int) (mp.distanceScore - mp1.distanceScore);
    }
    
}
