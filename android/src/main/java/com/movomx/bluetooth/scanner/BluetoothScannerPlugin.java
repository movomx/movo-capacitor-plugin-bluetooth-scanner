package com.movomx.bluetooth.scanner;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.util.ArrayList;
import java.util.List;

@CapacitorPlugin(name = "BluetoothScanner")
public class BluetoothScannerPlugin extends Plugin {

  private final BluetoothScanner bluetoothScanner = new BluetoothScanner();

  @Override
  public void load() {
    super.load();
    Permission.request(bridge.getActivity());
  }

  @PluginMethod
  public void scan(PluginCall call) {
    if (!BluetoothStatus.isEnabled()) reject(call);
    else {
      bluetoothScanner
        .setContext(bridge.getContext())
        .scan(toList(call));
      JSObject json = new JSObject();
      json.put("action", "scanning process started...");
      call.resolve(json);
    }
  }

  @PluginMethod
  public void stopScan(PluginCall call) {
    if (!BluetoothStatus.isEnabled()) reject(call);
    else {
      bluetoothScanner.stop();
      JSObject json = new JSObject();
      json.put("action", "stopping scanning...");
      call.resolve(json);
    }
  }

  @PluginMethod
  public void onDeviceFound(PluginCall call) {
    bluetoothScanner.setDeviceFoundCall(call);
    call.setKeepAlive(true);
  }

  @PluginMethod
  public void onScanFinished(PluginCall call) {
    bluetoothScanner.setScanFinishedCall(call);
    call.setKeepAlive(true);
  }

  private List<String> toList(PluginCall call) {
    JSArray list = call.getArray("filter");
    try {
      return list.toList();
    } catch (Exception e) {
      return new ArrayList<>();
    }
  }

  private void reject(PluginCall call) {
    JSObject json = new JSObject();
    json.put("message", "The bluetooth is not enabled");
    call.reject("The bluetooth is not enabled", json);
  }
}
