/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.joaoavsantos.cordova.plugin;
// Declare any non-default types here with import statements

public interface IVinListener extends android.os.IInterface
{
  /** Default implementation for IVinListener. */
  public static class Default implements com.daftrucks.getvinapi.IVinListener
  {
    // Report a new VIN value.
    //
    // When no VIN is known, an empty string is used.
    //
    // This shall never use null.

    @Override public void newVin(java.lang.String vin) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.daftrucks.getvinapi.IVinListener
  {
    private static final java.lang.String DESCRIPTOR = "com.daftrucks.getvinapi.IVinListener";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.daftrucks.getvinapi.IVinListener interface,
     * generating a proxy if needed.
     */
    public static com.daftrucks.getvinapi.IVinListener asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.daftrucks.getvinapi.IVinListener))) {
        return ((com.daftrucks.getvinapi.IVinListener)iin);
      }
      return new com.daftrucks.getvinapi.IVinListener.Stub.Proxy(obj);
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
        case TRANSACTION_newVin:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          this.newVin(_arg0);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.daftrucks.getvinapi.IVinListener
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
      // Report a new VIN value.
      //
      // When no VIN is known, an empty string is used.
      //
      // This shall never use null.

      @Override public void newVin(java.lang.String vin) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(vin);
          boolean _status = mRemote.transact(Stub.TRANSACTION_newVin, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().newVin(vin);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static com.daftrucks.getvinapi.IVinListener sDefaultImpl;
    }
    static final int TRANSACTION_newVin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    public static boolean setDefaultImpl(com.daftrucks.getvinapi.IVinListener impl) {
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
    public static com.daftrucks.getvinapi.IVinListener getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  // Report a new VIN value.
  //
  // When no VIN is known, an empty string is used.
  //
  // This shall never use null.

  public void newVin(java.lang.String vin) throws android.os.RemoteException;
}
