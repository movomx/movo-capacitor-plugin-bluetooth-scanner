package com.movomx.bluetooth.scanner;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import java.util.List;

public class DeviceMapper {
  public JSObject toJson(Device device) {
    JSObject json = new JSObject();
    json.put("bluetooth_name", device.getBluetoothName());
    json.put("mac_address", device.getMacAddress());
    json.put("state", device.getState());
    return json;
  }

  public JSArray toJson(List<Device> list) {
    JSArray json = new JSArray();
    for (Device device : list)
      json.put(device.toJson());
    return json;
  }
}
