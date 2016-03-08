package com.imaginat.justhejist.jist.api.nyt;

import java.util.Arrays;

/**
 * Copyright 2016 Boloutare Doubeni
 *
 * Contains the code for making the API to the times api
 */
public class NYTApi {

  /*package*/ static final String API_KEY =
      "56fdb568f4650663376b28f5493fa58d:5:71410972";
  public static final String BASE_URL = "http://api.nytimes.com/svc/";

  private static final String TOPSTORIES_URL = BASE_URL + "topstories/v1/";
  private static final String FORMAT = ".json";

  private static NYTApi INSTANCE = null;

  /**
   * @param section A valid NYT section see Section.java
   *
   * @return
   */
  public static String getSectionURL(String section) {
    // NOTE(boloutaredoubeni): This whole section is just so we don't mess up,
    // it should be removed later or put into a test
    if (section == null || section.isEmpty()) {
      // don't pass empty or null strings
      throw new IllegalArgumentException(
          "Passed an empty or null section name");
    }

    if (!Arrays.asList(Section.getSections()).contains(section)) {
      throw new IllegalArgumentException(
          "The section passed was not a valid section");
    }

    return TOPSTORIES_URL + section + FORMAT + "?api-key=" + API_KEY;
  }

  public NYTApi getClient() {
    if (INSTANCE == null) {
      INSTANCE = new NYTApi();
    }
    return INSTANCE;
  }
}
