package com.yanghao.bean;

import java.util.Objects;

public class Product {
    private int pid;
    private String pname;
    private Integer pnum;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return pid == product.pid &&
                Objects.equals(pname, product.pname) &&
                Objects.equals(pnum, product.pnum);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pid, pname, pnum);
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pnum=" + pnum +
                '}';
    }
}
