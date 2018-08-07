package com.interglobe.mpos.motorsport.Managers.APIManagers;

import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by arms0071 on 8/7/18.
 */

public interface APIRequestHelper {


    //Api to update the location of user for app
    String kUpdateUserLocation="userdetail/updateUserLocation";

    /**
     * set api request with api key and corresponding parameters
     * @param APIKey  key of the url
     * @param details details contains request body parameters
     * @param files   if include file will be sent in multipart
     * @return JsonObject ie. response
     */
    @Multipart
    @POST()
    Call<JsonObject> APIRequestWithFile(
            @Url String APIKey,
            @PartMap Map<String, RequestBody> details,
            @Part List<MultipartBody.Part> files
    );


    @POST()
    Call<JsonObject> APIRequestRaw(
            @Url String APIKey,
            @Body RequestBody params
    );

    @GET("maps/api/geocode/json")
    Call<JsonObject> getLocation(
            @Query("latlng") String latlng,
            @Query("key") String key
    );

    @GET("maps/api/geocode/json")
    Call<JsonObject> getCordinates(
            @Query("address") String address,
            @Query("key") String key
    );



}
