package springAOP.Service;

import springAOP.Aspect.LoggingAspect;
import springAOP.Model.Circle;

public class ShapeServiceProxy extends ShapeService {
    public Circle getCircle() {
        new LoggingAspect().loggingAdvice();
        return super.getCircle();
    }

}
