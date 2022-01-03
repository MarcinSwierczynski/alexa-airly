package net.swierczynski.alexaairly;

import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

class AirlyClient {

  private static final String ENDPOINT = "https://airapi.airly.eu/v2/measurements/nearest";
  private static final String API_KEY = "<FILL API KEY>";
  private static final String MAX_DISTANCE_KM = "1";

  AirQuality fetchAirQuality(String latitude, String longitude) {
    JsonNode response = Unirest.get(ENDPOINT)
        .header("apikey", API_KEY)
        .queryString("lat", latitude)
        .queryString("lng", longitude)
        .queryString("maxDistanceKM", MAX_DISTANCE_KM)
        .asJson()
        .getBody();

    JSONObject indexes = response.getObject()
        .getJSONObject("current")
        .getJSONArray("indexes")
        .getJSONObject(0);

    return new AirQuality(
        indexes.getString("description"),
        indexes.getDouble("value")
    );
  }
}
