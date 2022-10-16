mvn org.apache.maven.plugins:maven-assembly-plugin:2.6:assembly -DdescriptorId=jar-with-dependencies package &&
aws lambda update-function-code \
--profile senco \
--function-name alexa-airly \
--region us-east-1 \
--zip-file fileb://target/alexa-airly-1.0-SNAPSHOT-jar-with-dependencies.jar
