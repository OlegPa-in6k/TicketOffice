package Printer;

import Entity.Flights;

import java.util.List;

/**
 * Created by Oleg on 26.10.2015.
 */
public class PrinterImpl extends AbstractPrinter {




    @Override
    public void printStartMassage() {
        System.out.println("1 - View All Flights, from current Day\n" +
                "2 - View FlightsInSomeCity\n" +
                "3 - View flight by someDate\n" +
                "4 - choose right flight\n" +
                "0 - exit");
    }

    @Override
    public void printFlight(Flights flights) {
        System.out.printf("%2d%10s%4d%22s", flights.getId(),
                 flights.getCity().getCityName(),
                 flights.getEmptySeat(),
                 flights.getDepartureDate());


    }

    @Override
    public void printTable(List<Flights> flightEntities) {
        for (Flights flights : flightEntities) {
            printFlight(flights);
            System.out.println();
        }
    }

    @Override
    public void printAboutCity() {
        System.out.println("Enter City");
    }

    @Override
    public void printNoSuchCity() {
        System.out.println("No such City");
    }

    @Override
    public void printDate() {
        System.out.println("print date in formay yyyy-MM-dd HH:MM");
    }

    @Override
    public void printNoFlightAtThisTime() {
        System.out.println("No glights at that time");
    }

    @Override
    public void printCountOfSeats() {
        System.out.println("How many seats u want?");
    }

    @Override
    public void positiveAnswer() {
        System.out.println("U can buy");
    }

    @Override
    public void printNegativeAnswer() {
        System.out.println("U can't buy");

    }

    @Override
    public void negativeAnswerAboutFlight() {
        System.out.println("No such Flight");
    }

    @Override
    public void printAboutSeats() {

    }

    @Override
    public void printMainMassage() {
        System.out.println("1 - ManagerOffice\n 2 - TicketOffice\n 0 - Exit");
    }

    @Override
    public void printMainManagerMessage() {
        System.out.println("1 - addFlight\n 2 - del Flight\n0 - Exit");
    }


}
