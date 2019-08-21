package com.espressif.blufi;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattCallback;

import java.util.List;

import com.espressif.blufi.params.BlufiConfigureParams;
import com.espressif.blufi.response.BlufiStatusResponse;
import com.espressif.blufi.response.BlufiVersionResponse;

public class BlufiClient {
    private BlufiClientImpl mImpl;

    public BlufiClient() {
        mImpl = new BlufiClientImpl(this);
    }

    public BlufiClient(BlufiCallback callback) {
        mImpl = new BlufiClientImpl(this, callback);
    }

    /**
     * Set the callback
     *
     * @param callback the BlufiCallback
     */
    public void setBlufiCallback(BlufiCallback callback) {
        mImpl.setBlufiCallback(callback);
    }

    /**
     * Close the client
     */
    public void close() {
        mImpl.close();
    }

    /**
     * Call this function in
     * {@link BluetoothGattCallback#onCharacteristicChanged(BluetoothGatt, BluetoothGattCharacteristic)}
     *
     * @param gatt BluetoothGatt
     * @param characteristic BluetoothGattCharacteristic
     */
//    public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
//        mImpl.onCharacteristicChanged(gatt, characteristic);
//    }

    /**
     * Call this function in
     * {@link BluetoothGattCallback#onCharacteristicWrite(BluetoothGatt, BluetoothGattCharacteristic, int)}
     *
     * @param gatt BluetoothGatt
     * @param characteristic BluetoothGattCharacteristic
     * @param status gatt status
     */
//    public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
//        mImpl.onCharacteristicWrite(gatt, characteristic, status);
//    }

    /**
     * Set the maximum length of each packet of data, the excess part will be subcontracted.
     *
     * @param lengthLimit the maximum length
     */
    public void setPostPackageLengthLimit(int lengthLimit) {
        mImpl.setPostPackageLengthLimit(lengthLimit);
    }

    /**
     * Request to get device version. The result will notified in
     * {@link BlufiCallback#onDeviceVersionResponse(BlufiClient, int, BlufiVersionResponse)}
     */
    public void requestDeviceVersion() {
        mImpl.requestDeviceVersion();
    }

    /**
     * Request to get device current status. The result will be notified in
     * {@link BlufiCallback#onDeviceStatusResponse(BlufiClient, int, BlufiStatusResponse)}
     */
    public void requestDeviceStatus() {
        mImpl.requestDeviceStatus();
    }

    /**
     * Negotiate security with device. The result will be notified in
     * {@link BlufiCallback#onNegotiateSecurityResult(BlufiClient, int)}
     */
    public void negotiateSecurity() {
        mImpl.negotiateSecurity();
    }

    /**
     * Configure the device to a station or soft AP. The posted result will be notified in
     * {@link BlufiCallback#onConfigureResult(BlufiClient, int)}
     *
     * @param params the config parameter
     */
    public void configure(final BlufiConfigureParams params) {
        mImpl.configure(params);
    }

    /**
     * Request to get wifi list that the device scanned. The wifi list will be notified in
     * {@link BlufiCallback#onDeviceScanResult(BlufiClient, int, List)}
     */
    public void requestDeviceWifiScan() {
        mImpl.requestDeviceWifiScan();
    }

    public void writeDone() {
        mImpl.writeDone();
    }

    public void inputData(byte[] data) {
        mImpl.inputData(data);
    }

    /**
     * Request to post custom data to device. The posted result will be notified in
     * {@link BlufiCallback#onPostCustomDataResult(BlufiClient, int, byte[])}
     *
     * @param data the custom data
     */
    public void postCustomData(byte[] data) {
        mImpl.postCustomData(data);
    }

    /**
     * Request device to disconnect the ble connection
     */
    public void requestCloseConnection() {
        mImpl.requestCloseConnection();
    }
}
