package com.movomx.bluetooth.scanner;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

public class RegisterReceiver {
  private final Context context;

  public RegisterReceiver(Context context) {
    this.context = context;
  }

  @SuppressLint("UnspecifiedRegisterReceiverFlag")
  public void register(BroadcastReceiver listener) {
    try {
      IntentFilter intent = ScannerIntentBuilder.create();
      context.registerReceiver(listener, intent);
    }
    catch (Exception ignored) {}
  }

  public void unregister(BroadcastReceiver listener) {
    try {
      context.unregisterReceiver(listener);
    }
    catch (Exception ignored) {}
  }
}
