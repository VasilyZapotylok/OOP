package by.zapotylok.task1.bean;

import by.zapotylok.task1.enums.Kind;
import by.zapotylok.task1.enums.Type;
import by.zapotylok.task1.exception.FileMistakeException;

public abstract class Plane {

	private int id;
	private Kind kind;
	private Type type;
	private int flightRange;
	private int consumption;


	public Plane() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) throws FileMistakeException {
		if (id > 0) {
			this.id = id;
		} else {
			throw new FileMistakeException();
		}
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public int getFlightRange() {
		return flightRange;
	}

	public void setFlightRange(int flightRange) throws FileMistakeException {
		if (flightRange > 0) {
			this.flightRange = flightRange;
		} else {
			throw new FileMistakeException();
		}
	}

	public int getConsumption() {
		return consumption;
	}

	public void setConsumption(int consumption) throws FileMistakeException {
		if (consumption > 0) {
			this.consumption = consumption;
		} else {
			throw new FileMistakeException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + consumption;
		result = prime * result + flightRange;
		result = prime * result + id;
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plane other = (Plane) obj;
		if (consumption != other.consumption)
			return false;
		if (flightRange != other.flightRange)
			return false;
		if (id != other.id)
			return false;
		if (kind != other.kind)
			return false;
		if (type != other.type)
			return false;
		return true;
	}





}
