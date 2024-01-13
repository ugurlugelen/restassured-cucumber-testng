FROM augurlugelen/java11-3.8.8-testdep
COPY src home/apiframework/src
COPY pom.xml home/apiframework/pom.xml
WORKDIR home/apiframework
ENTRYPOINT mvn clean test