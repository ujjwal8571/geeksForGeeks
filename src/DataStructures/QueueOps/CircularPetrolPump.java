package DataStructures.QueueOps;

import java.util.LinkedList;

public class CircularPetrolPump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class petrolPair {
		int petrol;
		int distance;
	}

	public static petrolPair findStationToCompleteLoop(petrolPair[] stations) {
		petrolPair rv;

		LinkedList<petrolPair> queue = new LinkedList<>();

		int totalPetrol = 0;
		petrolPair firstStation = stations[0];
		totalPetrol += firstStation.petrol - firstStation.distance;
		

		return rv;

	}

}
