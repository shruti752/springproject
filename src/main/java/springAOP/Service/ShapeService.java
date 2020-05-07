package springAOP.Service;

import com.sun.org.apache.xml.internal.security.encryption.CipherReference;
import springAOP.Aspect.Loggable;
import springAOP.Model.Circle;
import springAOP.Model.Triangle;

public class ShapeService {
    private Circle circle;
    private Triangle triangle;

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Triangle getTriangle() {
        return triangle;
    }
    @Loggable
    public Circle getCircle() {
        System.out.println("circle getter called");
        return circle;
    }
}
