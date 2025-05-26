package com.cloud.bluewhale.exception;

import com.cloud.bluewhale.constant.ResponseConstant;

/**
 * @author shigc
 */
public class PasswordErrorException extends CustomException{

        public PasswordErrorException() {
            super(ResponseConstant.PASSWORD_ERROR);
        }

        public PasswordErrorException(String msg) {
            super(msg);
        }
}
