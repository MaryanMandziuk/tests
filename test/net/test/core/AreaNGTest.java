/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.test.core;

import java.awt.Point;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author maryan
 */
public class AreaNGTest {

    public AreaNGTest() {
    }

    /**
     * Test of getSize method, of class Area.
     */
    @Test
    public void testArea() {
        System.out.println("testArea");
        Area area = new Area();
        Line line1 = new Line(new Point(1, 0), new Point(2, 4));
        Line line2 = new Line(new Point(0, 2), new Point(4, 1));
        Line line3 = new Line(new Point(1, 3), new Point(7, 6));
        Line line4 = new Line(new Point(3, 3), new Point(3, 5));
        Line line5 = new Line(new Point(7, 6), new Point(6, 9));
        assertFalse(area.getSize() == 4, "incorrect area lines size");
        area.add(line1);
        area.add(line2);
        area.add(line3);
        area.add(line4);
        assertTrue(area.getSize() == 4, "incorrect area lines size");
        assertTrue(area.contains(line3));
        assertFalse(area.contains(line5));

        List<Line> lines = area.getLines();
        assertEquals(lines.size(), 4);
        
        area.sort();

        List<Line> lines1 = area.getLines();
        assertEquals(lines1.size(), 3);
        assertTrue(lines1.get(1).p1.x <= lines1.get(2).p1.x);
        assertFalse(lines1.get(0).p1.x > lines1.get(1).p1.x);
        assertTrue(lines.get(1).p1 == lines1.get(1).p1);
        assertTrue(lines.get(1).p2.y == 6);
        
    }

}
