package com.example.nuditydetector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.nuditydetector.databinding.ActivityMainBinding;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    String filePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        uploadImage();
    }

    private void uploadImage() {

        File file = new File(filePath);
        RequestBody requestBody = RequestBody.create(MediaType.parse(""), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("newImage", file.getName(), requestBody);

        RequestBody someData = RequestBody.create(MediaType.parse(""), "");
    }
}