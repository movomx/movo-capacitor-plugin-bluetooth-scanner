import { WebPlugin } from '@capacitor/core';

import type { BluetoothScannerPlugin } from './definitions';

export class BluetoothScannerWeb
  extends WebPlugin
  implements BluetoothScannerPlugin
{
  async scan(options?: { filter?: Array<string> }): Promise<{ action: string }> {
    console.log(options);
    return { action: 'scanning process started...' };
  }
  async scanStop(): Promise<{ action: string }> {
    console.log('stoppping scanning');
    return { action: 'stopping scanning' };
  };
  async onDeviceFound(): Promise<{ bluetooth_name: string, mac_address: string, state: string }> {
    console.log('onDeviceFound');
    return { bluetooth_name: '', mac_address: '', state: '' };
  }
  async onScanFinished(): Promise<Array<{ bluetooth_name: string, mac_address: string, state: string }>> {
    return [];
  }
}
