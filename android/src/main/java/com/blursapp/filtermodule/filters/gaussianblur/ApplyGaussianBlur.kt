package com.blursapp.filtermodule.filters.gaussianblur

import android.graphics.Bitmap
import android.util.Base64
import org.opencv.android.Utils
import org.opencv.core.Mat
import org.opencv.core.Size
import org.opencv.imgproc.Imgproc
import java.io.ByteArrayOutputStream

object GaussianBlurFilter {

    fun applyToBitmap(inputBitmap: Bitmap, sigmaX: Double): Bitmap {
        val src = Mat()
        val dst = Mat()

        // Convert Bitmap to OpenCV Mat
        Utils.bitmapToMat(inputBitmap, src)

        // Apply Gaussian Blur
        Imgproc.GaussianBlur(src, dst, Size(15.0, 15.0), sigmaX)

        // Convert back to Bitmap
        val resultBitmap = Bitmap.createBitmap(dst.cols(), dst.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(dst, resultBitmap)

        // Clean up
        src.release()
        dst.release()

        return resultBitmap
    }

    fun apply(base64: String, sigmaX: Double): String {
        val decodedBytes = Base64.decode(base64, Base64.DEFAULT)
        val inputBitmap = android.graphics.BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)

        val resultBitmap = applyToBitmap(inputBitmap, sigmaX)

        val outputStream = ByteArrayOutputStream()
        resultBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        val resultBytes = outputStream.toByteArray()

        return Base64.encodeToString(resultBytes, Base64.DEFAULT)
    }
}
