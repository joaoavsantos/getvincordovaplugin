package com.daftrucks.getvincordovaplugin;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;

import main.java.com.daftrucks.getvinapi.IGetVinInterface;
import main.java.com.daftrucks.getvinapi.IVinListener;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

public class GetVinPlugin extends CordovaPlugin {
    private static final String TAG = "GetVinPlugin";
    private static final String GET_VIN_ACTION = "com.daf.getvin.ACTION_GET_VIN";
    private static final String GET_VIN_PACKAGE = "com.daftrucks.getvin";
    private static final String GET_VIN_SERVICE = "com.daftrucks.getvin.GetVinService";

    private IGetVinInterface mVinInterface;
    private CallbackContext mCallbackContext;

    private final IVinListener mVinListener = new IVinListener.Stub() {

        @Override
        public void newVin(String vin) {
            sendVin(vin);
        }
    };

    private final ServiceConnection mGetVinConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "Connected to service, waiting for update...");
            mVinInterface = IGetVinInterface.Stub.asInterface(service);
            try {
                mVinInterface.registerVinListener(mVinListener);
            } catch (RemoteException e) {
                Log.e(TAG, "Failed to register VIN listener: " + e.getMessage(), e);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mVinInterface = null;
            Log.i(TAG, "Disconnected from service.");
        }
    };

    @Override
    protected void pluginInitialize() {
        super.pluginInitialize();

        Log.i(TAG, "Binding to service...");
        Intent i = new Intent(GET_VIN_ACTION);
        i.setClassName(GET_VIN_PACKAGE, GET_VIN_SERVICE);
        cordova.getActivity().bindService(i, mGetVinConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        if (mVinInterface != null) {
            try {
                Log.i(TAG, "Unregistering for vin updates.");
                mVinInterface.unregisterVinListener(mVinListener);
            } catch (RemoteException e) {
                // ignoring this, we're cleaning up
            }
        }
        cordova.getActivity().unbindService(mGetVinConnection);
        mVinInterface = null;
    }

    @Override
    public boolean execute(String action, String rawArgs, CallbackContext callbackContext) {
        if (mCallbackContext == null) {
            Log.i(TAG, "First exec(); saving callback context");
            mCallbackContext = callbackContext;
        }
        if ("getVin".equals(action)) {
            IGetVinInterface vinInterface = mVinInterface;
            if (vinInterface != null) {
                try {
                    String vin = vinInterface.getVin();
                    sendVin(vin, callbackContext);
                } catch (RemoteException e) {
                    callbackContext.error(e.getMessage());
                }
            } else {
                PluginResult result = new PluginResult(PluginResult.Status.IO_EXCEPTION);
                result.setKeepCallback(true);
                callbackContext.sendPluginResult(result);
            }
            return true;
        }

        return false;
    }

    private void sendVin(@NonNull String vin) {
        sendVin(vin, mCallbackContext);
    }

    private void sendVin(@NonNull String vin, @NonNull CallbackContext callbackContext) {
        if (callbackContext != null) {
            PluginResult result = new PluginResult(PluginResult.Status.OK, vin);
            result.setKeepCallback(true);
            Log.i(TAG, "Sending plugin result vin=" + (vin.isEmpty() ? "<empty>" : vin));
            callbackContext.sendPluginResult(result);
        }
    }
}
