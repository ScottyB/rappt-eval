package com.rappt.gumtree.app;

import android.app.AlertDialog;
import android.net.ConnectivityManager;
import android.content.Context;
import android.os.Bundle;
import retrofit.RetrofitError;
import android.support.v4.app.FragmentActivity;
import android.net.NetworkInfo;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;



public class ErrorDialog extends DialogFragment  {

    public static final String MSG = "msg";
    private Dialog mDialog;

    public static ErrorDialog newInstance(String msg) {
        ErrorDialog frag = new ErrorDialog();
        Bundle args = new Bundle();
        args.putString(MSG, msg);
        frag.setArguments(args);
        return frag;
    }

    private void setDialog(Dialog dialog) {
        mDialog = dialog;
    }

    public static void showError(FragmentActivity activity, String message) {
        ErrorDialog.newInstance(message).show(activity.getSupportFragmentManager(), "ErrorDialog");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (mDialog == null) {
            String msg = getArguments().getString(MSG);
            mDialog = new AlertDialog.Builder(getActivity(), AlertDialog.THEME_HOLO_LIGHT)
            .setTitle("Error")
            .setMessage(msg)
            .setPositiveButton("OK",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    dialog.dismiss();
                }
            }
                              )
            .create();
        }
        return mDialog;
    }

    private static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
        = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void showError(FragmentActivity activity, Exception e) {
        String message = e.getMessage() == null ? "" : e.getMessage();
        if (!isNetworkAvailable(activity)) {
            message = activity.getResources().getString(R.string.no_internet_connection);
        } else if (message.contains("No authentication challenges found")) {
            message = activity.getResources().getString(R.string.wrong_password_email);
        } else if (e instanceof RetrofitError) {
            RetrofitError retrofitError = (RetrofitError)e;
            message = activity.getResources().getString(R.string.retrofit_error)
                      + " " + retrofitError.getUrl()
                      + " " + retrofitError.getResponse().getReason()
                      + " " + retrofitError.getResponse().getStatus();
            if (retrofitError.getResponse().getStatus() == 403) {
                message += "\nUsing https?";
            }
        }
        ErrorDialog.newInstance(message).show(activity.getSupportFragmentManager(), "ErrorDialog");
    }



}
