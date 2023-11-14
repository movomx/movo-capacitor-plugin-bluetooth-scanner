package com.movomx.bluetooth.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.List;

public abstract class ScannerListener
  extends BroadcastReceiver
  implements IListener
{
  private final DeviceList list = new DeviceList();
  private final DeviceFilter filter;

  public ScannerListener(List<String> filters) {
    super();
    filter = new DeviceFilter(filters);
  }

  @Override
  public void onReceive(Context context, Intent intent) {
    if (isDeviceFound(intent)) {
      Device device = DeviceBuilder.create(intent);
      if (!filter.match(device)) return;
      list.add(device);
      onDeviceFound(device);
    }
    else if (isScanFinished(intent))
      scanFinished(list);
    else if (isError(intent))
      onError(new ErrorMessage("An error happened while scanning"));
  }

  private boolean isDeviceFound(Intent intent) {
    return BluetoothDevice.ACTION_FOUND.equals(intent.getAction());
  }

  private boolean isScanFinished(Intent intent) {
    String action = intent.getAction();
    return BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action);
  }

  private boolean isError(Intent intent) {
    String action = intent.getAction();
    if (!BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) return false;
    return isBluetoothAdapterOff(intent) || isBluetoothAdapterTurnOff(intent);
  }

  private int getErrorState(Intent intent) {
    return intent.getIntExtra(
      BluetoothAdapter.EXTRA_STATE,
      BluetoothAdapter.ERROR
    );
  }

  private boolean isBluetoothAdapterOff(Intent intent) {
    return getErrorState(intent) == BluetoothAdapter.STATE_OFF;
  }

  private boolean isBluetoothAdapterTurnOff(Intent intent) {
    return getErrorState(intent) == BluetoothAdapter.STATE_TURNING_OFF;
  }
}
