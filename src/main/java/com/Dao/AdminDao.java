package com.Dao;

import com.Dao.BaseDao;
import com.Beans.Admin;

public interface AdminDao extends BaseDao {
    public String judgeAdmin(String pno,String password) throws DaoException;
    //添加账户

    public void changePassword(String number, String sha256StrJava);
}
