package com.capgemini.talentProfile.repository;

import com.capgemini.talentProfile.persistant.InfoMyPathCed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface InfoMyPathCedRepo extends JpaRepository<InfoMyPathCed, Long> {

    @Query("SELECT ced FROM #{#entityName} ced WHERE ced.globalId = :ggid")
    List<InfoMyPathCed> findInfoMyPathCedByGlobalId(@Param("ggid") long ggid);

    @Query("SELECT ced FROM #{#entityName} ced WHERE ced.globalId = :globalId ORDER BY ced.performanceYearStartDate DESC")
    List<InfoMyPathCed> findInfoMyPathCedByGlobalIdSorted(@Param("globalId") long globalId);

}
