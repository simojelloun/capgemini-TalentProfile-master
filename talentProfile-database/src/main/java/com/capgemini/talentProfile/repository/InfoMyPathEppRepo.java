package com.capgemini.talentProfile.repository;

import com.capgemini.talentProfile.persistant.InfoMyPathEpp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InfoMyPathEppRepo extends JpaRepository<InfoMyPathEpp, Long> {
    @Query("SELECT epp FROM #{#entityName} epp WHERE epp.employeeGlobalId = :ggid")
    List<InfoMyPathEpp> findInfoMyPathEppByGlobalId(@Param("ggid") long ggid);
}
