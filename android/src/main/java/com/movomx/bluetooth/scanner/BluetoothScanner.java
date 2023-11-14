package com.movomx.bluetooth.scanner;

import android.annotation.SuppressLint;
import android.content.Context;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import java.util.List;

public class BluetoothScanner {
  private Scanner scanner;
  private ScannerListener listener;
  private RegisterReceiver registerReceiver;
  private PluginCall deviceFoundCall;
  private PluginCall scanFinishedCall;

  public BluetoothScanner setContext(Context context) {
    registerReceiver = new RegisterReceiver(context);
    return this;
  }

  @SuppressLint("UnspecifiedRegisterReceiverFlag")
  public void scan(List<String> filters) {
    if (listener != null) registerReceiver.unregister(listener);
    listener = createListener(filters);
    scanner = new Scanner();
    scanner.start();
    registerReceiver.register(listener);
  }

  public void stop() {
    if (scanner == null) return;
    registerReceiver.unregister(listener);
    scanner.stop();
  }

  public void setDeviceFoundCall(PluginCall call) {
    deviceFoundCall = call;
  }

  public void setScanFinishedCall(PluginCall call) {
    scanFinishedCall = call;
  }

  private ScannerListener createListener(List<String> filters) {
    return new ScannerListener(filters) {
      @Override
      public void onDeviceFound(Device device) {
        deviceFoundCall.resolve(device.toJson());
      }

      @Override
      public void scanFinished(DeviceList list) {
        if (scanFinishedCall == null) return;
        JSObject json = new JSObject();
        json.put("devices", list.toJson());
        scanFinishedCall.resolve(json);
      }

      @Override
      public void onError(ErrorMessage message) {
        scanFinishedCall.reject("Error on scanning", message.toJson());
        stop();
      }
    };
  }
}
