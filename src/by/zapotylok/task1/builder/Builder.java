package by.zapotylok.task1.builder;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;

import org.apache.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import by.zapotylok.task1.bean.CargoPlane;
import by.zapotylok.task1.bean.PassengerPlane;
import by.zapotylok.task1.bean.Plane;
import by.zapotylok.task1.enums.Kind;
import by.zapotylok.task1.enums.Type;
import by.zapotylok.task1.exception.FileMistakeException;

public class Builder {

	private static Builder instance;

	static final Logger logger = Logger.getLogger(Builder.class);

	public static Builder getInstance() {
		if (instance == null) {
			instance = new Builder();
		}
		return instance;
	}

	public ArrayList<Plane> createAirplanes() {
		ArrayList<Plane> planes = new ArrayList<>();
		try {
			File inputFile = new File("src/files/shedule.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("plane");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (Kind.PASSENGER.toString()
							.equals(eElement.getElementsByTagName("kind").item(0).getTextContent().toString())) {

						PassengerPlane passengerPlane = new PassengerPlane();

						passengerPlane.setKind(Kind.PASSENGER);
						if (Type.TU_154.toString()
								.equals(eElement.getElementsByTagName("type").item(0).getTextContent().toString())) {
							passengerPlane.setType(Type.TU_154);
						} else if (Type.BOEING_737.toString()
								.equals(eElement.getElementsByTagName("type").item(0).getTextContent().toString())) {
							passengerPlane.setType(Type.BOEING_737);
						}

						passengerPlane.setId(
								Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent().trim()));
						passengerPlane.setFlightRange(Integer.parseInt(
								eElement.getElementsByTagName("flightRange").item(0).getTextContent().trim()));
						passengerPlane.setConsumption(Integer.parseInt(
								eElement.getElementsByTagName("consumption").item(0).getTextContent().trim()));
						passengerPlane.setPassengerCapacity(Integer.parseInt(
								eElement.getElementsByTagName("passengerCapacity").item(0).getTextContent().trim()));
						planes.add(passengerPlane);
						logger.info("Passenger Plane was created");

					}

					else if (Kind.CARGO.toString()
							.equals(eElement.getElementsByTagName("kind").item(0).getTextContent().toString())) {

						CargoPlane cargoPlane = new CargoPlane();

						cargoPlane.setKind(Kind.CARGO);
						if (Type.AN_26.toString()
								.equals(eElement.getElementsByTagName("type").item(0).getTextContent().toString())) {
							cargoPlane.setType(Type.AN_26);
						}
						cargoPlane.setId(
								Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent().trim()));
						cargoPlane.setFlightRange(Integer.parseInt(
								eElement.getElementsByTagName("flightRange").item(0).getTextContent().trim()));
						cargoPlane.setConsumption(Integer.parseInt(
								eElement.getElementsByTagName("consumption").item(0).getTextContent().trim()));
						cargoPlane.setWeightCapacity(Integer.parseInt(
								eElement.getElementsByTagName("weightCapacity").item(0).getTextContent().trim()));
						planes.add(cargoPlane);
						logger.info("Cargo Plane was created");
					}

				}

			}

		} catch (FileNotFoundException e) {
			logger.error("File shedule.xml not found");

		} catch (FileMistakeException e) {
			logger.error("Mistake in the shedule");

		} catch (NumberFormatException e) {
			logger.error("Mistake in the shedule");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			logger.error("Parser Configuration Exception");
		}
		return planes;

	}
}
