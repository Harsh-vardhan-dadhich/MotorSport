package com.interglobe.mpos.motorsport.Managers.BaseManagers;

import android.content.Context;
import android.os.StrictMode;
import android.support.multidex.MultiDexApplication;

import com.interglobe.mpos.motorsport.Managers.APIManagers.ReachabilityManager;
import com.interglobe.mpos.motorsport.Managers.ModelManagers.ModelManager;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by arms0071 on 8/7/18.
 */

public class ApplicationManager extends MultiDexApplication {
    //Static Properties
    private static Context _Context;

    public static Context getContext() {
        return _Context;
    }

    public static ApplicationManager getInstance() {
        return (ApplicationManager) _Context;
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _Context = this;


        //to initial Leak canary **not be removed
        if (LeakCanary.isInAnalyzerProcess(this)) {
            //this process is dedicated to LeakCanary for heap analysis.
            //you should not init your app in this process
            return;
        }
        //LeakCanary.install(this);

        enableStrictMode();

        //We must initialize the ModelManager singleton object at the time of application launch.
        ModelManager.modelManager().initializeModelManager();
    }

    public static void setConnectivityListener(ReachabilityManager.ConnectivityReceiverListener listener) {
        ReachabilityManager._ConnectivityReceiverListener = listener;
    }

    /**
     * detects things you might be doing by accident and brings them to your attention so you can fix them
     * @link https://developer.android.com/reference/android/os/StrictMode.html
     */
    private void enableStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()   // or .detectAll() for all detectable problems
                .penaltyLog()
                .build());

    }

}
