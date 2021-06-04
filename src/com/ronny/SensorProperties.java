package com.ronny;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class SensorProperties {
    long sourceId = 0;
    String shortDescription = "";
    String sensorId = "";
    String siteId = "";
    String description = "";
// {"source_id": 1, "short_desc": "hagtorn_bil", "sensor_id": "bil", "site_id": "hagtorn", "description": "Hagtorn CarCharger"},

    public boolean getSensorProperties(String source) {
        JSONParser parser = new JSONParser();
        boolean keyFound = false;
        long searchSource = Integer.parseInt(source);
        long foundSource = 0;

        try {
            JSONArray sensors = (JSONArray) parser.parse(new FileReader("sensorDb.json"));

            Iterator i = sensors.iterator();

            while (i.hasNext()) {
                JSONObject sensor = (JSONObject) i.next();
                foundSource = (Long) sensor.get("source_id");
                if (foundSource == searchSource) {
                    sourceId = foundSource;
                    shortDescription = (String) sensor.get("short_desc");
                    sensorId = (String) sensor.get("sensor_id");
                    siteId = (String) sensor.get("site_id");
                    description = (String) sensor.get("description");
                    keyFound = true;
                }

            }
        } catch (Exception pe) {
            //  System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }

    return keyFound; }
}

