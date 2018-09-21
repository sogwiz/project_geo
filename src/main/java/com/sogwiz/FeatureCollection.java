package com.sogwiz;

import java.util.List;

/**
 * Created by sargonbenjamin on 9/20/18.
 * Modeled from https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php
 */
public class FeatureCollection {

    String type;
    List<Feature> features;
    Metadata metadata;
    //Map<String, Object> bbox;

}
