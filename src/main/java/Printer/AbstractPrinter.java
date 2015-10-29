package Printer;

import Entity.Flights;

import java.util.List;

/**
 * Created by Oleg on 26.10.2015.
 */
public abstract class AbstractPrinter {
   /* protected OutputStream outputStream;
    AbstractPrinter(OutputStream outputStream){}*/
    abstract void printStartMassage();

    abstract void printFlight(Flights flights);

    abstract void printTable(List<Flights> flightEntities);

    public abstract void printAboutCity();

    public abstract void printNoSuchCity();

    public abstract void printDate();

    public abstract void printNoFlightAtThisTime();

 public abstract void printCountOfSeats();

 public abstract void positiveAnswer();

 public abstract void printNegativeAnswer();

 public abstract void negativeAnswerAboutFlight();

 public abstract void printAboutSeats();

 public abstract void printMainMassage();

 public abstract void printMainManagerMessage();
}
