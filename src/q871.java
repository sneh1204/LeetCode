// Minimum Number of Refueling Stops

/**
 * A car travels from a starting position to a destination which is target miles east of the starting position.
 *
 * Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east of the starting position, and has station[i][1] liters of gas.
 *
 * The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives.
 *
 * When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
 *
 * What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot reach the destination, return -1.
 *
 * Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 *
 * Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * Output: 2
 * Explanation:
 * We start with 10 liters of fuel.
 * We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
 * Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
 * and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
 * We made 2 refueling stops along the way, so we return 2.
 *
 */

public class q871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target) return 0;
        else if(stations.length == 0) return -1;
        int cur_station = 0, traversed = 0, min_no = -1;
        while (startFuel > 0){
            if(cur_station > stations.length)  return -1;
            traversed += startFuel;
            ++min_no;
            if(traversed >= target) break;
            if(traversed < stations[cur_station][0])    return -1;
            startFuel = stations[cur_station++][1];
        }
        return min_no;
    }

    public static void main(String[] args) {
        //System.out.println(new q871().minRefuelStops(1, 1, new int[][]{}));
        //System.out.println(new q871().minRefuelStops(100, 1, new int[][]{{10, 100}}));
        //System.out.println(new q871().minRefuelStops(100, 1000, new int[][]{}));
        //System.out.println(new q871().minRefuelStops(100, 50, new int[][]{{50, 50}}));
        System.out.println(new q871().minRefuelStops(100, 50, new int[][]{{25, 25}, {50, 50}})); // 1
        System.out.println(new q871().minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}})); // 2
    }
}
