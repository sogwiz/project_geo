package com.sogwiz;

import java.io.PrintWriter;
import java.util.Collections;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sargonbenjamin on 9/19/18.
 */
public class Mapper {

    Logger logger = LoggerFactory.getLogger(Mapper.class);
    OkHttpClient client;
    String url;
    String outFile;

    public Mapper() {
        this.client = new OkHttpClient();
    }

    public Mapper(String url, String outFile){
        this();
        this.url = url;
        this.outFile = outFile;

    }

    public void executeGeoCoding() throws Exception {

        JsonObject response = makeHttpRequest(url);
        FeatureCollection featureCollection = new Gson().fromJson(response.toString(), FeatureCollection.class);
        Collections.sort(featureCollection.features, Feature.compareByTime);

        //using java8 language level features
        //this ends up calling the toString() on each Feature object
        //Feature.toString() contains the formatting logic
        if(outFile!=null){
            PrintWriter out = new PrintWriter(outFile);
            logger.info("Writing to file : " + outFile);
            for(Feature feature : featureCollection.features){
                out.println(feature.toString());
            }
        }else{
            featureCollection.features.forEach(System.out::println);
        }

    }

    JsonObject makeHttpRequest(String url) throws Exception {
        Request request = new Request.Builder()
            .url(url)
            .build();
        Response response = this.client.newCall(request).execute();
        logger.info( "Response Code: " + response.code() );
        return new JsonParser().parse(response.body().string()).getAsJsonObject();
    }


}
