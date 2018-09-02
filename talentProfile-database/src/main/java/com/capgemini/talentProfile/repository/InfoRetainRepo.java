package com.capgemini.talentProfile.repository;

import com.capgemini.talentProfile.persistant.InfoRetain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface InfoRetainRepo extends JpaRepository<InfoRetain, Long> {

    @Query("SELECT ir FROM #{#entityName} ir WHERE ir.ggid = :ggid")
    InfoRetain findInfoRetainByGgid(@Param("ggid") Long ggid);

}
