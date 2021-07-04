# spring-native-learn
experiment with spring native and graalvm

###To build native docker image use the following command

```shell
mvn -Ddocker.publish.username=$DOCKER_USERNAME -Ddocker.publish.password=$DOCKER_SECRET -Ddocker.publish.url=$DOCKER_URL -Ddocker.publish.email=$DOCKER_EMAIL spring-boot:build-image
```
###To run the locally built docker image

```shell
docker run --rm -p 9999:9999 dockforsujay/spring-native-learn:0.0.1
```