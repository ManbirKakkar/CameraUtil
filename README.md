# CameraUtil

Implementation

    allprojects {
    		repositories {
    			...
    			maven { url 'https://jitpack.io' }
    		}
    	}
    	
Add Dependency

    dependencies {
    	        implementation 'com.github.ManbirKakkar:CameraUtil:Tag'
    	        
    	        }    	
    	    
Java 1.8 is required to use the lib. Add the following line in build.gradle

    compileOptions {
              targetCompatibility 1.8
              sourceCompatibility 1.8
           }
           
           
# Usage


To check if permission of camera is enabled

    CameraUtil(this).isCameraPermissionAvailable()
    
Request Permission for camera    

     CameraUtil(this).requestCameraPermission()
     
To get image from camera

    CameraUtil(this).getImageFromCamera()

To get image from gallery

    CameraUtil(this).getImageFromGallery()

To show image popup and select from either camera or gallery

     CameraUtil(this).showImagePickerDialog()
     
     
If you wish to convert image into file, you need to check write permission

    CameraUtil(this).isWritePermission()   
    
You can request write permission by directly calling

    CameraUtil(this).requestWritePermission()      

Directly set image to imageview by calling

    override fun onActivityResult(requestCode: Int, resultCode: Int, imageReturnedIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent)

          CameraUtil(this).setImageInView(requestCode, resultCode, imageReturnedIntent, ivImageView)
        }

    }
    
    


Receive image from onActivityResult

        override fun onActivityResult(requestCode: Int, resultCode: Int, imageReturnedIntent: Intent?) {
            super.onActivityResult(requestCode, resultCode, imageReturnedIntent)
        
            if (resultCode == Activity.RESULT_OK) {
            
            //Recieve image as bitmap
                var bitmap = CameraUtil(this).getImageAsBitmap(requestCode, resultCode, imageReturnedIntent) as Bitmap
                ivImageView.setImageBitmap(bitmap)
    
                //convert image to file
                var file = CameraUtil(this).bitmapToFile(bitmap)
            }
    
        }
    
    }