package com.cloud.bluewhale.exception;

import com.cloud.bluewhale.constant.ResponseConstant;

/**
 * @author shigc
 */
public class ErrorParamException extends CustomException{

    public ErrorParamException() {
        super(ResponseConstant.PARAM_INVALID);
    }

    public ErrorParamException(String msg) {
        super(msg);
    }
}
