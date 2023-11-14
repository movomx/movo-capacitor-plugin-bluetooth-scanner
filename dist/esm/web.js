import { WebPlugin } from '@capacitor/core';
export class BluetoothScannerWeb extends WebPlugin {
    async scan(options) {
        console.log(options);
        return { action: 'scanning process started...' };
    }
    async scanStop() {
        console.log('stoppping scanning');
        return { action: 'stopping scanning' };
    }
    ;
    async onDeviceFound() {
        console.log('onDeviceFound');
        return { bluetooth_name: '', mac_address: '', state: '' };
    }
    async onScanFinished() {
        return [];
    }
}
//# sourceMappingURL=web.js.map