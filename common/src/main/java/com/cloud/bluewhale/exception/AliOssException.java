package com.cloud.bluewhale.exception;

/**
 * @author c'y'x
 */
public class AliOssException extends CustomException{
    public AliOssException(){
        super("阿里上传文件异常");
    }
    public AliOssException(String msg){
        super(msg);
    }

}
