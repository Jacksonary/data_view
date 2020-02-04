package com.glodon.data_view.enums;

/**
 * @author liuwg-a
 * @date 2019/11/15 9:27
 * @description
 */
public enum ProjectStatus {

    /**
     * 2种工程状态
     */
    UNPUBLISHED((byte) 0), PUBLISHED((byte) 1);

    Byte code;

    ProjectStatus(Byte code) {
        this.code = code;
    }

    public Byte getCode() {
        return code;
    }

    public static ProjectStatus parse(Byte code) {
        if (code == null) {
            return null;
        }
        for (ProjectStatus ps : ProjectStatus.values()) {
            if (ps.getCode().equals(code)) {
                return ps;
            }
        }
        return null;
    }
}
