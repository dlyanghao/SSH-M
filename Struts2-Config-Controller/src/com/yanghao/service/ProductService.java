package com.yanghao.service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.yanghao.bean.Product;
import com.yanghao.bean.User;
import com.yanghao.dao.ProductDao;

import java.util.List;
import java.util.TreeMap;

public class ProductService {

    public void getProducts() {
        List<Product> productsList = new ProductDao().getProducts();
        for (Product pro:productsList
             ) {
            System.out.println(pro);
        }
        //把当期返回的list存到值栈中,以便前台页面获取后台数据的值
        ValueStack valueStack = ActionContext.getContext().getValueStack();

        //封装当前查询到的list数据到值栈中(使用set方式)
        valueStack.set("productsList",productsList);
        //封装当前查询到的list转为Map封装到值栈中
        TreeMap<Integer, Product> productMap = new TreeMap<>();
        for (Product p: productsList
             ) {
            productMap.put(p.getPid(),p);
        }
        //(使用set方式)
        valueStack.set("productsMap",productMap);

    }
}
