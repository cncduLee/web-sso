package com.bitium10.sso.client;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-5-31
 * Time: 下午1:33
 * To change this template use File | Settings | File Templates.
 */
public class SSOContext {

    private final static ThreadLocal<User> holder = new ThreadLocal<User>();

    public static void setUser(User user){
        holder.set(user);
    }

    public static User getUser(){
        return holder.get();
    }

    public static void remove(){
        holder.remove();
    }

}
