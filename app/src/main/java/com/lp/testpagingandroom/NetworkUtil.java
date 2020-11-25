package com.lp.testpagingandroom;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 * @Author: liupan
 * @Date: 2020/11/24
 */
public class NetworkUtil {

    public static void networkChanged(){
        ConnectivityManager connectivityManager = (ConnectivityManager)CustomApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), new NetworkCallbackImpl());

    }

    public static boolean isNetworkConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) CustomApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            return capabilities != null ? capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) : false;
        } else {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null ? networkInfo.isConnectedOrConnecting() : false;
        }
    }

    private static class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback{

        @Override
        public void onAvailable(@NonNull Network network) {
            super.onAvailable(network);
            Log.e("network---can", "网络可用");
        }

        @Override
        public void onLost(@NonNull Network network) {
            super.onLost(network);
            Log.e("network---lost", "网络可用");
        }

        @Override
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            if(networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)){
                if(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)){
                    Log.e("network---info", " WI-FI");
                }else {
                    Log.e("network---info", " mobile");
                }
            }
        }
    }
}
