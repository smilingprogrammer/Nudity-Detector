package com.example.nuditydetector;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nuditydetector.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static final int CAMERA_PERMISSION_CODE = 223;
    private static final int READ_STORAGE_PERMISSION_CODE = 144;
    private static final int WRITE_STORAGE_PERMISSION_CODE = 144;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String [] options = {"camera", "gallery"};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Pick an Option");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
    }

    public void checkPermission(String permission, int requestCode) {
        //checking if granted or not
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
            //Take Permission
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{}, requestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE){
            if (!(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_DENIED)){
                Toast.makeText(MainActivity.this, "Camera Permission Denied", Toast.LENGTH_SHORT).show();
            } else {
                checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, READ_STORAGE_PERMISSION_CODE);
            }
        } else if (requestCode == READ_STORAGE_PERMISSION_CODE) {
            if (!(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                Toast.makeText(MainActivity.this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            } else {
                checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, WRITE_STORAGE_PERMISSION_CODE);
            }
        } else if (requestCode == WRITE_STORAGE_PERMISSION_CODE) {
            if (!(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                Toast.makeText(MainActivity.this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}