

*Data model: https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php*

# Parameters
-help : Prints the help options
-url : URL of the json file to parse
-f : location of the file to output the results to. otherwise, prints to terminal

# Instructions
0. (optional): build the jar file (NOTE: a pre-built jar is available to use in the 'lib' dir)

*mvn package*

* execute the jar and output to terminal

*java -jar target/com.sogwiz.apl_artifact-1.0-SNAPSHOT-jar-with-dependencies.jar -url https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.geojson*

* execute the jar and output to file named out.csv

*java -jar target/com.sogwiz.apl_artifact-1.0-SNAPSHOT-jar-with-dependencies.jar -url https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.geojson -f out.csv*

# Limitations
* if the milliseconds portion of the timestamp string are fewer than 3 digits, then the output will look slightly different. Please see example below

2018-09-19T00:17:*38*Z | 220km NW of Saumlaki, Indonesia | Magnitude: 4.2
2018-09-19T00:20:20.*952*Z | 10km E of Bridgeport, California | Magnitude: 0.9

