package net.swierczynski.alexaairly;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

class AirQualityIntentHandler implements RequestHandler {

  private static final String INTENT_NAME = "AirQualityIntent";

  @Override
  public boolean canHandle(HandlerInput handlerInput) {
    return handlerInput.matches(Predicates.intentName(INTENT_NAME));
  }

  @Override
  public Optional<Response> handle(HandlerInput handlerInput) {
    String speechText = "Hello from Airly for Alexa!";
    return handlerInput.getResponseBuilder()
        .withSpeech(speechText)
        .withSimpleCard("AlexaAirly", speechText)
        .build();
  }
}
