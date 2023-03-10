package udemy.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCouch = context.getBean("myCoach", Coach.class);
        System.out.println(theCouch.getDailyWorkout());

        context.close();
    }
}