/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.joaoavsantos.cordova.plugin;
public interface IGetVinInterface extends android.os.IInterface
{
  /** Default implementation for IGetVinInterface. */
  public static class Default implements com.joaoavsantos.cordova.plugin.IGetVinInterface
  {
    // Get the plain VIN.
    //
    // If there is no connection to the IVI, an empty string is returned.

    @Override public java.lang.String getVin() throws android.os.RemoteException
    {
      return null;
    }
    // Get the plain, last seen, VIN.
    //
    // If there is a connection with the IVI, this returns the current VIN. If there is no
    // connection, this returns the VIN from the last connection with the IVI.
    //
    // If there never has been a connection with the IVI since the application started, then
    // this returns an empty string.
    //String getLastVin();
    // Register a listener for VIN updates.
    //
    // When a listener is registered it is called immediately with the current VIN value.
    // Depending on the history, the VIN may be unknown and an empty string is given.
    //
    // Returns true if the listener is correctly registered.

    @Override public boolean registerVinListener(com.joaoavsantos.cordova.plugin.IVinListener listener) throws android.os.RemoteException
    {
      return false;
    }
    // Unregister a previously registered listener.

    @Override public void unregisterVinListener(com.joaoavsantos.cordova.plugin.IVinListener listener) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.joaoavsantos.cordova.plugin.IGetVinInterface
  {
    private static final java.lang.String DESCRIPTOR = "com.joaoavsantos.cordova.plugin.IGetVinInterface";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.joaoavsantos.cordova.plugin.IGetVinInterface interface,
     * generating a proxy if needed.
     */
    public static com.joaoavsantos.cordova.plugin.IGetVinInterface asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.joaoavsantos.cordova.plugin.IGetVinInterface))) {
        return ((com.joaoavsantos.cordova.plugin.IGetVinInterface)iin);
      }
      return new com.joaoavsantos.cordova.plugin.IGetVinInterface.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_getVin:
        {
          data.enforceInterface(descriptor);
          java.lang.String _result = this.getVin();
          reply.writeNoException();
          reply.writeString(_result);
          return true;
        }
        case TRANSACTION_registerVinListener:
        {
          data.enforceInterface(descriptor);
          com.joaoavsantos.cordova.plugin.IVinListener _arg0;
          _arg0 = com.joaoavsantos.cordova.plugin.IVinListener.Stub.asInterface(data.readStrongBinder());
          boolean _result = this.registerVinListener(_arg0);
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          return true;
        }
        case TRANSACTION_unregisterVinListener:
        {
          data.enforceInterface(descriptor);
          com.joaoavsantos.cordova.plugin.IVinListener _arg0;
          _arg0 = com.joaoavsantos.cordova.plugin.IVinListener.Stub.asInterface(data.readStrongBinder());
          this.unregisterVinListener(_arg0);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.joaoavsantos.cordova.plugin.IGetVinInterface
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      // Get the plain VIN.
      //
      // If there is no connection to the IVI, an empty string is returned.

      @Override public java.lang.String getVin() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getVin, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getVin();
          }
          _reply.readException();
          _result = _reply.readString();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      // Get the plain, last seen, VIN.
      //
      // If there is a connection with the IVI, this returns the current VIN. If there is no
      // connection, this returns the VIN from the last connection with the IVI.
      //
      // If there never has been a connection with the IVI since the application started, then
      // this returns an empty string.
      //String getLastVin();
      // Register a listener for VIN updates.
      //
      // When a listener is registered it is called immediately with the current VIN value.
      // Depending on the history, the VIN may be unknown and an empty string is given.
      //
      // Returns true if the listener is correctly registered.

      @Override public boolean registerVinListener(com.joaoavsantos.cordova.plugin.IVinListener listener) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_registerVinListener, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().registerVinListener(listener);
          }
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      // Unregister a previously registered listener.

      @Override public void unregisterVinListener(com.joaoavsantos.cordova.plugin.IVinListener listener) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_unregisterVinListener, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().unregisterVinListener(listener);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static com.joaoavsantos.cordova.plugin.IGetVinInterface sDefaultImpl;
    }
    static final int TRANSACTION_getVin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_registerVinListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_unregisterVinListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    public static boolean setDefaultImpl(com.joaoavsantos.cordova.plugin.IGetVinInterface impl) {
      // Only one user of this interface can use this function
      // at a time. This is a heuristic to detect if two different
      // users in the same process use this function.
      if (Stub.Proxy.sDefaultImpl != null) {
        throw new IllegalStateException("setDefaultImpl() called twice");
      }
      if (impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.joaoavsantos.cordova.plugin.IGetVinInterface getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  // Get the plain VIN.
  //
  // If there is no connection to the IVI, an empty string is returned.

  public java.lang.String getVin() throws android.os.RemoteException;
  // Get the plain, last seen, VIN.
  //
  // If there is a connection with the IVI, this returns the current VIN. If there is no
  // connection, this returns the VIN from the last connection with the IVI.
  //
  // If there never has been a connection with the IVI since the application started, then
  // this returns an empty string.
  //String getLastVin();
  // Register a listener for VIN updates.
  //
  // When a listener is registered it is called immediately with the current VIN value.
  // Depending on the history, the VIN may be unknown and an empty string is given.
  //
  // Returns true if the listener is correctly registered.

  public boolean registerVinListener(com.joaoavsantos.cordova.plugin.IVinListener listener) throws android.os.RemoteException;
  // Unregister a previously registered listener.

  public void unregisterVinListener(com.joaoavsantos.cordova.plugin.IVinListener listener) throws android.os.RemoteException;
}
