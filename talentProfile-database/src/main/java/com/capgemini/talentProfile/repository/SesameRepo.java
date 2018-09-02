package com.capgemini.talentProfile.repository;



import com.capgemini.talentProfile.persistant.Sesame;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SesameRepo extends JpaRepository<Sesame, Long> {
}
