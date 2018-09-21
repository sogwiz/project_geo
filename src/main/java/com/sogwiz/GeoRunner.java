package com.sogwiz;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sargonbenjamin on 9/19/18.
 */
public class GeoRunner {

    Logger logger = LoggerFactory.getLogger(GeoRunner.class);

    @Parameter(names = "-url", description = "Remote JSON File")
    String inputUrl;

    @Parameter(names = "-f", description = "Output file to write the results to")
    String outFile = null;

    @Parameter(names = "-help", help = true)
    private boolean help = false;

    public static void main(String argv[]) throws Exception{
        GeoRunner runner = new GeoRunner();
        JCommander jCommander = new JCommander(runner);
        jCommander.parse(argv);
        if(runner.help){
            jCommander.usage();
            return;
        }
        runner.run();
    }

    public void run() throws Exception {
        logger.info("Running with url " + inputUrl);
        Mapper mapper = new Mapper(inputUrl, outFile);
        mapper.executeGeoCoding();
    }


}
