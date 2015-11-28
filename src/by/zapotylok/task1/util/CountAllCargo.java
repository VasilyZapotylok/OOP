package by.zapotylok.task1.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import by.zapotylok.task1.bean.CargoPlane;
import by.zapotylok.task1.bean.Plane;

public class CountAllCargo {
	static final Logger logger = Logger.getLogger(CountAllCargo.class);

	public static int countCargo(ArrayList<Plane> planes) {

		int amount = 0;

		for (Plane plane : planes) {
			if (plane instanceof CargoPlane) {
				amount = amount + ((CargoPlane) plane).getWeightCapacity();
			}
		}
		logger.info("Method was counded weight of all cargo");
		return amount;

	}
}
