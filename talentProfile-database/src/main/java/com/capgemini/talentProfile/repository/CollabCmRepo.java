package com.capgemini.talentProfile.repository;

import com.capgemini.talentProfile.persistant.CollabCm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollabCmRepo extends JpaRepository<CollabCm, Long> {

    @Query("SELECT cm FROM #{#entityName} cm WHERE cm.ggidCM = :ggidCM")
    List<CollabCm> findCollabByCM(@Param("ggidCM") Long ggidCM);

}
