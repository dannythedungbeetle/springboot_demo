package com.example.demogradleagain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by v.daniel.gunturu on 8/18/2019
 */

@Entity
@Table(name = "departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptId;
    private String deptShortDesc;
    private String deptLongDesc;

    public Departments(Integer deptId, String deptShortDesc, String deptLongDesc) {
        this.deptId = deptId;
        this.deptShortDesc = deptShortDesc;
        this.deptLongDesc = deptLongDesc;
    }

    @Override
    public String toString() {
        return "Departments{" +
                "deptId=" + deptId +
                ", deptShortDesc='" + deptShortDesc + '\'' +
                ", deptLongDesc='" + deptLongDesc + '\'' +
                '}';
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptShortDesc() {
        return deptShortDesc;
    }

    public void setDeptShortDesc(String deptShortDesc) {
        this.deptShortDesc = deptShortDesc;
    }

    public String getDeptLongDesc() {
        return deptLongDesc;
    }

    public void setDeptLongDesc(String deptLongDesc) {
        this.deptLongDesc = deptLongDesc;
    }

    public Departments() {
    }
}
