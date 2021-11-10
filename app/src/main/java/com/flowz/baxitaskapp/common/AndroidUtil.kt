package com.flowz.byteworksjobtask.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


fun AppCompatActivity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun showSnackbar(view: View, string: String) {

        Snackbar.make(view, string, Snackbar.LENGTH_LONG).show()
    }

fun TextInputEditText.takeWords() : String{
    return this.text.toString().trim()
}

fun clearTexts(views: Array<TextInputEditText>) {
    views.forEach {
        it.text?.clear()
    }
}

fun FromStringToDate(string: String?): Date {
    val dtStart = "2010-10-15T09:27:37Z"
    var d = Date()
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    try {
        val date = format.parse(dtStart)
        d = date
        System.out.println(date)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return d
}


fun FromDateToString(string: String): String {
    var dateString = ""
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    try {
        val date = Date()
        val dateTime = dateFormat.format(date)
        dateString = dateTime
        println("Current Date Time : $dateTime")
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return dateString
}

fun getCountry(): String? {
    val locale: Locale = Locale.getDefault()
    val country: String = java.lang.String.valueOf(locale.getCountry())
    return country.toLowerCase()
}


@Suppress("DEPRECATION")
fun getConnectionType(context: Context): Boolean {
    var result = false
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        cm?.run {
            cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                if (hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    result = true
                } else if (hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    result = true
                }
            }
        }
    } else {
        cm?.run {
            cm.activeNetworkInfo?.run {
                if (type == ConnectivityManager.TYPE_WIFI) {
                    result = true
                } else if (type == ConnectivityManager.TYPE_MOBILE) {
                    result = true
                }
            }
        }
    }
    return result

}

