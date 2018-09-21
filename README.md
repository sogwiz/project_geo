
# Parameters
Parameter | Purpose
------------- | -------------
-help | Prints the help options
-url | URL of the json file to parse
-f | location of the file to output the results to. otherwise, prints to terminal

# Instructions
0. (optional): build the jar file (NOTE: a pre-built jar is available to use in the 'lib' dir)

`mvn package`

* __execute the jar and output to terminal__

`java -jar target/com.sogwiz.apl_artifact-1.0-SNAPSHOT-jar-with-dependencies.jar -url https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.geojson`

* __execute the jar and output to file named out.csv__

`java -jar target/com.sogwiz.apl_artifact-1.0-SNAPSHOT-jar-with-dependencies.jar -url https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.geojson -f out.csv`

# Info
* GeoRunner.java is the entry point. It calls Mapper.java. Mapper uses the data model POJOs defined in the project

`cmd line jar execution -> GeoRunner -> Mapper -> data models`

*Data model: https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php*

# Limitations

* Requires Java 1.8

# Future Optimizations
1. add option to load from a local file instead of going to a URL each time
2. add option to modify the chronological order to either ascending or descending
3. add test cases and comments (compare FeatureCollection metadata count with the actual list of Features)
4. add debug logging to print summary stats
5. docker container for execution (this could be overkill)
