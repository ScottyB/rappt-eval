package com.rappt.twitter.app;

import org.androidannotations.annotations.EApplication;
import org.scribe.oauth.OAuthService;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.Verb;
import org.acra.annotation.ReportsCrashes;
import android.net.Uri;
import org.scribe.builder.ServiceBuilder;
import java.lang.reflect.Field;
import com.rappt.twitter.app.model.*;
import java.util.List;
import org.acra.ACRA;
import retrofit.RequestInterceptor;
import org.scribe.model.Verifier;
import android.app.Application;
import java.util.Map;
import org.scribe.model.Token;
import org.acra.ReportField;
import retrofit.RestAdapter;
import org.scribe.model.OAuthRequest;
import android.util.Log;



@EApplication
@ReportsCrashes(formKey = "",
                mailTo = "sbarnett@swin.edu.au",
customReportContent = {
    ReportField.APP_VERSION_CODE,
    ReportField.APP_VERSION_NAME,
    ReportField.ANDROID_VERSION,
    ReportField.BUILD,
    ReportField.BRAND,
    ReportField.PHONE_MODEL,
    ReportField.DEVICE_FEATURES,
    ReportField.AVAILABLE_MEM_SIZE,
    ReportField.ENVIRONMENT,
    ReportField.DISPLAY,
    ReportField.SETTINGS_SYSTEM,
    ReportField.USER_APP_START_DATE,
    ReportField.USER_CRASH_DATE,
    ReportField.THREAD_DETAILS,
    ReportField.LOGCAT,
    ReportField.EVENTSLOG,
    ReportField.STACK_TRACE
})

public class TwitterApplication extends Application
        implements RequestInterceptor
{

    public static String API_KEY = "Ew9zDPmQ3ehTPeCgsxkc9aOSm";

    public static String VERIFIER_PARAMETER = "oauth_verifier";

    public Token accessToken ;

    public OAuthService oAuthService ;

    public Token requestToken ;

    public String TWITTERAPI_SERVICE = "https://api.twitter.com/1.1";

    public static String API_SECRET = "AxZrH573SQxOzkB4mdqAv3ZmWRvXEldGaPsqT70k1IfkCKScAh";

    public static String API_LOG = "TWITTER_LOG";

    public TwitterApiApi twitterApi ;

    public static String CALLBACK = "http://my-callback.com";


    @Override
    public void onCreate() {
        super.onCreate();
        ACRA.init(this);
    }

    public String fetchAuthURL() {
        oAuthService = new ServiceBuilder()
        .provider(TwitterApi.class)
        .apiKey(API_KEY)
        .apiSecret(API_SECRET)
        .callback(CALLBACK)
        .build();
        requestToken = oAuthService.getRequestToken();
        String temp = oAuthService.getAuthorizationUrl(requestToken);
        return temp;
    }

    public void fetchAccessToken(Uri responseURI) {
        Log.d(API_LOG, responseURI.toString());
        String verifier = responseURI.getQueryParameter(VERIFIER_PARAMETER);
        Log.d(API_LOG, verifier);
        Verifier v = new Verifier(verifier);
        accessToken = oAuthService.getAccessToken(requestToken, v);
        Log.d(API_LOG, accessToken.getRawResponse());
        RestAdapter restAdapter = new RestAdapter.Builder()
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setEndpoint(TWITTERAPI_SERVICE)
        .setRequestInterceptor(this)
        .build();
        Log.d(API_LOG, "Rest adapter built");
        twitterApi = restAdapter.create(TwitterApiApi.class);
    }

    private String getMethod(RequestInterceptor.RequestFacade requestFacade) throws NoSuchFieldException, IllegalAccessException {
        Field requestMethod = requestFacade.getClass().getDeclaredField("requestMethod");
        requestMethod.setAccessible(true);
        return (String) requestMethod.get(requestFacade);
    }

    private String getUrl(RequestInterceptor.RequestFacade requestFacade) throws NoSuchFieldException, IllegalAccessException {
        Field apiUrl = requestFacade.getClass().getDeclaredField("apiUrl");
        apiUrl.setAccessible(true);
        String apiUrlValue = (String) apiUrl.get(requestFacade);
        Field relativeUrl = requestFacade.getClass().getDeclaredField("relativeUrl");
        relativeUrl.setAccessible(true);
        String relativeUrlValue = (String) relativeUrl.get(requestFacade);
        return apiUrlValue + relativeUrlValue;
    }

    @Override
    public void intercept(RequestFacade requestFacade) {
        try {
            String url = getUrl(requestFacade), method = getMethod(requestFacade);
            Log.d(API_LOG, "url: " + url);
            Log.d(API_LOG, "method: " + method);
            OAuthRequest req = new OAuthRequest(Verb.valueOf(method), url);
            oAuthService.signRequest(accessToken, req);
            Log.d(API_LOG, "Request signed");
            for (Map.Entry<String, String> m : req.getHeaders().entrySet()) {
                Log.d(API_LOG, "KEY: " + m.getKey() + " VALUE: " + m.getValue());
                requestFacade.addHeader(m.getKey(), m.getValue());
            }
        } catch (NoSuchFieldException e) {
            Log.d(API_LOG, "No such field: reflection");
        } catch (IllegalAccessException e) {
            Log.d(API_LOG, "Illegal access to fields");
        }
    }


}
