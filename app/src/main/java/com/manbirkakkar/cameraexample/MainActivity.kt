package com.manbirkakkar.cameraexample

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manbirkakkar.camerautility.CameraUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!CameraUtil(this).isCameraPermissionAvailable()) {
            CameraUtil(this).requestCameraPermission()
        }


        btnCamera.setOnClickListener {
            CameraUtil(this).getImageFromCamera()
        }

        btnGallery.setOnClickListener {
            CameraUtil(this).getImageFromGallery()
        }

        btnSelector.setOnClickListener {
            CameraUtil(this).showImagePickerDialog()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, imageReturnedIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent)

        //    CameraUtil(this).setImageInView(requestCode, resultCode, imageReturnedIntent, ivImageView)

        if (resultCode == Activity.RESULT_OK) {
            var bitmap = CameraUtil(this).getImageAsBitmap(requestCode, resultCode, imageReturnedIntent) as Bitmap
            ivImageView.setImageBitmap(bitmap)

            var file = CameraUtil(this).bitmapToFile(bitmap)
        }

    }

}
