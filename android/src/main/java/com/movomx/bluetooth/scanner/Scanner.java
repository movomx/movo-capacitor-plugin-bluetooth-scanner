package com.movomx.bluetooth.scanner;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;

public class Scanner {
  private final BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

  @SuppressLint("MissingPermission")
  public void start() {
    adapter.cancelDiscovery();
    adapter.startDiscovery();
  }

  @SuppressLint("MissingPermission")
  public void stop() {
    adapter.cancelDiscovery();
  }
}
