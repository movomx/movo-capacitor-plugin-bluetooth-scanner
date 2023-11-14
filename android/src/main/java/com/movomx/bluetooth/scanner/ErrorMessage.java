package com.movomx.bluetooth.scanner;

import androidx.annotation.NonNull;
import com.getcapacitor.JSObject;

public class ErrorMessage {
  private String message = "";

  public ErrorMessage(String message) {
    this.message = message;
  }

  public JSObject toJson() {
    JSObject json = new JSObject();
    json.put("message", message);
    return json;
  }

  @NonNull
  @Override
  public String toString() {
    return toJson().toString();
  }
}
