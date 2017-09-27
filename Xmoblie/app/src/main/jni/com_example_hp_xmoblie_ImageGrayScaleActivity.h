/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_example_hp_xmoblie_ImageGrayScaleActivity */

#include <opencv2/opencv.hpp>
#include <android/asset_manager_jni.h>
#include <android/log.h>
#include <com_example_hp_xmoblie_ImageGrayScaleActivity.h>
using namespace cv;
using namespace std;
#ifndef _Included_com_example_hp_xmoblie_ImageGrayScaleActivity
#define _Included_com_example_hp_xmoblie_ImageGrayScaleActivity
#ifdef __cplusplus
extern "C" {
#endif
#undef com_example_hp_xmoblie_ImageGrayScaleActivity_PERMISSION_REQUEST_CODE
#define com_example_hp_xmoblie_ImageGrayScaleActivity_PERMISSION_REQUEST_CODE 1L
/*
 * Class:     com_example_hp_xmoblie_ImageGrayScaleActivity
 * Method:    loadImage
 * Signature: (Ljava/lang/String;J)V
 */
JNIEXPORT void JNICALL Java_com_example_hp_xmoblie_ImageGrayScaleActivity_loadImage
  (JNIEnv *, jobject, jstring, jlong) {
    Mat &img_input = *(Mat *) addrImage;

    const char *nativeFileNameString = env->GetStringUTFChars(imageFileName, JNI_FALSE);

    string baseDir("/storage/emulated/0/");
    baseDir.append(nativeFileNameString);
    const char *pathDir = baseDir.c_str();

    img_input = imread(pathDir, IMREAD_COLOR);
}


/*
 * Class:     com_example_hp_xmoblie_ImageGrayScaleActivity
 * Method:    imageprocessing
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_com_example_hp_xmoblie_ImageGrayScaleActivity_imageprocessing
  (JNIEnv *, jobject, jlong, jlong){
    Mat &img_input = *(Mat *) addrInputImage;
    Mat &img_output = *(Mat *) addrOutputImage;

    cvtColor( img_input, img_input, CV_BGR2RGB);
    cvtColor( img_input, img_output, CV_RGB2GRAY);
    blur( img_output, img_output, Size(5,5) );
    Canny( img_output, img_output, 50, 150, 5 );

    };

#ifdef __cplusplus
}
#endif
#endif
