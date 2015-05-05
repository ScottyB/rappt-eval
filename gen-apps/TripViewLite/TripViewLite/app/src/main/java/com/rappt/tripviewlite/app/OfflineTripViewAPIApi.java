package com.rappt.tripviewlite.app;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonSyntaxException;
import java.util.Collection;
import android.widget.ImageView;
import java.io.IOException;
import com.rappt.tripviewlite.app.model.*;
import android.graphics.drawable.Drawable;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import android.util.Log;
import java.io.InputStream;



public class OfflineTripViewAPIApi
        implements TripViewAPIApi
{

    public List<Delays> delays ( ) {
        Type collectionType = new TypeToken<List<Delays>>() {} .getType();
        return (List<Delays>)throwExceptions(collectionType, "Delays.json");

    }

    public static String ERROR_API = "";
    Context context;

    public OfflineTripViewAPIApi(Context context) {
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