package springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.xml.bind.annotation.XmlRootElement;
//@Component
//@Service
//@Repository
@Controller
public class Circle implements Shape, ApplicationEventPublisherAware {
    private Point center;
    private ApplicationEventPublisher publisher;
    @Autowired
    private MessageSource messageSource;

  /*  public ApplicationEventPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }*/

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //@Required
    //@Autowired
    //@Qualifier("circleRelated")
    @Resource(name = "pointC")
    public void setCenter(Point center) {
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    public void draw(){
        System.out.println("i am drawing Circle");
        System.out.println("center = (" + center.getX() + "," +center.getY() + ")" );
        System.out.println(this.messageSource.getMessage("greeting" , null,"default drawing message",null));
        System.out.println(this.messageSource.getMessage("drawing.circle" , null,"default greeting",null));
        System.out.println(this.messageSource.getMessage("drawing.point" , new Object[] {center.getX(),center.getY()},"default greeting",null));
        DrawEvent drawEvent  = new DrawEvent(this);
        publisher.publishEvent(drawEvent);

    }
    @PostConstruct
    public void initializeCircle(){
        System.out.println("Init of circle");
    }
    @PreDestroy
    public void destroyCircle(){
        System.out.println("destroy circle");
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
}
