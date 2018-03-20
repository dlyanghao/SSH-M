package com.yanghao.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yanghao.service.ProductService;

public class ProductAction extends ActionSupport{

    public String products(){

        System.out.println("准备获取商品。。。");
        //调用服务层获取产品信息
        new ProductService().getProducts();

        return "OK";
    }
}
