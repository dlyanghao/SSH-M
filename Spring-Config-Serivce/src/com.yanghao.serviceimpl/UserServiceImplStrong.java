package com.yanghao.serviceimpl;

/**
 * AOP增强类（该类的作用是用类中的方法来增强另一个类中的某个方法）
 */
public class UserServiceImplStrong {

    public void strongBefore(){

        System.out.println("前置增强--这是方法或者业务增强的逻辑!");
    }

    public void strongAfter(){

        System.out.println("后置增强--这是方法或者业务增强的逻辑!");
    }

    public void around(){
        System.out.println("环绕增强--这是方法或者业务增强的逻辑!");
    }

    public void after(){
        System.out.println("最终增强--这是方法或者业务增强的逻辑!");
    }
}
