export interface BluetoothScannerPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
}
