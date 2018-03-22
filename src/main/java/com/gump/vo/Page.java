package com.gump.vo;

import java.util.List;

public class Page {   
    private int     pageSize;// 每页显示多少条  
    private int     count; // 总记录数  
    private int     pageTotal; // 总页数  
    private int     currentPage;// 当前页 
    private List<?> data; // 当前页数据

    public Page() {
        this.pageSize = 10;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    /**
     * 设置总记录数、总页数
     * 
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
        this.pageTotal = (int) Math.ceil(this.count * 1.0 / this.pageSize);
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * 设置第几页
     * @param currentPage
     */
    public void setCurrentPage(int currentPage) {
        if (currentPage < 1) {
            this.currentPage = 1;
        } else if (currentPage > this.getPageTotal()) {
            this.currentPage = this.getPageTotal();
        } else {
            this.currentPage = currentPage;
        }
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

}

