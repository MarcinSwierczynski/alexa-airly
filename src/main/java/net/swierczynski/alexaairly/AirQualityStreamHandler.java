package net.swierczynski.alexaairly;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class AirQualityStreamHandler extends SkillStreamHandler {

  public AirQualityStreamHandler() {
    super(getSkill());
  }

  private static Skill getSkill() {
    AirQualityIntentHandler airQualityIntentHandler = new AirQualityIntentHandler();

    return Skills.standard()
        .addRequestHandlers(
            airQualityIntentHandler,
            new LaunchRequestHandler(airQualityIntentHandler)
        )
        .build();
  }
}
