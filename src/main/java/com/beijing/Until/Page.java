package com.beijing.Until;

import com.beijing.bean.TUser;

import java.util.List;

public class Page {
    private  Integer pageno;
    private  Integer pagesize;
    private  Integer totalno;
    private  Integer totalsize;
    public   List<TUser> listpage;

    public Page() {

    }

    public Page(Integer pageno, Integer pagesize) {
        this.pageno = pageno;
        this.pagesize = pagesize;
    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;

    }

    public Integer getTotalno() {
        return totalno;
    }

    public void setTotalno(Integer totalno) {
        this.totalno = totalno;
        this.totalsize=(this.totalno%pagesize==0) ? (this.totalno/pagesize) :(this.totalno/pagesize+1);
    }

    public Integer getTotalsize() {
        return totalsize;
    }

    private void setTotalsize(Integer totalsize) {
        this.totalsize = totalsize;
    }



    public int indexOf(){
        return (pageno-1)*pagesize;

    }
}