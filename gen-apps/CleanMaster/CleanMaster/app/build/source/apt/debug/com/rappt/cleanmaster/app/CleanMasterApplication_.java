//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.0.1.
//


package com.rappt.cleanmaster.app;


public final class CleanMasterApplication_
    extends CleanMasterApplication
{

    private static CleanMasterApplication INSTANCE_;

    public static CleanMasterApplication getInstance() {
        return INSTANCE_;
    }

    /**
     * Visible for testing purposes
     * 
     */
    public static void setForTesting(CleanMasterApplication application) {
        INSTANCE_ = application;
    }

    @Override
    public void onCreate() {
        INSTANCE_ = this;
        init_();
        super.onCreate();
    }

    private void init_() {
    }

}
