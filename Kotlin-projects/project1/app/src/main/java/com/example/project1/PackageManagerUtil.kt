package com.example.project1

import android.content.pm.PackageManager
import android.content.pm.Signature
import android.os.Build
import android.os.Message
import androidx.annotation.RequiresApi
import com.google.common.io.BaseEncoding
import java.lang.Exception
import java.security.MessageDigest

class PackageManagerUtil {

    @RequiresApi(Build.VERSION_CODES.P)
    fun getSignature(pm: PackageManager, packageName: String): String? {
        return try {
            val packageInfo =
                pm.getPackageInfo(packageName, PackageManager.GET_SIGNING_CERTIFICATES)
            if (packageInfo?.signatures == null
                || packageInfo.signatures.isEmpty()
                || packageInfo.signatures[0] == null
            ) {
                null
            } else {
                signatureDigest(packageInfo.signatures[0])
            }
        } catch (e: java.lang.Exception) {
            null
        }
    }

    private fun signatureDigest(sig: Signature): String? {
        val signature = sig.toByteArray()
        return try {
            val md = MessageDigest.getInstance("SHA1")
            val digest = md.digest(signature)
            BaseEncoding.base16().lowerCase().encode(digest)
        } catch (e: Exception) {
            null
        }
    }
}