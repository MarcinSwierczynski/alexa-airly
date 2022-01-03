package net.swierczynski.alexaairly;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

import static java.lang.String.format;

class AirQualityIntentHandler implements RequestHandler {

  private static final String INTENT_NAME = "AirQualityIntent";

  private final AirlyClient airlyClient;

  AirQualityIntentHandler(AirlyClient airlyClient) {this.airlyClient = airlyClient;}

  @Override
  public boolean canHandle(HandlerInput handlerInput) {
    return handlerInput.matches(Predicates.intentName(INTENT_NAME));
  }

  @Override
  public Optional<Response> handle(HandlerInput handlerInput) {
    String speechText = getSpeechText();
    return handlerInput.getResponseBuilder()
        .withSpeech(speechText)
        .withSimpleCard("AlexaAirly", speechText)
        .build();
  }

  private String getSpeechText() {
    AirQuality airQuality = airlyClient.fetchAirQuality("50.273966", "19.004781");
    String description = airQuality.getDescription();
    int caqi = (int) Math.round(airQuality.getValue());
    return format("%s The Common Air Quality Index is %s.", description, caqi);
  }
}
