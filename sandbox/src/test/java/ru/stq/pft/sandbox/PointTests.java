package ru.stq.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Valkyrja on 24.09.2016.
 */
public class PointTests {

  @Test
  public void testPoint() {
    Point p1 = new Point(3, 4);
    Point p2 = new Point(0, 0);

    Assert.assertEquals(p1.distance(p2), 5.0);
  }

  @Test
  public void testPoint1() {
    Point p1 = new Point(-1, -2);
    Point p2 = new Point(2, 2);

    Assert.assertEquals(p1.distance(p2), 5.0);
  }
}

