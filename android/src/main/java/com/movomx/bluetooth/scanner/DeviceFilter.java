package com.movomx.bluetooth.scanner;

import java.util.ArrayList;
import java.util.List;

public class DeviceFilter {
  private final List<String> filters;

  public DeviceFilter(List<String> filters) {
    this.filters = toLowcase(filters);
  }

  public boolean match(Device device) {
    if (!hasFilters()) return true;
    return matchBluetoothName(device) || matchMacAddress(device);
  }

  private boolean matchBluetoothName(Device device) {
    String bluetoothName = device.getBluetoothName();
    return bluetoothName != null && inFilters(bluetoothName);
  }

  private boolean matchMacAddress(Device device) {
    String macAddress = device.getMacAddress();
    return inFilters(macAddress);
  }

  private boolean inFilters(String word) {
    String lowcaseWord = format(word);
    for (String filter : filters)
      if (lowcaseWord.contains(filter)) return true;
    return false;
  }

  private List<String> toLowcase(List<String> list) {
    List<String> lowcaseList = new ArrayList<>();
    for (String word : list)
      lowcaseList.add(format(word));
    return lowcaseList;
  }

  private boolean hasFilters() {
    return filters.size() > 0;
  }

  private String format(String word) {
    return word.toLowwerCase().replaceAll(":", "");
  }
}
