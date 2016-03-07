package com.imaginat.justhejist.jist.api.nyt.gson;

/**
 * Copyright 2016 Boloutare Doubeni
 *
 * An class to hold media data returned from the Top Stories API
 */
public class Multimedia
{
  private String height;

  private String subtype;

  private String width;

  private String caption;

  private String copyright;

  private String format;

  private String type;

  private String url;

  public String getHeight ()
  {
    return height;
  }

  public void setHeight (String height)
  {
    this.height = height;
  }

  public String getSubtype ()
  {
    return subtype;
  }

  public void setSubtype (String subtype)
  {
    this.subtype = subtype;
  }

  public String getWidth ()
  {
    return width;
  }

  public void setWidth (String width)
  {
    this.width = width;
  }

  public String getCaption ()
  {
    return caption;
  }

  public void setCaption (String caption)
  {
    this.caption = caption;
  }

  public String getCopyright ()
  {
    return copyright;
  }

  public void setCopyright (String copyright)
  {
    this.copyright = copyright;
  }

  public String getFormat ()
  {
    return format;
  }

  public void setFormat (String format)
  {
    this.format = format;
  }

  public String getType ()
  {
    return type;
  }

  public void setType (String type)
  {
    this.type = type;
  }

  public String getUrl ()
  {
    return url;
  }

  public void setUrl (String url)
  {
    this.url = url;
  }
}
