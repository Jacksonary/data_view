package com.glodon.data_view.bean;

import java.io.Serializable;

/**
 * @author liuwg-a
 * @date 2019/11/10 14:08
 * @description
 */
public class Page implements Serializable {
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int MAX_PAGE_SIZE = 100;
    private static final long serialVersionUID = 7456477224143297539L;

    private int pageNo = 1;
    private int pageSize = DEFAULT_PAGE_SIZE;
    private int totalCount = 0;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize) {
        if (pageNo != null && pageNo > 0) {
            this.pageNo = pageNo;
        }

        if (pageSize != null && pageSize > 0 && pageSize <= MAX_PAGE_SIZE) {
            this.pageSize = pageSize;
        }
    }

    public int getPageNo() {
        return pageNo;
    }

    /**
     * 从第一页开始
     *
     * @param pageNo pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo > 0 ? pageNo : 1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        int totalPages = getTotalPages();
        if (pageNo > totalPages) {
            setPageNo(totalCount);
        }
    }

    public int getStartIndex() {
        return (pageNo - 1) * pageSize;
    }

    public int getTotalPages() {
        if (totalCount <= 0) {
            return 0;
        }
        return totalCount % pageSize != 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                '}';
    }
}
