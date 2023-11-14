import { registerPlugin } from '@capacitor/core';
const BluetoothScanner = registerPlugin('BluetoothScanner', {
    web: () => import('./web').then(m => new m.BluetoothScannerWeb()),
});
export * from './definitions';
export { BluetoothScanner };
//# sourceMappingURL=index.js.map