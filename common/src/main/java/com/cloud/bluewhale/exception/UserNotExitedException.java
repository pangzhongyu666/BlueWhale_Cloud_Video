package com.cloud.bluewhale.exception;

import com.cloud.bluewhale.constant.ResponseConstant;

/**
 * @author shigc
 */
public class UserNotExitedException extends CustomException {

    public UserNotExitedException() {
        super(ResponseConstant.USER_NOT_EXIST);
    }

    public UserNotExitedException(String message) {
        super(message);
    }
}
