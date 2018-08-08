package com.interglobe.mpos.motorsport.Models;

import android.util.Log;

import com.interglobe.mpos.motorsport.Constants.Constant;

import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * Created by arms0071 on 8/8/18.
 */

public class BaseModel implements Constant {

    private static final String TAG = BaseModel.class.getSimpleName();
    //*********************************Public Static Methods*******************************************/
    /**To check for nil, if value nil then return @""*/
    private static Object properValue(Object value)   {
        if(value == null  || value.equals("") || ((value instanceof String) && value.equals(Constant.kEmptyString)))  {
            return  Constant.kEmptyString;
        }
        else{
            return value;
        }
    }

    /**Return the nonnull value of type Object and ensure for integrity of data in models corresponding to key*/
    @SuppressWarnings("unchecked")
    public static <T> T getValue(JSONObject jsonResponse, String key, Type type)    {
        try {
            if(type == Boolean.class)   {
                return (T) Boolean.valueOf(jsonResponse.get(key).equals(1));
            }
            else     {
                return (T)properValue(jsonResponse.get(key));
            }
        } catch (Exception e) {
            Log.e(TAG," "+e);
            if(type == String.class)    {
                return (T)Constant.kEmptyString;
            }
            else if(type == Integer.class || type == Double.class)  {
                return (T)Constant.kEmptyNumber;       //Defualt value
            }
            else if(type == Boolean.class)  {
                return (T) Boolean.FALSE;
            }
            else {
                return (T)Constant.kEmptyString;
            }
        }
    }

}
