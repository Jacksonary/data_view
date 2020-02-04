package com.glodon.data_view.enums;

/**
 * @author liuwg-a
 * @date 2019/11/10 17:01
 * @description
 */
public enum DataScreenStatus {
    /**
     * 2种数据屏状态
     */
    UNPUBLISHED((byte) 0),
    PUBLISHED((byte) 1);
    Byte code;

    DataScreenStatus(Byte code) {
        this.code = code;
    }

    public Byte getCode() {
        return code;
    }

    public static DataScreenStatus parse(Byte code) {
        if (code == null) {
            return null;
        }
        for (DataScreenStatus dss : DataScreenStatus.values()) {
            if (dss.getCode().equals(code)) {
                return dss;
            }
        }
        return null;
    }

}
