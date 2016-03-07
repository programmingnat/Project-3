package com.imaginat.justhejist.jist.api.nyt.gson;

/**
 * Copyright 2016 Boloutare Doubeni
 *
 * A class to hold the json errors returned from he database
 */
public class ApiErrorResponse {
  private double code;
  private String message;

  public double getCode() {
    return code;
  }

  public void setCode(double code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
