package com.laowang.dao;

import com.laowang.bean.Emp;

public interface EmpDao {

    public Emp selectEmpByEmpno(Integer empno);

}
