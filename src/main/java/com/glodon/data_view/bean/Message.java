package com.glodon.data_view.bean;

import java.time.LocalDateTime;

/**
 * @author liuwg-a
 * @date 2019/12/12 19:56
 * @description kafka 消息类
 */
public class Message {

    private Long          id;
    private String        msg;
    private LocalDateTime time;

    public Message() {
    }

    public Message(Long id, String msg, LocalDateTime time) {
        this.id = id;
        this.msg = msg;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
