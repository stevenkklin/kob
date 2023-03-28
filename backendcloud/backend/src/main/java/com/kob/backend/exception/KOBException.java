package com.kob.backend.exception;

import lombok.Data;

/**
 * @author Steven
 * @create 2022-12-07-14:11
 */


@Data
public class KOBException extends RuntimeException{
    private String msg;
    private int code = 500;

    public KOBException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public KOBException(String msg, Throwable e){
        super(msg,e);
        this.msg = msg;
    }

    public KOBException(String msg, int code){
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public KOBException(String msg, int code , Throwable e){
        super(msg,e);
        this.msg = msg;
        this.code = code;
    }

}
