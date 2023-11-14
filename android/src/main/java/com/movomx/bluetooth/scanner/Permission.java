package com.movomx.bluetooth.scanner;

import android.Manifest;
import android.app.Activity;
import android.os.Build;
import androidx.core.app.ActivityCompat;

public class Permission {
  public static void request(Activity activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
      ActivityCompat.requestPermissions(
        activity,
        new String[] {
          Manifest.permission.BLUETOOTH_SCAN,
          Manifest.permission.BLUETOOTH_CONNECT,
          Manifest.permission.ACCESS_FINE_LOCATION,
          Manifest.permission.ACCESS_COARSE_LOCATION
        },
        1);
    else
      ActivityCompat.requestPermissions(
        activity,
        new String[] {
          Manifest.permission.BLUETOOTH,
          Manifest.permission.BLUETOOTH_ADMIN,
          Manifest.permission.ACCESS_FINE_LOCATION,
          Manifest.permission.ACCESS_COARSE_LOCATION
        },
        1);
  }
}
