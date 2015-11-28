package by.zapotylok.task1.bean;

import by.zapotylok.task1.exception.FileMistakeException;

public class PassengerPlane extends Plane {

	private int passengerCapacity;

	

	public PassengerPlane() {

	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) throws FileMistakeException {
		if (passengerCapacity > 0) {

			this.passengerCapacity = passengerCapacity;
		} else {
			throw new FileMistakeException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + passengerCapacity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassengerPlane other = (PassengerPlane) obj;
		if (passengerCapacity != other.passengerCapacity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PassengerPlane [passengerCapacity=" + passengerCapacity + ", getId()=" + getId() + ", getType()="
				+ getType() + ", getKind()=" + getKind() + ", getFlightRange()=" + getFlightRange()
				+ ", getConsumption()=" + getConsumption() + "]";
	}



}
