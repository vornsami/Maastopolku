/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import functions.AStar;
import functions.BellmanFord;
import functions.Dijkstra;
import java.util.List;
import map.MapHandler;
import map.MapPoint;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import systems.Tester;

/**
 *
 * @author Sami
 */
public class PolkuTest {
    
    public PolkuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void mapPointWorks() {
     
        MapPoint point = new MapPoint(0.0, 0.0);
        
        assertEquals(0.0, point.getCoordinates()[0], 0);
        assertEquals(0.0, point.getCoordinates()[1], 0);
        
        assertEquals(true, point.trySetDistance(1.1));
        assertEquals(1.1, point.getDistance(), 0);
        
        assertEquals("0.0;0.0, distance: 1.1", point.toString());
        
        MapPoint nextPoint = new MapPoint(1.0, 1.0, point);
        
        assertEquals(point, nextPoint.getPrevious());
        assertEquals(true, nextPoint.hasPrevious());
        assertEquals(false, point.hasPrevious()); 
    }
    
    @Test
    public void mapHandlerWorks() {
        MapHandler map = new MapHandler();
        
        assertTrue(!map.loadMap("||"));
        assertTrue(!map.loadMap(";;"));
        assertTrue(!map.loadMap("\\\\"));
        
        assertTrue(map.loadMap("map1"));
        
        assertEquals(10, map.distance(10.0, 0.0, 20.0, 0.0), 0);
        assertEquals(20, map.distance(10.0, 0.0, 30.0, 0.0), 0);
        assertEquals(47.2, map.distance(10, 0.0, 57.2, 0.0), 0);
        assertEquals(0, map.distance(10.0, 0.0, 10.0, 0.0), 0);
        
        assertEquals(5, map.distance(10.0, 0.0, 14.0, 3.0), 0);
    }
    @Test(timeout = 10000)
    public void dijkstraWorks() {
        MapHandler map = new MapHandler();
        Dijkstra dijkstra = new Dijkstra();
        
        assertTrue(dijkstra.findPath(8.0, 6.0, 8.0, 54.0, map, 1) == null);
        map.loadMap("map1");
        List<MapPoint> results = dijkstra.findPath(8.0, 6.0, 8.0, 54.0, map, 1);
        
        assertEquals(57.94112549695426, results.get(results.size() - 1).getDistance(), 0);
    }
    @Test(timeout = 10000)
    public void aStarWorks() {
        MapHandler map = new MapHandler();
        AStar aStar = new AStar();
        
        assertTrue(aStar.findPath(8.0, 6.0, 8.0, 54.0, map, 1) == null);
        map.loadMap("map1");
        List<MapPoint> results = aStar.findPath(8.0, 6.0, 8.0, 54.0, map, 1);
        
        assertEquals(57.94112549695426, results.get(results.size() - 1).getDistance(), 0);
    }
    @Test(timeout = 10000)
    public void bellmanFordWorks() {
        MapHandler map = new MapHandler();
        BellmanFord bf = new BellmanFord();
        
        assertTrue(bf.findPath(8.0, 6.0, 8.0, 54.0, map, 1) == null);
        map.loadMap("map1");
        List<MapPoint> results = bf.findPath(8.0, 6.0, 8.0, 54.0, map, 1);
        
        assertEquals(57.94112549695426, results.get(results.size() - 1).getDistance(), 0);
    }
    @Test(timeout = 10000)
     public void testsWork() {
        Tester tester = new Tester();
        tester.test();
    }
}
