package springAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springAOP.Service.FactoryService;
import springAOP.Service.ShapeService;
import springproject.Shape;

public class AOPMain {
    public static void main(String[] args) {
       // AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("springaop.xml");
       // ShapeService shapeService = ctx.getBean("shapeService",ShapeService.class);
        FactoryService factoryService = new FactoryService();
        ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
        shapeService.getCircle();
       // System.out.println(shapeService.getCircle().getName());
    }
}
