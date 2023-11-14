var capacitorBluetoothScanner = (function (exports, core) {
    'use strict';

    const BluetoothScanner = core.registerPlugin('BluetoothScanner', {
        web: () => Promise.resolve().then(function () { return web; }).then(m => new m.BluetoothScannerWeb()),
    });

    class BluetoothScannerWeb extends core.WebPlugin {
        async echo(options) {
            console.log('ECHO', options);
            return options;
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
