package com.spotify.music.exception;

import org.springframework.web.bind.annotation.ResponseStatus;


public class ResourceNotFoundException extends Exception{
  private static final long serialVersionUID = 511507614892486187L;

  public ResourceNotFoundException(String message) {
    super(message);
  }
}
