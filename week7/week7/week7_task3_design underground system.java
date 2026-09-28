import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Stores passengers who are currently checked in.
    // id -> CheckIn information
    private Map<Integer, CheckIn> checkIns;

    // Stores travel statistics.
    // "startStation#endStation" -> [totalTime, numberOfTrips]
    private Map<String, double[]> trips;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkIns.get(id);

        String startStation = checkIn.stationName;
        int startTime = checkIn.time;

        String key = startStation + "#" + stationName;

        double travelTime = t - startTime;

        if (!trips.containsKey(key)) {
            trips.put(key, new double[]{0.0, 0.0});
        }

        double[] data = trips.get(key);

        // data[0] = total travel time
        // data[1] = number of trips
        data[0] += travelTime;
        data[1]++;

        // Passenger has completed the journey
        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "#" + endStation;

        double[] data = trips.get(key);

        return data[0] / data[1];
    }

    // Helper class to store check-in information
    private static class CheckIn {
        String stationName;
        int time;

        CheckIn(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
}

