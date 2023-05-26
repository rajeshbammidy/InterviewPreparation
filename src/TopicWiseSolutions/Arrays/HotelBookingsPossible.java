package TopicWiseSolutions.Arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|HotelBookingsPossible| on Apr,2020
 *  
 * Happy Coding :)
 **/
public class HotelBookingsPossible {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int k) {
        Collections.sort(arrive, null);
        Collections.sort(depart, null);
        int i = 0;
        int j = 0;
        int n = arrive.size();
        int bookings = 0;
        while (i < n && j < n) {
            if (arrive.get(i) < depart.get(j)) {
                bookings++;
                i++;
                if (bookings >= k) return false;
            } else if (arrive.get(i) == depart.get(j)) {
                i++;
                j++;
            } else {
                bookings--;
                j++;
            }
        }
        return true;
    }
}
