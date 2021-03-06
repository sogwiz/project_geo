package com.sogwiz;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
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
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        OffsetDateTime odt = OffsetDateTime.now ( ZoneId.systemDefault () );
        ZoneOffset zoneOffset = odt.getOffset ();

        String dateStr = ldt.getYear() + "-" + ldt.getMonthValue() + "-" + ldt.getDayOfMonth() +
            "T"+ ldt.getHour()+":"+padInt(ldt.getMinute())+":"+padInt(ldt.getSecond())+zoneOffset;


        return dateStr + " | " + properties.get("place") + " | " + "Magnitude: " + properties.get("mag");
    }

    public String padInt(int value){
        String val = String.valueOf(value);
        if(val.length()<2){
            return "0"+val;
        }
        return val;
    }
}
