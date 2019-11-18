package com.dh.springsecurity.repository;

import com.dh.springsecurity.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser,Long> {

    SysUser findByUsername(String usename);
}
