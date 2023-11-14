import { registerPlugin } from '@capacitor/core';

import type { BluetoothScannerPlugin } from './definitions';

const BluetoothScanner = registerPlugin<BluetoothScannerPlugin>(
  'BluetoothScanner',
  {
    web: () => import('./web').then(m => new m.BluetoothScannerWeb()),
  },
);

export * from './definitions';
export { BluetoothScanner };
