package web.mvc.controllers;

import core.service.AirManager.ManagerOffice;
import core.service.TicketOffice.TicketOffice;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * Created by employee on 11/5/15.
 */

public class BaseController {

    @Autowired
    protected ManagerOffice managerOffice;

    @Autowired
    protected TicketOffice ticketOffice;

}
