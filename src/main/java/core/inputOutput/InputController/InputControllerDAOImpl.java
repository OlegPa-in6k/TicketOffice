package core.inputOutput.InputController;

import core.entity.Flights;
import core.inputOutput.Printer.PrinterImpl;
import persistance.CityDaoImpl;
import persistance.FlightDaoImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Created by employee on 10/28/15.
 */
public class InputControllerDAOImpl implements InputControllerInterface {
    Scanner scanner = new Scanner(System.in);

    public InputControllerDAOImpl(PrinterImpl printer, FlightDaoImpl searchFlight, CityDaoImpl searchCity) {
        this.printer = printer;
        this.searchFlight = searchFlight;
        this.searchCity = searchCity;
    }

    PrinterImpl printer;
    FlightDaoImpl searchFlight;
    CityDaoImpl searchCity;

    public void startChoise() {
        boolean isExit = false;
        while (!isExit) {
            printer.printStartMassage();
            switch (scanner.nextInt()) {
                case 1:
                    printer.printTable(searchFlight.getAll());
                    break;
                case 2:
                    scanner.nextLine();
                    printer.printAboutCity();
                    String cityName = scanner.nextLine();
                    int id_city = searchCity.getCityIdByName(cityName).getCityId();
                    printer.printTable(searchFlight.getFlightsByCity(id_city));
                    break;
                case 3:
                    scanner.nextLine();
                    printer.printDate();
                    String date = scanner.nextLine();
                    Timestamp departureDate = Timestamp.valueOf(LocalDateTime.parse(date, Flights.FORMATTER));
                    printer.printTable(searchFlight.getFlightByDate(departureDate));
                    break;
                case 4:
                    scanner.nextLine();
                    printer.printAboutCity();
                    String cityName1 = scanner.nextLine();
                    int id_city1 = searchCity.getCityIdByName(cityName1).getCityId();
                    printer.printDate();
                    String date1 = scanner.nextLine();
                    Timestamp departureDate1= Timestamp.valueOf(LocalDateTime.parse(date1, Flights.FORMATTER));
                    try {
                        Flights flight = searchFlight.getFlight(id_city1, departureDate1);
                        printer.printFlight(flight);
                        printer.printCountOfSeats();
                        int emptySeat = scanner.nextInt();
                        if(flight.getEmptySeat()>=emptySeat){
                            printer.positiveAnswer();
                        } else {
                            printer.printNegativeAnswer();
                        }

                    } catch(Exception e){
                       printer.negativeAnswerAboutFlight();
                    }
                    break;
                case 0:
                    isExit = true;
                    break;
            }
        }
    }





}
