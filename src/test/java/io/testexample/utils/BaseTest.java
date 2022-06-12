package io.testexample.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BaseTest {

    protected static RequestSpecification requestSpecification;
    PrintStream logStream;

    protected RequestSpecification requestSpecification() {

        if (requestSpecification == null) {
            try {
                logStream = new PrintStream(new FileOutputStream("logging.txt"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            requestSpecification = new RequestSpecBuilder().
                    setBaseUri(ConfigReader.getProperty("baseURI")).
                    addQueryParam("key", "qaclick123").
                    setContentType(ContentType.JSON).
                    addFilter(RequestLoggingFilter.logRequestTo(logStream)).
                    addFilter(ResponseLoggingFilter.logResponseTo(logStream)).
                    build();
            return requestSpecification;
        }

        return requestSpecification;
    }


}
