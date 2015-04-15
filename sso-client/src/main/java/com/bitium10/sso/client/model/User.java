package com.bitium10.sso.client.model;

import com.bitium10.sso.client.common.exception.SSOException;
import com.bitium10.sso.client.json.JSONArray;
import com.bitium10.sso.client.json.JSONObject;
import com.bitium10.sso.client.regex.RegexURL;
import com.bitium10.sso.client.regex.URLCollections;

import java.io.Serializable;

/**
 * <b>项目名</b>： web-sso <br>
 * <b>包名称</b>： com.bitium10.sso.client.model <br>
 * <b>类名称</b>： User <br>
 * <b>类描述</b>： <br>
 * <b>创建人</b>： <a href="mailto:shouli1990@gmail.com">李朋明</a> <br>
 * <b>修改人</b>： <br>
 * <b>创建时间</b>：2014/9/27 18:31
 * <b>修改时间</b>： <br>
 * <b>修改备注</b>： <br>
 *
 * @version 1.0.0 <br>
 */
public class User implements Serializable {
    private String treeJson;
    private String username;
    private String realname;
    private String tel;
    private String phone;
    private String email;
    private URLCollections urlCollections = null;

    public User() {
    }

    public User(String jsonStr) {
        if ((null == jsonStr) || ("".equals(jsonStr))) {
            throw new SSOException("100004", "get null from sso-server");
        }

        JSONObject obj = new JSONObject(jsonStr);
        String errorCode = obj.getString("errorCode");
        if ("00107".equals(errorCode))
            throw new SSOException("100003", "st信息不合法");
        if ("00116".equals(errorCode))
            throw new SSOException("100003", "没有权限访问，请联系管理员");
        if (!"000000".equals(errorCode)) {
            throw new SSOException("100003", "st信息不合法");
        }
        JSONObject userdetail = obj.getJSONObject("userinfo");
        this.username = userdetail.getString("username");
        this.realname = userdetail.getString("realname");
        this.tel = userdetail.getString("tel");
        this.phone = userdetail.getString("phone");
        this.email = userdetail.getString("email");

        URLCollections collection = new URLCollections();
        JSONArray array = obj.getJSONArray("auth");
        if ((null != array) && (array.length() > 0)) {
            this.treeJson = array.toString();
            for (int i = 0; i < array.length(); i++) {
                JSONObject item = array.getJSONObject(i);
                try {
                    String type = item.getString("authtype");
                    String value = item.getString("authvalue");
                    if ("2".equals(type))
                        collection.newAction(RegexURL.UrlType.URL, value);
                    else if ("1".equals(type))
                        collection.newAction(RegexURL.UrlType.REGEX, value);
                    else if ("3".equals(type))
                        collection.newAction(RegexURL.UrlType.StartsWith, value);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        this.urlCollections = collection;
    }

    public String getTreeJson() {
        return treeJson;
    }

    public void setTreeJson(String treeJson) {
        this.treeJson = treeJson;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
