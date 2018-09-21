
# Parameters
Parameter | Purpose
------------- | -------------
-help | Prints the help options
-url | URL of the json file to parse
-f | location of the file to output the results to. otherwise, prints to terminal

# Instructions
0. (optional): build the jar file (NOTE: a pre-built jar is available to use in the 'lib' dir)

*mvn package*

* __execute the jar and output to terminal__

*java -jar target/com.sogwiz.apl_artifact-1.0-SNAPSHOT-jar-with-dependencies.jar -url https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.geojson*

* __execute the jar and output to file named out.csv__

*java -jar target/com.sogwiz.apl_artifact-1.0-SNAPSHOT-jar-with-dependencies.jar -url https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.geojson -f out.csv*

# Info
*Data model: https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php*

# Limitations
* if the milliseconds portion of the timestamp string are fewer than 3 digits, then the output will look slightly different. Please see example below

2018-09-19T00:17:*38*Z | 220km NW of Saumlaki, Indonesia | Magnitude: 4.2
2018-09-19T00:20:20.*952*Z | 10km E of Bridgeport, California | Magnitude: 0.9

# Future Optimizations
1. add option to load from a local file instead of going to a URL each time
2. add option to modify the chronological order to either ascending or descending
3. add test cases and comments (compare FeatureCollection metadata count with the actual list of Features)
4. add debug logging to print summary stats
