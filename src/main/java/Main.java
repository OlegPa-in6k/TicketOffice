import Core.Dao.CityDao;
import Core.Entity.City;
import Core.InputOutput.InputController.InputController;
import Persistance.CityDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
public class Main {

    public static void main(String[] args) {
        //main program
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"}, true);


        InputController controller =  context.getBean(InputController.class);

        controller.startChoose();



    }


}






















    /*p?????? ??? ?????
    AJAX/JSON

    HTTP consist of:
    ports 80/443

    H.E.A.D ^
    content - type - //text/html
                    //application/json

    httpserver -???????? ??? ???????? ??????

            Java web servers:
            tomcat
    glassfish
     jboss              -- srevlet API ---  Springmvc or custom or struts
     jetty
      weblogic



    servlecContainer contains appConteiner

    src - main - java
}              - resources
                - WebApp--Web-INF--Web.XML
                                 --Index.jsp


WEB.xml
<servlet>
<servlet-name >  </>
<servlet-class> </>
</servlet>

<servlet-mapping>
<servlet-name> </>
<url-pattern>  </>
</servlet-mapping>


??????? - ?? ???? ??????????? ???


jsp -> java code



<context-listener> ????? ???? ???????? ?????????

                *//*
}*/