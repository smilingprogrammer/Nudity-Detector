package com.example.nuditydetector.network;

import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface ApiInterface {

    @Multipart
    @POST("/post_predict_image_file")
    Call
}
