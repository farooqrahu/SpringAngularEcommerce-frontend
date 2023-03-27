package com.rahu.springjwt.repository;

public interface RolesDetailList {
     Long getRoleId();
     Long getRolePermissionsId();
     String getDescription();
     String getName();
     Boolean getCanEdit();
     Boolean getCanView();
}
