package Arrays;

import java.util.*;

public class AuditoriumCapacityCheck {

    public static String canAllGroupsAttend(int N, int C, int[][] audience) {
        // List of all events: (time, change in people)
        List<int[]> events = new ArrayList<>();

        for (int[] group : audience) {
            int persons = group[0];
            int start = group[1];
            int end = group[2];
            events.add(new int[]{start, persons});   // Arrival
            events.add(new int[]{end, -persons});    // Departure
        }

        // Sort events:
        // 1. By time
        // 2. If times are equal, departures (-persons) before arrivals (+persons)
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];      // Sort by time
            return a[1] - b[1];                        // Departure before arrival
        });

        int currentPeople = 0;

        for (int[] event : events) {
            currentPeople += event[1];
            if (currentPeople > C) {
                return "no";
            }
        }

        return "yes";
    }

    public static void main(String[] args) {
        int N = 3;
        int C = 10;
        int[][] audience = {
            {5, 1, 5},
            {4, 2, 6},
            {3, 5, 7}
        };

        System.out.println(canAllGroupsAttend(N, C, audience)); // Output: yes
    }
}


// An auditorium can accomodate with only certain no of people at a time , you are given with N group with their start time , end time and no of persons in each group , the problem is to find whether all the given group can attend the function or not.                                                                                                              Input:    

//Inputs:
// N -> represents the number of groups
// C -> capacity of the auditorium
// audience[N][3] -> is a 2d Array represents the [[persons , start time , end time] ,.... N]

// Output:
// yes or no 