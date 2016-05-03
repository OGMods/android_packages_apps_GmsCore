/*
 * Copyright 2013-2015 microG Project Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.microg.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import com.mgoogle.android.gms.common.api.Status;
import com.mgoogle.android.gms.location.ActivityRecognitionResult;
import com.mgoogle.android.gms.location.Geofence;
import com.mgoogle.android.gms.location.GeofencingRequest;
import com.mgoogle.android.gms.location.GestureRequest;
import com.mgoogle.android.gms.location.ILocationListener;
import com.mgoogle.android.gms.location.LocationAvailability;
import com.mgoogle.android.gms.location.LocationRequest;
import com.mgoogle.android.gms.location.LocationSettingsRequest;
import com.mgoogle.android.gms.location.LocationSettingsResult;
import com.mgoogle.android.gms.location.LocationSettingsStates;
import com.mgoogle.android.gms.location.internal.IGeofencerCallbacks;
import com.mgoogle.android.gms.location.internal.IGoogleLocationManagerService;
import com.mgoogle.android.gms.location.internal.ISettingsCallbacks;
import com.mgoogle.android.gms.location.internal.LocationRequestInternal;
import com.mgoogle.android.gms.location.internal.LocationRequestUpdateData;
import com.mgoogle.android.gms.location.places.AutocompleteFilter;
import com.mgoogle.android.gms.location.places.NearbyAlertRequest;
import com.mgoogle.android.gms.location.places.PlaceFilter;
import com.mgoogle.android.gms.location.places.PlaceReport;
import com.mgoogle.android.gms.location.places.PlaceRequest;
import com.mgoogle.android.gms.location.places.UserAddedPlace;
import com.mgoogle.android.gms.location.places.UserDataType;
import com.mgoogle.android.gms.location.places.internal.IPlacesCallbacks;
import com.mgoogle.android.gms.location.places.internal.PlacesParams;
import com.mgoogle.android.gms.maps.model.LatLng;
import com.mgoogle.android.gms.maps.model.LatLngBounds;

import java.util.Arrays;
import java.util.List;

public class GoogleLocationManagerServiceImpl extends IGoogleLocationManagerService.Stub {
    private static final String TAG = "GmsLocManagerSvcImpl";

    private final Context context;
    private GoogleLocationManager locationManager;

    public GoogleLocationManagerServiceImpl(Context context) {
        this.context = context;
    }

    private GoogleLocationManager getLocationManager() {
        if (locationManager == null)
            locationManager = new GoogleLocationManager(context);
        return locationManager;
    }

    @Override
    public void addGeofencesList(List<Geofence> geofences, PendingIntent pendingIntent,
                                 IGeofencerCallbacks callbacks, String packageName) throws RemoteException {
        Log.d(TAG, "addGeofencesList: " + geofences);
    }

    @Override
    public void removeGeofencesByIntent(PendingIntent pendingIntent, IGeofencerCallbacks callbacks,
                                        String packageName) throws RemoteException {
        Log.d(TAG, "removeGeofencesByIntent: " + pendingIntent);
    }

    @Override
    public void removeGeofencesById(String[] geofenceRequestIds, IGeofencerCallbacks callbacks,
                                    String packageName) throws RemoteException {
        Log.d(TAG, "removeGeofencesById: " + Arrays.toString(geofenceRequestIds));
    }

    @Override
    public void removeAllGeofences(IGeofencerCallbacks callbacks, String packageName) throws RemoteException {
        Log.d(TAG, "removeAllGeofences");
    }

    @Override
    public void requestActivityUpdates(long detectionIntervalMillis, boolean alwaysTrue,
                                       PendingIntent callbackIntent) throws RemoteException {
        Log.d(TAG, "requestActivityUpdates: " + callbackIntent);
    }

    @Override
    public void removeActivityUpdates(PendingIntent callbackIntent) throws RemoteException {
        Log.d(TAG, "removeActivityUpdates: " + callbackIntent);
    }

    @Override
    public ActivityRecognitionResult getLastActivity(String packageName) throws RemoteException {
        Log.d(TAG, "getLastActivity");
        return null;
    }

    @Override
    public Status iglms65(PendingIntent pendingIntent) throws RemoteException {
        Log.d(TAG, "iglms65");
        return null;
    }

    @Override
    public Status iglms66(PendingIntent pendingIntent) throws RemoteException {
        Log.d(TAG, "iglms66");
        return null;
    }

    @Override
    public Status requestGestureUpdates(GestureRequest request, PendingIntent pendingIntent) throws RemoteException {
        Log.d(TAG, "requestGestureUpdates");
        return null;
    }

    @Override
    public Status iglms61(PendingIntent pendingIntent) throws RemoteException {
        Log.d(TAG, "iglms61");
        return null;
    }

    @Override
    public Location getLastLocation() throws RemoteException {
        Log.d(TAG, "getLastLocation");
        return getLocationManager().getLastLocation(null);
    }

    @Override
    public void requestLocationUpdatesWithListener(LocationRequest request,
                                                   final ILocationListener listener) throws RemoteException {
        Log.d(TAG, "requestLocationUpdatesWithListener: " + request);
        getLocationManager().requestLocationUpdates(request, listener, null);
    }

    @Override
    public void requestLocationUpdatesWithIntent(LocationRequest request,
                                                 PendingIntent callbackIntent) throws RemoteException {
        Log.d(TAG, "requestLocationUpdatesWithIntent: " + request);
        getLocationManager().requestLocationUpdates(request, callbackIntent, null);
    }

    @Override
    public void removeLocationUpdatesWithListener(ILocationListener listener)
            throws RemoteException {
        Log.d(TAG, "removeLocationUpdatesWithListener: " + listener);
        getLocationManager().removeLocationUpdates(listener, null);
    }

    @Override
    public void removeLocationUpdatesWithIntent(PendingIntent callbackIntent)
            throws RemoteException {
        Log.d(TAG, "removeLocationUpdatesWithIntent: " + callbackIntent);
        getLocationManager().removeLocationUpdates(callbackIntent, null);
    }

    @Override
    public void updateLocationRequest(LocationRequestUpdateData locationRequestUpdateData) throws RemoteException {
        Log.d(TAG, "updateLocationRequest: " + locationRequestUpdateData);
        getLocationManager().updateLocationRequest(locationRequestUpdateData);
    }

    @Override
    public void setMockMode(boolean mockMode) throws RemoteException {
        Log.d(TAG, "setMockMode: " + mockMode);
        getLocationManager().setMockMode(mockMode);
    }

    @Override
    public void setMockLocation(Location mockLocation) throws RemoteException {
        Log.d(TAG, "setMockLocation: " + mockLocation);
        getLocationManager().setMockLocation(mockLocation);
    }

    @Override
    public void iglms14(LatLngBounds var1, int var2, PlaceFilter var3, PlacesParams var4,
                        IPlacesCallbacks var5) throws RemoteException {
        Log.d(TAG, "iglms14: " + var1);
    }

    @Override
    public void iglms15(String var1, PlacesParams var2, IPlacesCallbacks var3)
            throws RemoteException {
        Log.d(TAG, "iglms15: " + var1);
    }

    @Override
    public void iglms16(LatLng var1, PlaceFilter var2, PlacesParams var3, IPlacesCallbacks var4)
            throws RemoteException {
        Log.d(TAG, "iglms16: " + var1);
    }

    @Override
    public void iglms17(PlaceFilter var1, PlacesParams var2, IPlacesCallbacks var3)
            throws RemoteException {
        Log.d(TAG, "iglms17: " + var1);
    }

    @Override
    public void iglms18(PlaceRequest var1, PlacesParams var2, PendingIntent var3)
            throws RemoteException {
        Log.d(TAG, "iglms18: " + var1);
    }

    @Override
    public void iglms19(PlacesParams var1, PendingIntent var2) throws RemoteException {
        Log.d(TAG, "iglms19: " + var1);
    }

    @Override
    public void requestLocationUpdatesWithPackage(LocationRequest request, ILocationListener listener,
                                                  String packageName) throws RemoteException {
        Log.d(TAG, "requestLocationUpdatesWithPackage: " + request);
        getLocationManager().requestLocationUpdates(request, listener, packageName);
    }

    @Override
    public Location getLastLocationWithPackage(String packageName) throws RemoteException {
        Log.d(TAG, "getLastLocationWithPackage: " + packageName);
        return getLocationManager().getLastLocation(packageName);
    }

    @Override
    public void iglms25(PlaceReport var1, PlacesParams var2) throws RemoteException {
        Log.d(TAG, "iglms25: " + var1);
    }

    @Override
    public void iglms26(Location var1, int var2) throws RemoteException {
        Log.d(TAG, "iglms26: " + var1);
    }

    @Override
    public LocationAvailability iglms34(String var1) throws RemoteException {
        Log.d(TAG, "iglms34: " + var1);
        return null;
    }

    @Override
    public void iglms42(String var1, PlacesParams var2, IPlacesCallbacks var3)
            throws RemoteException {
        Log.d(TAG, "iglms42: " + var1);
    }

    @Override
    public void iglms46(UserAddedPlace var1, PlacesParams var2, IPlacesCallbacks var3)
            throws RemoteException {
        Log.d(TAG, "iglms46: " + var1);
    }

    @Override
    public void iglms47(LatLngBounds var1, int var2, String var3, PlaceFilter var4,
                        PlacesParams var5, IPlacesCallbacks var6) throws RemoteException {
        Log.d(TAG, "iglms47: " + var1);
    }

    @Override
    public void iglms48(NearbyAlertRequest var1, PlacesParams var2, PendingIntent var3)
            throws RemoteException {
        Log.d(TAG, "iglms48: " + var1);
    }

    @Override
    public void iglms49(PlacesParams var1, PendingIntent var2) throws RemoteException {
        Log.d(TAG, "iglms49: " + var1);
    }

    @Override
    public void iglms50(UserDataType var1, LatLngBounds var2, List var3, PlacesParams var4,
                        IPlacesCallbacks var5) throws RemoteException {
        Log.d(TAG, "iglms50: " + var1);
    }

    @Override
    public IBinder iglms51() throws RemoteException {
        Log.d(TAG, "iglms51");
        return null;
    }

    @Override
    public void requestLocationSettingsDialog(LocationSettingsRequest settingsRequest, ISettingsCallbacks callback, String packageName) throws RemoteException {
        Log.d(TAG, "requestLocationSettingsDialog: " + settingsRequest);
        callback.onLocationSettingsResult(new LocationSettingsResult(new LocationSettingsStates(true, true, false, true, true, false), Status.CANCELED));
    }

    @Override
    public void requestLocationUpdatesInternalWithListener(LocationRequestInternal request,
                                                           ILocationListener listener) throws RemoteException {
        Log.d(TAG, "requestLocationUpdatesInternalWithListener: " + request);
        getLocationManager().requestLocationUpdates(request.request, listener, null);
    }

    @Override
    public void requestLocationUpdatesInternalWithIntent(LocationRequestInternal request,
                                                         PendingIntent callbackIntent) throws RemoteException {
        Log.d(TAG, "requestLocationUpdatesInternalWithIntent: " + request);
        getLocationManager().requestLocationUpdates(request.request, callbackIntent, null);
    }

    @Override
    public IBinder iglms54() throws RemoteException {
        Log.d(TAG, "iglms54");
        return null;
    }

    @Override
    public void iglms55(String var1, LatLngBounds var2, AutocompleteFilter var3, PlacesParams var4,
                        IPlacesCallbacks var5) throws RemoteException {
        Log.d(TAG, "iglms55: " + var1);
    }

    @Override
    public void addGeofences(GeofencingRequest geofencingRequest, PendingIntent pendingIntent,
                             IGeofencerCallbacks callbacks) throws RemoteException {
        Log.d(TAG, "addGeofences: " + geofencingRequest);
    }

    @Override
    public void iglms58(List var1, PlacesParams var2, IPlacesCallbacks var3)
            throws RemoteException {
        Log.d(TAG, "iglms58: " + var1);
    }

    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        if (super.onTransact(code, data, reply, flags)) return true;
        Log.d(TAG, "onTransact [unknown]: " + code + ", " + data + ", " + flags);
        return false;
    }
}
