'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

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
//# sourceMappingURL=plugin.cjs.js.map
