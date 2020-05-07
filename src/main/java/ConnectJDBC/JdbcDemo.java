package ConnectJDBC;

import ConnectJDBC.Dao.JdbcDaoImpl;
import ConnectJDBC.Model.Circle;
import ConnectJDBC.Model.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl" ,JdbcDaoImpl.class);
      //  Circle circle = dao.getCircle(2);
        //System.out.println(circle.getName());
      //  System.out.println(dao.getCircleForId(1).getName());
        dao.insertCircle(new Circle(5,"fifth circle"));
      //  dao.createTriangleTable()
        //  dao.insertTriangle(new Triangle(2,"secondtriangle"));
       System.out.println(dao.getAllCircle().size());

    }
}
