package com.movomx.bluetooth.scanner;

import android.bluetooth.BluetoothAdapter;

public class BluetoothStatus {
  public static boolean isEnabled() {
    return BluetoothAdapter.getDefaultAdapter().isEnabled();
  }
}
