package com.example.hp.xmoblie.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.hp.xmoblie.Activity.FileManagerActivity;
import com.example.hp.xmoblie.Items.DownloadRequestItem;
import com.example.hp.xmoblie.Utill.DownloadMotherThread;
import com.example.hp.xmoblie.Utill.ServiceControlCenter;

import java.io.IOException;

/**
 * Created by HP on 2017-10-30.
 */

public class DownloadManagerService extends Service {
    int length = 0;
    int type = 1;

    long offet = 4096;

    String path = "";
    String token = "";
    String filename = "";

    ApiClient apiClient;

    DownloadMotherThread dlm;

    FileManagerActivity fileManagerActivity;
    IBinder mBinder = new DownloadManagerService.LocalBinder();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        apiClient = ApiClient.severService;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        token = intent.getStringExtra("token");


        return super.onStartCommand(intent, flags, startId);
    }

    public boolean downloadFile(DownloadRequestItem dri,FileManagerActivity fma) throws IOException {
        if (!ServiceControlCenter.getInstance().isAbleDownload()) {
            fileManagerActivity= fma;

            offet = dri.getOffset();
            length = dri.getLength();
            type = dri.getType();
            filename = dri.getFilename();
            path = dri.getPath();

            dlm = new DownloadMotherThread();
            dlm.run(type, filename, path, token, offet, length, this);
            return true;
        } else
            return false;
    }

    public void dead() {
        if (dlm != null && dlm.isAlive()) {
            dlm.interrupt();
            Log.e("kill","kill MT");
        }
        fileManagerActivity.downloadFinish();
    }

    public class LocalBinder extends Binder {
        public DownloadManagerService getServerInstance() {
            return DownloadManagerService.this;

        }
    }
}