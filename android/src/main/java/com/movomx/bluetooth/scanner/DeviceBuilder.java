package com.movomx.bluetooth.scanner;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;

public class DeviceBuilder {
  public static Device create(Intent intent) {
    BluetoothDevice bluetoothDevice;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
      bluetoothDevice = extract(intent);
    else
      bluetoothDevice = extractOld(intent);
    return new Device(bluetoothDevice);
  }

  @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
  private static BluetoothDevice extract(Intent intent) {
    return intent.getParcelableExtra(
      BluetoothDevice.EXTRA_DEVICE,
      BluetoothDevice.class
    );
  }

  private static BluetoothDevice extractOld(Intent intent) {
    return intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
  }
}
