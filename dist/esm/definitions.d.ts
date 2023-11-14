export interface BluetoothScannerPlugin {
    scan(options?: {
        filter?: Array<string>;
    }): Promise<{
        action: string;
    }>;
    scanStop(): Promise<{
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
