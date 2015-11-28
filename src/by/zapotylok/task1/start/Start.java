package by.zapotylok.task1.start;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

import by.zapotylok.task1.bean.AirCompany;
import by.zapotylok.task1.bean.Plane;
import by.zapotylok.task1.builder.Builder;
import by.zapotylok.task1.util.CountAllCargo;
import by.zapotylok.task1.util.CountAllPassengers;
import by.zapotylok.task1.util.SortedByFlightRange;

public class Start {
	static {
		new DOMConfigurator().doConfigure("src/settings/log4j.xml", LogManager.getLoggerRepository());
	}

	public static void main(String[] args) {

		ArrayList<Plane> planes = Builder.getInstance().createAirplanes();

		AirCompany airCompany = AirCompany.getInstance(planes);

		airCompany.showPlanes(planes);

		System.out.println("All Passengers = " + CountAllPassengers.countPassangers(planes));

		System.out.println("All Cargo = " + CountAllCargo.countCargo(planes));

		Collections.sort(airCompany.getPlains(), new SortedByFlightRange());

		airCompany.showPlanes(planes);
	}

}
