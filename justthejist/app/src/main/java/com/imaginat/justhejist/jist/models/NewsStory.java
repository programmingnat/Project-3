package com.imaginat.justhejist.jist.models;

import com.imaginat.justhejist.jist.api.nyt.gson.Result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright 2016 Boloutare Doubeni
 *
 * A class that holds the news story data for the main view.
 *
 * TODO(boloutaredoubeni): add the multimedia
 */
public class NewsStory {

  private final String mSummary;
  private final String mAuthor;
  private final String mTitle;
  private final String mUrl;
  private final String mSection;
  private Set<String> mKeywords;

  private NewsStory(String title, String author, String summary, String url, String section, Set<String> keywords) {
    mTitle = title;
    mAuthor = author;
    mSummary = summary;
    mUrl = url;
    mSection = section;
  }

  public String getTitle() {
    return mTitle;
  }

  public String getAuthor() {
    return mAuthor;
  }

  public String getSummary() {
    return mSummary;
  }

  public String getUrl() {
    return mUrl;
  }

  public String getSection() {
    return mSection;
  }

  public Set<String> getKeywords() {
    return mKeywords;
  }

  public static List<NewsStory> createFrom(List<Result> results) {
    List<NewsStory> newsStories = new ArrayList<>();
    for (final Result result : results) {
      Builder builder = new Builder();
      NewsStory story = builder
          .author(result.getByline())
          .summary(result.getAbstract())
          .title(result.getTitle())
          .url(result.getUrl())
          .section(result.getSection())
          .build();
      newsStories.add(story);
    }
    return newsStories;
  }

  public static class Builder {
    private String mAuthor;
    private String mSummary;
    private String mTitle;
    private String mUrl;
    private String mSection;
    private Set<String> mKeywords = new HashSet<>();

    Builder() {}

    Builder author(String author) {
      mAuthor = author;
      return this;
    }

    Builder summary(String summary) {
      mSummary = summary;
      return this;
    }

    Builder title(String title) {
      mTitle = title;
      return this;
    }

    Builder url(String url) {
      mUrl = url;
      return this;
    }

    Builder section(String section) {
      mSection = section;
      return this;
    }

    Builder multimedia(Object object) {
      // FIXME(boloutaredoubeni): Not implemented yet
      return this;
    }

    Builder keyword(String word) {
      mKeywords.add(word);
      return this;
    }

    Builder keyword(List<String> words) {
      mKeywords.addAll(words);
      return this;
    }

    NewsStory build() {
      return new NewsStory(mTitle, mAuthor, mSummary, mUrl, mSection, mKeywords);
    }
  }
}
