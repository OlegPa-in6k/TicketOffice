package core.inputOutput.InputController;

import core.service.AirManager.ManagerOffice;

import core.inputOutput.Printer.PrinterImpl;
import core.service.TicketOffice.TicketOffice;

import java.util.Scanner;

/**
 * Created by employee on 10/29/15.
 */
public class InputController implements InputControllerInterface {

    Scanner scanner = new Scanner(System.in);
    ManagerOffice officeManager;
    TicketOffice ticketOffice;
    PrinterImpl printer;

    public InputController(ManagerOffice officeManager, TicketOffice ticketOffice, PrinterImpl printer) {
        this.officeManager = officeManager;
        this.ticketOffice = ticketOffice;
        this.printer = printer;
    }

    public void startChoose(){
        boolean isExit = false;
        while (!isExit){
            printer.printMainMassage();
            switch(scanner.nextInt()){
                case 1: managerSettings();
                    break;
                case 2:
                    ticketOfficeSettings();
                    break;
                case 0: isExit = true;
                    break;

            }
        }
    }

    public void managerSettings(){
        boolean isExit = false;
        while (!isExit) {
            printer.printMainManagerMessage();
            switch (scanner.nextInt()) {
                case 1:
                    addFlight();
                    break;
                case 2:
                    //deleteFlight();
                    break;
                case 0: isExit = true;
                    break;
            }
        }
    }

    /*private void deleteFlight() {
        scanner.nextLine();
        printer.printDate();
        String departureDate1 = scanner.nextLine();
        printer.printAboutCity();
        String arrivalCity1 = scanner.nextLine();
        officeManager.deleteFlight(id);
    }*/

    private void addFlight() {
        scanner.nextLine();
        printer.printAboutCity();
        String arrivalCity = scanner.nextLine();
        printer.printDate();
        String departureDate = scanner.nextLine();

        printer.printAboutSeats();
        int seat = scanner.nextInt();
        officeManager.setNewFlight(seat, arrivalCity, departureDate);
    }

    public void ticketOfficeSettings(){

        printer.printStartMassage();

        switch (scanner.nextInt()){
            case 1: printer.printTable(ticketOffice.getAllFlights());
                break;
            case 2:
                printFlightByCity();
                break;
            case 3: printer.printDate();
                printFlightByDate();
            case 4:
                getAnswerByFlightAndSeat();
                break;
            case 0: break;


        }


    }

    private void getAnswerByFlightAndSeat() {
        printer.printAboutCity();
        scanner.nextLine();
        String arrivalCity1 = scanner.nextLine();
        printer.printDate();
        String departuredate1 = scanner.nextLine();
        printer.printAboutSeats();
        int seatCount = scanner.nextInt();
        if(ticketOffice.hasSeat(arrivalCity1, departuredate1, seatCount)){
            printer.positiveAnswer();
        }else printer.printNegativeAnswer();
    }

    private void printFlightByDate() {
        String departureDate = scanner.nextLine();
        printer.printTable(ticketOffice.searchFlightsByDate(departureDate));
    }

    private void printFlightByCity() {
        printer.printAboutCity();
        scanner.nextLine();
        String arrivalCity = scanner.nextLine();
        printer.printTable(ticketOffice.searchFlightsByCity(arrivalCity));
    }
}
