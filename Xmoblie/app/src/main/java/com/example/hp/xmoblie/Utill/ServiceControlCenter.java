package com.example.hp.xmoblie.Utill;

import com.example.hp.xmoblie.Service.DownloadManagerService;
import com.example.hp.xmoblie.Service.NotificationBarService;

/**
 * Created by HP on 2017-11-02.
 */

public class ServiceControlCenter {
    private static ServiceControlCenter instance;

    DownloadManagerService downloadManagerService;
    NotificationBarService notificationBarService;

    public static ServiceControlCenter getInstance() {
        if (instance == null)
            return instance = new ServiceControlCenter();
        else
            return instance;
    }

    public void setDownloadManagerService(DownloadManagerService downloadManagerService) {
        this.downloadManagerService = downloadManagerService;
    }

    public void setNotificationBarService(NotificationBarService notificationBarService) {
        this.notificationBarService = notificationBarService;
    }

    public DownloadManagerService getDownloadManagerService() {
        return downloadManagerService;
    }

    public NotificationBarService getNotificationBarService() {
        return notificationBarService;
    }

    public void downloadFinish(){
        downloadManagerService = null;
    }

    public boolean isAbleDownload(){
        if(downloadManagerService == null)
            return true;
        else
            return false;
    }

}
