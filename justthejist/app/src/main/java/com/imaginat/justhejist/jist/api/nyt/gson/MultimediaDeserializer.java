package com.imaginat.justhejist.jist.api.nyt.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by nat on 3/9/16.
 */
public class MultimediaDeserializer implements JsonDeserializer<Multimedia> {
  @Override
  public Multimedia deserialize(JsonElement json, Type typeOfT,
                                JsonDeserializationContext context)
      throws JsonParseException {
    if (json.isJsonArray()) {

      return context.deserialize(json, JSonMultiMedia.class);
    }
    return null;
  }

  class JSonMultiMedia extends Multimedia {}
}
