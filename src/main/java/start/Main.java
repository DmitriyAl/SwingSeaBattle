package start;

import model.abstractClassesAndInterfaces.IGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dmitriy on 11.01.2016.
 */
public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});
        IGame game = context.getBean("game", IGame.class);
        log.info("smth");
        log.info(game.toString());
    }
}
