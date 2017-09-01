package com.zhiyou100.video.model;

import com.zhiyou100.video.utils.MD5Utils;

public class Admin {
    private Integer id;

    private String loginName;

    private String loginPwd;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();     
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null :  MD5Utils.getMD5(loginPwd.trim());
    }

	@Override
	public String toString() {
		return "Admin [id=" + id + ", loginName=" + loginName + ", loginPwd=" + loginPwd + "]";
	}
    
}