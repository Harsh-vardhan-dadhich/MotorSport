package com.interglobe.mpos.motorsport.Constants.Blocks;

import com.interglobe.mpos.motorsport.Constants.Constant;

/**
 * Created by arms0071 on 8/7/18.
 * Blocks provide the block declarations of different methods that can
 * be used anywhere in the project to pass as a block.
 * Generic block interface declaration for lambda expression
 */

public interface Block {

    /****************************Block Interface Declaration**********************************/
    @FunctionalInterface
    interface Finished   {
        void iFinished(boolean isFinished);
    }

    @FunctionalInterface
    interface Status     {
        void iStatus(Constant.Status iStatus);
    }

    @FunctionalInterface
    interface Success<T>    {
        void iSuccess(Constant.Status iStatus, GenricResponse<T> response);
    }

    @FunctionalInterface
    interface Failure    {
        void iFailure(Constant.Status iStatus, String error);
    }

    /**If task fail than in response send the error message, If sucessfull, then send the data in response object.*/
    @FunctionalInterface
    interface Completion<T> {
        void iCompletion(Constant.Status iStatus, GenricResponse<T> response);
    }
/****************************Block Interface Declaration**********************************/
}
