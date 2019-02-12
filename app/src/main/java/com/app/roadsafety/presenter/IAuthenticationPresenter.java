package com.app.roadsafety.presenter;

import com.app.roadsafety.frameworks.basemvp.IBaseView;
import com.app.roadsafety.model.authentication.FacebookLoginRequest;
import com.app.roadsafety.model.authentication.LoginResponse;

public interface IAuthenticationPresenter {

    public void guestLogin();

    public void facebookLogin(FacebookLoginRequest facebookLoginRequest);

    void onDestroy();
    interface IAuthenticationView extends IBaseView {

        public void getFacebookLoginResponse(LoginResponse response);

        public void getGuestUserResponse(LoginResponse response);

        public void getResponseError(String response);


    }
}
