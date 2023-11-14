package com.movomx.bluetooth.scanner;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import androidx.annotation.NonNull;
import com.getcapacitor.JSObject;

public class Device {
  private final BluetoothDevice device;
  private final DeviceMapper mapper = new DeviceMapper();

  public Device(BluetoothDevice device) {
    this.device = device;
  }

  @SuppressLint("MissingPermission")
  public String getBluetoothName() {
    return device.getName();
  }

  public String getMacAddress() {
    return device.getAddress().toUpperCase();
  }

  @SuppressLint("MissingPermission")
  public String getState() {
    if (device.getBondState() == BluetoothDevice.BOND_BONDED) return "bonded";
    if (device.getBondState() == BluetoothDevice.BOND_BONDING) return "bonding";
    return "unbounded";
  }

  public JSObject toJson() {
    return mapper.toJson(this);
  }

  @NonNull
  @Override
  public String toString() {
    return toJson().toString();
  }
}
