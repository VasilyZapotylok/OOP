package by.zapotylok.task1.util;

import java.util.Comparator;

import by.zapotylok.task1.bean.Plane;

public class SortedByFlightRange implements Comparator<Plane> {

	public int compare(Plane obj1, Plane obj2) {

		int range1 = obj1.getFlightRange();
		int range2 = obj2.getFlightRange();

		if (range1 > range2) {
			return 1;
		} else if (range1 < range2) {
			return -1;
		} else {
			return 0;

		}

	}

}
