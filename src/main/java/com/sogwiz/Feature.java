package com.sogwiz;

import java.time.Instant;
import java.util.Comparator;
import java.util.Map;

/**
 * Created by sargonbenjamin on 9/20/18.
 */
public class Feature {

    String type;
    String id;
    Map<String, Object> properties;

    //comparator for sorting chronologically by time
    public static Comparator<Feature> compareByTime = new Comparator<Feature>
        () {
        public int compare(final Feature o1, final Feature o2) {
            int result = ((Double)o1.properties.get("time")).compareTo((Double)o2.properties.get("time"));
            return result;
        }
    };

    @Override
    public String toString(){
        long millis = ((Double)properties.get("time")).longValue();
        Instant instant = Instant.ofEpochMilli(millis);
        return instant + " | " + properties.get("place") + " | " + "Magnitude: " + properties.get("mag");
    }
}
