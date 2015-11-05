import core.inputOutput.InputController.InputController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by employee on 10/26/15.
 */
public class Main {

    public static void main(String[] args) {
        //main program
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring-root-context.xml"}, true);


        InputController controller =  context.getBean(InputController.class);

        controller.startChoose();
     /*  //Show Cities
        CityDaoImpl city = context.getBean(CityDaoImpl.class);
        System.out.println(city.getAll().size());*/


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
<web.servlet>
<web.servlet-name >  </>
<web.servlet-class> </>
</web.servlet>

<web.servlet-mapping>
<web.servlet-name> </>
<url-pattern>  </>
</web.servlet-mapping>


??????? - ?? ???? ??????????? ???


jsp -> java code



<context-listener> ????? ???? ???????? ?????????

                *//*
}*/