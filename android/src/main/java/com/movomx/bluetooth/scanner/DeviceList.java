package com.movomx.bluetooth.scanner;

import androidx.annotation.NonNull;
import com.getcapacitor.JSArray;
import java.util.ArrayList;
import java.util.List;

public class DeviceList {
  private final List<Device> list = new ArrayList<>();
  private final DeviceMapper mapper = new DeviceMapper();

  public void add(Device device) {
    list.add(device);
  }

  public JSArray toJson() {
    return mapper.toJson(list);
  }

  @NonNull
  @Override
  public String toString() {
    return toJson().toString();
  }
}
