package com.capgemini.talentProfile.repository;

import com.capgemini.talentProfile.persistant.CollabCm;
import com.capgemini.talentProfile.persistant.Sesame;
import com.capgemini.talentProfile.persistant.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoleRepo  extends JpaRepository<UserRole, Long> {
    @Query("SELECT ur FROM #{#entityName} ur WHERE ur.ggid = :ggid AND ur.password =:password")
    UserRole findUserRoleByGgidAndPassword(@Param("ggid") Long ggid, @Param("password") String password);
}
