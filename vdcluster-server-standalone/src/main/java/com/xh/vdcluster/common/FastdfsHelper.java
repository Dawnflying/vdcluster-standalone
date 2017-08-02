package com.xh.vdcluster.common;

import org.csource.fastdfs.*;
import org.csource.fastdfs.ProtoCommon.RecvPackageInfo;
/**
 * Created by macbookpro on 17/7/26.
 */
public class FastdfsHelper {
    public static StorageClient storageClient;
    static {
        try{
        // 创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
        // 创建一个TrackerServer对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 声明一个StorageServer对象，null。
        StorageServer storageServer = null;
        // 获得StorageClient对象。
         storageClient = new StorageClient(trackerServer, storageServer);}
        catch (Exception e){

        }
    }

    public static String uploadFile(String localpath) throws Exception{
        String picUrl = "";
        // 直接调用StorageClient对象方法上传文件即可。
        String[] strings;

        // 获得文件后缀名
        String suffix = localpath.substring(localpath.lastIndexOf(".") + 1);
        strings = storageClient.upload_file(localpath, suffix, null);
        for (String string : strings) {
            System.out.println(string);
            picUrl = picUrl + "/" + string;

        }
        return picUrl;
    }

}
