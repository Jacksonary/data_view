package com.glodon.data_view.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuwg-a
 * @date 2019/11/10 14:20
 * @description 分页对象
 */
public class PagedList<T> implements Serializable {

    private static final long serialVersionUID = -209121832486801305L;
    private Page page;
    private List<T> list;

    public PagedList() {
    }

    public PagedList(Page page, List<T> list) {
        this.page = page;
        this.list = list;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
