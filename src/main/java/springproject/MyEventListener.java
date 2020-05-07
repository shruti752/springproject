package springproject;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class MyEventListener implements ApplicationListener {
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println(applicationEvent.toString());
    }
}
