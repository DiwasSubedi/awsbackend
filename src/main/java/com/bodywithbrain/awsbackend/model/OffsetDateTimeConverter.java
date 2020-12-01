package com.bodywithbrain.awsbackend.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;

import java.time.OffsetDateTime;

public class OffsetDateTimeConverter implements DynamoDBTypeConverter<String, OffsetDateTime> {

    ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
    @SneakyThrows
    @Override
    public String convert(final OffsetDateTime offsetDateTime ) {
        return mapper.writeValueAsString(offsetDateTime);
    }

    @SneakyThrows
    @Override
    public OffsetDateTime unconvert(final String stringValue ) {
        return mapper.readValue(stringValue,OffsetDateTime.class);
    }
}