package Core.InputOutput.InputController;

import Persistance.FlightDaoImpl;
import Core.InputOutput.Printer.PrinterImpl;

import java.util.Scanner;

/**
 * Created by Oleg on 26.10.2015.
 */
public class InputControllerImpl {

        Scanner scanner = new Scanner(System.in);
        FlightDaoImpl search;
        PrinterImpl printer;

    public InputControllerImpl(FlightDaoImpl search, PrinterImpl printer) {
        this.search = search;
        this.printer = printer;
    }

    /*public void choose(){
        boolean isExit=false;
        while(!isExit){
            printer.printStartMassage();
            switch (scanner.nextInt()){
                case 1: printer.printTable(search.getAll());
                    break;
               /* case 2: scanner.nextLine();
                    printer.printAboutCity();
                    String arrivalCity = scanner.nextLine();

                    if(search.getFlightsByCity(arrivalCity).size()>0){
                        printer.printTable(search.getFlightsByCity(arrivalCity));
                    }else
                    printer.printNoSuchCity();
                    break;*/

             /*   case 3:
                    scanner.nextLine();
                    printer.printDate();
                    String dateTime = scanner.nextLine();
                    Timestamp date = Timestamp.valueOf(LocalDateTime.parse(dateTime, Flights.FORMATTER));
                    if(search.getFlightByDate(date).size()>0){
                        printer.printTable(search.getFlightByDate(date));
                    }else{
                        printer.printNoFlightAtThisTime();
                    }
                    break;*/
                /*case 4:
                    scanner.nextLine();
                    printer.printAboutCity();
                    String arrivalCityt = scanner.nextLine();
                    printer.printDate();
                    String data = scanner.nextLine();
                    Timestamp date1 = Timestamp.valueOf(LocalDateTime.parse(data, Flights.FORMATTER));
                    
                    if(search.getFlight(arrivalCityt, date1)!=null){
                        System.out.println("How many seats you want?");
                        int seats = scanner.nextInt();
                        if(search.getFlight(arrivalCityt, date1).getEmptySeat()>=seats){
                            System.out.println("U can buy such count of Tickets");
                        }else {
                            System.out.println("No such count");
                        }
                    }else{
                        System.out.println("No such Flights");
                }
                    break;*/

          /*      case 0: isExit=true;break;
            }
        }*/
    //}


}
