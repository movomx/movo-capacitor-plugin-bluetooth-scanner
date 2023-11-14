import { WebPlugin } from '@capacitor/core';
import type { BluetoothScannerPlugin } from './definitions';
export declare class BluetoothScannerWeb extends WebPlugin implements BluetoothScannerPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
}
