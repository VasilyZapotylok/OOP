package by.zapotylok.task1.bean;


import by.zapotylok.task1.exception.FileMistakeException;

public class CargoPlane extends Plane {

	private int weightCapacity;


	public CargoPlane() {

	}

	public int getWeightCapacity() {
		return weightCapacity;
	}

	public void setWeightCapacity(int weightCapacity) throws FileMistakeException {
		if (weightCapacity > 0) {
			this.weightCapacity = weightCapacity;
		} else {
			throw new FileMistakeException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + weightCapacity;
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
		CargoPlane other = (CargoPlane) obj;
		if (weightCapacity != other.weightCapacity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CargoPlane [weightCapacity=" + weightCapacity + ", getId()=" + getId() + ", getType()=" + getType()
				+ ", getKind()=" + getKind() + ", getFlightRange()=" + getFlightRange() + ", getConsumption()="
				+ getConsumption() + "]";
	}



}
