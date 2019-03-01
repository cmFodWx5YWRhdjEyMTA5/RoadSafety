package com.app.roadsafety.frameworks.retrofit;import com.app.roadsafety.model.authentication.FacebookLoginRequest;import com.app.roadsafety.model.authentication.LoginResponse;import com.app.roadsafety.model.feed.FeedResponse;import com.app.roadsafety.model.guidelines.GuidelinesResponse;import com.app.roadsafety.model.region.RegionUpdateRequest;import retrofit2.Call;import retrofit2.http.Body;import retrofit2.http.GET;import retrofit2.http.Header;import retrofit2.http.POST;import retrofit2.http.PUT;import retrofit2.http.Query;public interface WebServices {    @POST("/api/v1/sessions")    Call<LoginResponse> facebookLogin(@Body FacebookLoginRequest facebookLoginRequest);    @POST("/api/v1/users")    Call<LoginResponse> guestLogin();    @GET("/api/v1/guidelines")    Call<GuidelinesResponse> getGuidelines(@Query("page") String page);    @PUT("/api/v1/users/update")    Call<LoginResponse> setRegion(@Header("auth-token") String token, @Body RegionUpdateRequest regionUpdateRequest);    @GET("/api/v1/feeds")    Call<FeedResponse> getFeedList(@Header("auth-token") String token,@Query("page") String page, @Query("country") String country);}