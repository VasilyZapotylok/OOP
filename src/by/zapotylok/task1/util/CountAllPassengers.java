package by.zapotylok.task1.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import by.zapotylok.task1.bean.PassengerPlane;
import by.zapotylok.task1.bean.Plane;


public class CountAllPassengers {
	static final Logger logger = Logger.getLogger(CountAllPassengers.class);

	public static int countPassangers(ArrayList<Plane> planes) {

		int amount = 0;

		for (Plane plane : planes) {
			if (plane instanceof PassengerPlane) {
				amount = amount + ((PassengerPlane) plane).getPassengerCapacity();
			}
		}
		logger.info("Method was counted all passengers");
		return amount;

	}
}
