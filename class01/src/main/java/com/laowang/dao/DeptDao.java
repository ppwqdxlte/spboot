package com.laowang.dao;

import com.laowang.bean.Dept;

public interface DeptDao {

    public Dept selectDeptByDeptno(Integer deptno);

    public Dept selectDeptByStep(Integer deptno);

    public Dept selectDeptByStemp2(Integer deptno);
}
