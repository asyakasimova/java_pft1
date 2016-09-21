package ru.stq.pft.sandbox;

/**
 * Created by A.Kasimova on 21.09.2016.
 */
public class Point {
  public double x;
  public double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public double distance( Point p2){
    double distance;
    return Math.sqrt((this.x - p2.x) * (this.x - p2.x) + (this.y - p2.y) * (this.y - p2.y));
  }

}
