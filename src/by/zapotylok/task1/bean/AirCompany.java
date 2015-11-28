package by.zapotylok.task1.bean;

import java.util.ArrayList;
import java.util.Iterator;

public class AirCompany {
	private static AirCompany instance;
	private ArrayList<Plane> planes;

	public AirCompany(ArrayList<Plane> plains) {
		super();
		this.planes = plains;
	}

	public ArrayList<Plane> getPlains() {
		return planes;
	}

	public void setPlains(ArrayList<Plane> plains) {
		this.planes = plains;
	}

	public static AirCompany getInstance(ArrayList<Plane> plains) {
		if (instance == null) {
			instance = new AirCompany(plains);
		}
		return instance;
	}

	public void showPlanes(ArrayList<Plane> plains) {
		Iterator<Plane> it = plains.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}

	}

}
