package com.imaginat.justhejist.jist.api.nyt.gson;

import java.util.List;

/**
 * Copyright 2016 Boloutare Doubeni
 *
 * A class that holds the base object returned from the call to the NYT
 * TopStories API
 */
public class TopStoriesResponseEntity {
  /**
   * If the api-key is invalid this field will be filled
   */
  private ApiErrorResponse error;

  /**
   * The return status of the API_CALL
   */
  private String status;

  /**
   * The section that was passed into the API class
   */
  private String section;
  private double num_results;
  private String last_updated;
  private List<Result> results;

  public List<Result> getResults() { return results; }

  public ApiErrorResponse getError() { return error; }

  public void setError(ApiErrorResponse error) { this.error = error; }

  public String getStatus() { return status; }

  public void setStatus(String status) { this.status = status; }

  public String getSection() { return section; }

  public void setSection(String section) { this.section = section; }

  public double getNum_results() { return num_results; }

  public void setNum_results(double num_results) {
    this.num_results = num_results;
  }

  public String getLast_updated() { return last_updated; }

  public void setLast_updated(String last_updated) {
    this.last_updated = last_updated;
  }
}
