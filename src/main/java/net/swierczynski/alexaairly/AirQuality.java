package net.swierczynski.alexaairly;

class AirQuality {

  private final String description;
  private final double value;

  AirQuality(String description, double value) {
    this.description = description;
    this.value = value;
  }

  String getDescription() {
    return description;
  }

  double getValue() {
    return value;
  }
}
