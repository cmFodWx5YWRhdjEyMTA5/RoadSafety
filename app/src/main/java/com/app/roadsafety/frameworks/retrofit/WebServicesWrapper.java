package com.app.roadsafety.frameworks.retrofit;import com.app.roadsafety.model.authentication.FacebookLoginRequest;import com.app.roadsafety.model.authentication.LoginResponse;import com.app.roadsafety.model.feed.FeedListResponse;import com.app.roadsafety.model.feed.FeedResponse;import com.app.roadsafety.model.guidelines.GuidelinesResponse;import com.app.roadsafety.model.region.RegionUpdateRequest;import com.google.gson.Gson;import java.util.List;import java.util.concurrent.TimeUnit;import okhttp3.MultipartBody;import okhttp3.OkHttpClient;import okhttp3.RequestBody;import okhttp3.logging.HttpLoggingInterceptor;import retrofit2.Call;import retrofit2.Retrofit;import retrofit2.converter.gson.GsonConverterFactory;/** * Created by abhishekkumar on 2/7/18. */public class WebServicesWrapper {    //  private final static String BASE_URL = "http://ror.anasource.com:8090";    public final static String BASE_URL = "http://35.180.246.129";    private static WebServicesWrapper wrapper;    protected WebServices webServices;    private Gson gson;    private WebServicesWrapper(String baseUrl) {        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES)                .readTimeout(1, TimeUnit.MINUTES)                .writeTimeout(1, TimeUnit.MINUTES).addInterceptor(interceptor).build();        webServices = new Retrofit.Builder()                .addConverterFactory(GsonConverterFactory.create())                .baseUrl(baseUrl)                .client(client)                .build().create(WebServices.class);        gson = new Gson();    }    public static WebServicesWrapper getInstance() {        if (wrapper == null)            wrapper = new WebServicesWrapper(BASE_URL);        return wrapper;    }    public Call<LoginResponse> facebookLogin(ResponseResolver<LoginResponse> apiResponseResponseResolve, FacebookLoginRequest facebookLoginRequest) {        Call<LoginResponse> apiResponseResponseCall = webServices.facebookLogin(facebookLoginRequest);        apiResponseResponseCall.enqueue(apiResponseResponseResolve);        return apiResponseResponseCall;    }    public Call<LoginResponse> guestLogin(ResponseResolver<LoginResponse> apiResponseResponseResolve) {        Call<LoginResponse> apiResponseResponseCall = webServices.guestLogin();        apiResponseResponseCall.enqueue(apiResponseResponseResolve);        return apiResponseResponseCall;    }    public Call<GuidelinesResponse> getGuidelines(ResponseResolver<GuidelinesResponse> apiResponseResponseResolve,String page) {        Call<GuidelinesResponse> apiResponseResponseCall = webServices.getGuidelines(page);        apiResponseResponseCall.enqueue(apiResponseResponseResolve);        return apiResponseResponseCall;    }    public Call<LoginResponse> setRegion(ResponseResolver<LoginResponse> apiResponseResponseResolve, String authToken, RegionUpdateRequest regionUpdateRequest) {        Call<LoginResponse> apiResponseResponseCall = webServices.setRegion(authToken,regionUpdateRequest);        apiResponseResponseCall.enqueue(apiResponseResponseResolve);        return apiResponseResponseCall;    }    public Call<FeedResponse> getFeedList(ResponseResolver<FeedResponse> apiResponseResponseResolve,String auth_token, String page, String country) {        Call<FeedResponse> apiResponseResponseCall = webServices.getFeedList(auth_token,page,country);        apiResponseResponseCall.enqueue(apiResponseResponseResolve);        return apiResponseResponseCall;    }}