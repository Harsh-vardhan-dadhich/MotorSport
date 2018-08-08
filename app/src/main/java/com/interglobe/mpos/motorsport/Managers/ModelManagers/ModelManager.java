package com.interglobe.mpos.motorsport.Managers.ModelManagers;

import com.interglobe.mpos.motorsport.Constants.Constant;
import com.interglobe.mpos.motorsport.Managers.BaseManagers.BaseManager;

/**
 * Created by arms0071 on 8/7/18.
 */

public class ModelManager extends BaseManager implements Constant{


    private final static String TAG = ModelManager.class.getSimpleName();
    //Static Properties
    private static ModelManager _ModelManager;



    /**
     * private constructor make it to be Singleton class
     */
    private ModelManager() {
    }

    /**
     * method to create a threadsafe singleton class instance
     *
     * @return a thread safe singleton object of model manager
     */
    public static synchronized ModelManager modelManager() {
        if (_ModelManager == null) {
            _ModelManager = new ModelManager();

        }
        return _ModelManager;
    }


    /**
     * to initialize the singleton object
     */
    public void initializeModelManager() {
        System.out.println("ModelManager object initialized.");
    }

}
