package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by employee on 10/30/15.
 */
@WebServlet(urlPatterns = "/AddNewFlight")
public class AddNewFlight  extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("city", citySearch.getAll());
        req.getRequestDispatcher("views/AddNewFlight.jsp").forward(req,resp);
    }
    /**
     * handles HTTP POST request
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String cityName = request.getParameter("cityName");
        String seatCount1 = request.getParameter("seatCount");
        int seatCount = Integer.parseInt(seatCount1);
        String departureDate = request.getParameter("departureDate");
        managerOffice.setNewFlight(seatCount,cityName,departureDate);
        PrintWriter writer = response.getWriter();
        writer.println("<html>" + "Flight Was added" + "<body>" +
                " <form action=/ >\n" +
                " <input type=\"submit\" value=\"Get to start\" />\n" +
                " </form></body>" +"</html>");

        writer.flush();
    }
}
