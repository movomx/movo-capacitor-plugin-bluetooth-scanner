import { WebPlugin } from '@capacitor/core';
import type { BluetoothScannerPlugin } from './definitions';
export declare class BluetoothScannerWeb extends WebPlugin implements BluetoothScannerPlugin {
    scan(options?: {
        filter?: Array<string>;
    }): Promise<{
        action: string;
    }>;
    stopScan(): Promise<{
        action: string;
    }>;
    onDeviceFound(): Promise<{
        bluetooth_name: string;
        mac_address: string;
        state: string;
    }>;
    onScanFinished(): Promise<Array<{
        bluetooth_name: string;
        mac_address: string;
        state: string;
    }>>;
}
