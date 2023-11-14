var capacitorBluetoothScanner = (function (exports, core) {
    'use strict';

    const BluetoothScanner = core.registerPlugin('BluetoothScanner', {
        web: () => Promise.resolve().then(function () { return web; }).then(m => new m.BluetoothScannerWeb()),
    });

    class BluetoothScannerWeb extends core.WebPlugin {
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

    var web = /*#__PURE__*/Object.freeze({
        __proto__: null,
        BluetoothScannerWeb: BluetoothScannerWeb
    });

    exports.BluetoothScanner = BluetoothScanner;

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
