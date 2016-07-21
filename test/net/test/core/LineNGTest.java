/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.test.core;

import java.awt.Point;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author maryan
 */
public class LineNGTest {
    
    public LineNGTest() {
    }

    
    @Test
    public void testLine() {
        System.out.println("test Line");
        Line test1 = new Line(new Point(1,2), new Point(5, 10));
        assertEquals(test1.p1, new Point(1,2), "points are not equal");
        assertTrue(test1.p1.x < test1.p2.x, "point p1 x coordinate bigger then point p2 x");
        assertTrue(test1.p1.y < test1.p2.y, "point p1 y coordinate bigger then point p2 y");
    }
    /**
     * Test of addIntersection method, of class Line.
     */
    @Test
    public void testAddIntersection() {
        System.out.println("addIntersection");
        Line line1 = new Line(new Point(1,2), new Point(5,2));
        Line line2 = new Line(new Point(4,1), new Point(4,5));
        line1.addIntersection(line2);
        assertTrue(line1.getIntersections().size() == 1, "intersection list has incorrect size");
    }

    /**
     * Test of isVertical method, of class Line.
     */
    @Test
    public void testIsVertical() {
        System.out.println("isVertical");
        Line line1 = new Line(new Point(1,2), new Point(5,2));
        Line line2 = new Line(new Point(4,1), new Point(4,5));

        assertEquals(line1.isVertical(), false, "line must not be vertical");
        assertEquals(line2.isVertical(), true, "line must be vertical");
        assertFalse(line1.isVertical(), "line must not be vertical");
        
    }

    /**
     * Test of isHorizontal method, of class Line.
     */
    @Test
    public void testIsHorizontal() {
        System.out.println("isHorizontal");
        Line line1 = new Line(new Point(50,30), new Point(92,66));
        Line line2 = new Line(new Point(3,3), new Point(12,3));
        Line line3 = new Line(new Point(50,30), new Point(92,30));
        assertEquals(line1.isHorizontal(), false, "line must not be horizontal");
        assertEquals(line2.isHorizontal(), true, "line must be horizontal");
        assertFalse(line1.isHorizontal(), "line must not be horizontal");
        assertNotEquals(line1.isHorizontal(), line3.isHorizontal());    
    }
        

    /**
     * Test of getIntersections method, of class Line.
     */
    @Test
    public void testGetIntersections() {
        System.out.println("getIntersections");
        Line line1 = new Line(new Point(1,2), new Point(5,2));
        Line line2 = new Line(new Point(4,1), new Point(4,5));
        Line line3 = new Line(new Point(32,11), new Point(2,2));
        assertEquals(line1.getIntersections().size(), 0);
        line1.addIntersection(line3);
        line1.addIntersection(line2);
        assertEquals(line1.getIntersections().size(), 2);
    }
    
    /**
     * Test unmodifiable list, of class Line.
     */
    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testGetIntersectionsUnmodifiableList() {
        System.out.println("getIntersections");
        Line line1 = new Line(new Point(1,2), new Point(5,2));
        Line line2 = new Line(new Point(32,11), new Point(2,2));
        line1.addIntersection(line2);
        List<Line> list = line1.getIntersections();
        list.add(line2);
    }

    /**
     * Test of getIntersection method, of class Line.
     */
    @Test
    public void testGetIntersection() {
        System.out.println("getIntersection");
        Line line1 = new Line(new Point(1, 0), new Point(2,4));
        Line line2 = new Line(new Point(0, 2), new Point(4,1));
        
        assertEquals(line1.getIntersection(line2), null);
        
        Line line3 = new Line(new Point(1, 3), new Point(7,3));
        Line line4 = new Line(new Point(3, 3), new Point(3, 5));
        
        assertEquals(line3.getIntersection(line4), new Point(3,3));
        assertEquals(line4.getIntersection(line3), new Point(3,3));
    }

    /**
     * Test of isIntersect method, of class Line.
     */
    @Test
    public void testIsIntersect() {
        System.out.println("isIntersect");
        Line line1 = new Line(new Point(1, 0), new Point(2,4));
        Line line2 = new Line(new Point(0, 2), new Point(4,1));
        Line line3 = new Line(new Point(1, 3), new Point(7,3));
        Line line4 = new Line(new Point(3, 3), new Point(3, 5));
        assertFalse(line1.isIntersect(line2));
        assertTrue(line4.isIntersect(line3));
    }
    
}
