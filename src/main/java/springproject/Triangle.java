package springproject;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.security.auth.Destroyable;
import java.util.List;

public class Triangle implements ApplicationContextAware, BeanNameAware , InitializingBean, DisposableBean,Shape {
 /*  private List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
    public void draw(){
        for(Point point : points){
            System.out.println("point = (" + point.getX() + "," + point.getY() + ")");
        }
    }*/
  private ApplicationContext context = null;
     private Point pointA;
    private Point pointB;
    private Point pointC;


    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointC() {
        return pointC;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointA() {
        return pointA;
    }
    public void draw(){
        System.out.println("i am drawing Triangle");
        System.out.println("pointA = (" + getPointA().getX() + "," +getPointA().getY() + ")" );
        System.out.println("pointB = (" + getPointB().getX() + "," +getPointB().getY() + ")");
        System.out.println("pointC = (" + getPointC().getX() + "," +getPointC().getY() + ")");
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    public void setBeanName(String beanName) {
        System.out.println("Bean Name is " + beanName);
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("InitizlizingBean init  method called for triangle");
    }

    public void destroy() throws Exception {
        System.out.println("DesposibaleBean destroy method called for triangle");
    }
    public void myInit(){
        System.out.println("my init method called for triangle");
    }
    public void myCleanUp(){
        System.out.println("my destroy method called for triangle");
    }
    /*  private String type;
    private int height;
    public Triangle(String type){
         this.type = type;
    }
    public Triangle(int height ){
        this.height = height;
    }
    public Triangle(String type ,int height){
        this.type = type;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
      public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void draw(){
        System.out.println(getType() + " triangle drawn by height "  + getHeight());
    }*/
}
