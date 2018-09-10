package com.seo.permissionutil;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

public abstract class PermissionUtil {
    final static String TAG = "PermissionUtil";

    // CALENDAR
    public static final int MY_PERMISSIONS_REQUEST_READ_CALENDAR = 1;
    public static final int MY_PERMISSIONS_REQUEST_WRITE_CALENDAR = 2;
    // CAMERA
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 3;
    // CONTACTS
    public static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 4;
    public static final int MY_PERMISSIONS_REQUEST_WRITE_CONTACTS = 5;
    public static final int MY_PERMISSIONS_REQUEST_GET_ACCOUNTS = 6;
    // LOCATION
    public static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 7;
    public static final int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 8;
    // MICROPHONE
    public static final int MY_PERMISSIONS_REQUEST_RECORD_AUDIO = 9;
    // PHONE
    public static final int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 10;
    public static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 11;
    public static final int MY_PERMISSIONS_REQUEST_READ_CALL_LOG = 12;
    public static final int MY_PERMISSIONS_REQUEST_WRITE_CALL_LOG = 13;
    public static final int MY_PERMISSIONS_REQUEST_ADD_VOICEMAIL = 14;
    public static final int MY_PERMISSIONS_REQUEST_USE_SIP = 15;
    public static final int MY_PERMISSIONS_REQUEST_PROCESS_OUTGOING_CALLS = 16;
    // SENSORS
    public static final int MY_PERMISSIONS_REQUEST_BODY_SENSORS = 17;
    // SMS
    public static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 18;
    public static final int MY_PERMISSIONS_REQUEST_RECEIVE_SMS = 19;
    public static final int MY_PERMISSIONS_REQUEST_READ_SMS = 20;
    public static final int MY_PERMISSIONS_REQUEST_RECEIVE_WAP_PUSH = 21;
    public static final int MY_PERMISSIONS_REQUEST_RECEIVE_MMS = 22;
    // STORAGE
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 23;
    public static final int MY_PERMISSIONS_REQUEST_READ_WRITE_EXTERNAL_STORAGE = 24;

    public Context context;

    public abstract void allow();

    public PermissionUtil(Context context, String permisson) {
        this.context = context;

        if (checkSelfPermission(context, permisson)) {
            // 권한 없음
            Log.d(TAG, "권한 없어");
            requestPermission(context, permisson);
        } else {
            // 권한 있음
            Log.d(TAG, "권한 있어");
            allow();
        }
    }

    // 권한 체크
    private boolean checkSelfPermission(Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED) {
            return true;
        } else {
            return false;
        }
    }

    // 권한 취득
    private void requestPermission(Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permission)) {
                // 권한 한이 필요한 이유에 대한 설명 다이얼로그를 표시하여아 하지만 임시로 다시 권한요청하는 함수를 호출
                ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, myPermissionRequest(permission));
                Log.d(TAG, "권한 취득 함수 트루");
            } else {
                // 권한요청에 대한 결과값 반환
                ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, myPermissionRequest(permission));
                Log.d(TAG, "권한 취득 함수 펄스");
            }
        } else {
            allow();
        }
    }

    private int myPermissionRequest(String permission) {
        int result = -1;
        switch (permission) {
            case Manifest.permission.READ_CALENDAR:
                result = MY_PERMISSIONS_REQUEST_READ_CALENDAR;
                break;
            case Manifest.permission.WRITE_CALENDAR:
                result = MY_PERMISSIONS_REQUEST_WRITE_CALENDAR;
                break;
            case Manifest.permission.CAMERA:
                result = MY_PERMISSIONS_REQUEST_CAMERA;
                break;
            case Manifest.permission.READ_CONTACTS:
                result = MY_PERMISSIONS_REQUEST_READ_CONTACTS;
                break;
            case Manifest.permission.WRITE_CONTACTS:
                result = MY_PERMISSIONS_REQUEST_WRITE_CONTACTS;
                break;
            case Manifest.permission.GET_ACCOUNTS:
                result = MY_PERMISSIONS_REQUEST_GET_ACCOUNTS;
                break;
            case Manifest.permission.ACCESS_FINE_LOCATION:
                result = MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION;
                break;
            case Manifest.permission.ACCESS_COARSE_LOCATION:
                result = MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION;
                break;
            case Manifest.permission.RECORD_AUDIO:
                result = MY_PERMISSIONS_REQUEST_RECORD_AUDIO;
                break;
            case Manifest.permission.READ_PHONE_STATE:
                result = MY_PERMISSIONS_REQUEST_READ_PHONE_STATE;
                break;
            case Manifest.permission.CALL_PHONE:
                result = MY_PERMISSIONS_REQUEST_CALL_PHONE;
                break;
            case Manifest.permission.READ_CALL_LOG:
                result = MY_PERMISSIONS_REQUEST_READ_CALL_LOG;
                break;
            case Manifest.permission.WRITE_CALL_LOG:
                result = MY_PERMISSIONS_REQUEST_WRITE_CALL_LOG;
                break;
            case Manifest.permission.ADD_VOICEMAIL:
                result = MY_PERMISSIONS_REQUEST_ADD_VOICEMAIL;
                break;
            case Manifest.permission.USE_SIP:
                result = MY_PERMISSIONS_REQUEST_USE_SIP;
                break;
            case Manifest.permission.PROCESS_OUTGOING_CALLS:
                result = MY_PERMISSIONS_REQUEST_PROCESS_OUTGOING_CALLS;
                break;
            case Manifest.permission.BODY_SENSORS:
                result = MY_PERMISSIONS_REQUEST_BODY_SENSORS;
                break;
            case Manifest.permission.SEND_SMS:
                result = MY_PERMISSIONS_REQUEST_SEND_SMS;
                break;
            case Manifest.permission.RECEIVE_SMS:
                result = MY_PERMISSIONS_REQUEST_RECEIVE_SMS;
                break;
            case Manifest.permission.READ_SMS:
                result = MY_PERMISSIONS_REQUEST_READ_SMS;
                break;
            case Manifest.permission.RECEIVE_WAP_PUSH:
                result = MY_PERMISSIONS_REQUEST_RECEIVE_WAP_PUSH;
                break;
            case Manifest.permission.RECEIVE_MMS:
                result = MY_PERMISSIONS_REQUEST_RECEIVE_MMS;
                break;
            case Manifest.permission.READ_EXTERNAL_STORAGE:
                result = MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE;
                break;
            case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                result = MY_PERMISSIONS_REQUEST_READ_WRITE_EXTERNAL_STORAGE;
                break;

        }

        return result;
    }

}