package com.interglobe.mpos.motorsport.Managers.BaseManagers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.google.gson.Gson;
import com.interglobe.mpos.motorsport.Constants.Constant;
import com.interglobe.mpos.motorsport.Models.BaseModel;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by arms0071 on 8/7/18.
 */

public class BaseManager {

    /********************************Statuc Methods for SharedPreferences**********************************/
    /**stores dataObject to SharedPreferences and commit the user default. This must be called in main thread*/
    public synchronized static void saveDataIntoPreferences(Object dataObject, String key)   {
        Gson gson = new Gson();
        String json = gson.toJson(dataObject);

        SharedPreferences sharedPreferences = ApplicationManager.getContext().getSharedPreferences(BaseModel.kAppPreferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, json);
        prefsEditor.commit();
    }

    /**Return the dataObject of type typeOfT class if successfull. if fail to get data from SharedPreferences then returns null*/
    public synchronized static <T> T getDataFromPreferences(String key, Type typeOfT)   {
        SharedPreferences sharedPreferences = ApplicationManager.getContext().getSharedPreferences(BaseModel.kAppPreferences, Context.MODE_PRIVATE);
        T dataObject = null;
        try {
            Gson gson = new Gson();
            String jsonString = sharedPreferences.getString(key, Constant.kEmptyString);
            dataObject = gson.fromJson(jsonString, typeOfT);
        }catch (Exception e)    {
            e.printStackTrace();
        }
        return dataObject;
    }
    /********************************Statuc Methods for SharedPreferences**********************************/


    public static List<ApplicationInfo> getAppInfo(){
        PackageManager packageManager = ApplicationManager.getContext().getPackageManager();
        List<ApplicationInfo> info = packageManager.getInstalledApplications(0);



        return info;
    }

    /**Get the app name if available under android:label tag in Manifest file. if not specified then return kDefaultAppName*/
    public static String getAppName()   {
        String appName = Constant.kDefaultAppName;

        try {
            ApplicationInfo applicationInfo = ApplicationManager.getContext().getApplicationInfo();
            int stringId = applicationInfo.labelRes;
            appName = (stringId == 0 ? applicationInfo.nonLocalizedLabel.toString() : ApplicationManager.getContext().getString(stringId));
        }catch (Exception e)    {
            e.printStackTrace();
        }
        finally {
            return appName;
        }
    }
}
