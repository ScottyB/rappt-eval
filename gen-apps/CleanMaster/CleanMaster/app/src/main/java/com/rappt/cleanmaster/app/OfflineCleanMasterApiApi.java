package com.rappt.cleanmaster.app;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonSyntaxException;
import com.rappt.cleanmaster.app.model.*;
import java.util.Collection;
import android.widget.ImageView;
import java.io.IOException;
import android.graphics.drawable.Drawable;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import android.util.Log;
import java.io.InputStream;



public class OfflineCleanMasterApiApi
        implements CleanMasterApiApi
{

    public List<Hot> hotApps ( ) {
        Type collectionType = new TypeToken<List<Hot>>() {} .getType();
        return (List<Hot>)throwExceptions(collectionType, "HotApps.json");

    }

    public static String ERROR_API = "";
    Context context;

    public OfflineCleanMasterApiApi(Context context) {
        this.context = context;
    }

    Object throwExceptions(Type type, String jsonFile) {
        try {
            Gson gson = new Gson();
            Thread.sleep(2000);
            return gson.fromJson(readFileFromAssets(jsonFile, context), type);
        } catch (JsonSyntaxException e) {
            Log.e(ERROR_API, jsonFile + " contains a syntax error " + e.getMessage());
        } catch (IOException e) {
            Log.e(ERROR_API, jsonFile + " could not be found");
        } catch (InterruptedException e) {
            Log.e (ERROR_API, e.getMessage());
        }
        return new Object();
    }

    public String readFileFromAssets(String fileName, Context c) throws IOException {
        InputStream is = c.getAssets().open(fileName);
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        String text = new String(buffer);
        return text;
    }



}
