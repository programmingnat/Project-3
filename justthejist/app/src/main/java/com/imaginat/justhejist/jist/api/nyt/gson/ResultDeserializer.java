package com.imaginat.justhejist.jist.api.nyt.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Copyright 2016 Boloutare Doubeni
 *
 * A custom deserializer for result objects
 */
public class ResultDeserializer implements JsonDeserializer<Result> {

  @Override
  public Result deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    return null;
  }
}
