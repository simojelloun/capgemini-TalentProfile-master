package com.capgemini.talentProfile.services.implementations;

import com.capgemini.talentProfile.dto.CollaboratorDto;
import com.capgemini.talentProfile.dto.FicheCollabDto;
import com.capgemini.talentProfile.dto.InfoMyPathCedDto;
import com.capgemini.talentProfile.dto.InfoMyPathEppDto;
import com.capgemini.talentProfile.persistant.*;
import com.capgemini.talentProfile.repository.*;
import com.capgemini.talentProfile.services.interfaces.CollaboratorsServiceInt;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.capgemini.talentProfile.utils.DateUtils.getAgeFromBirthday;

@Service
@Transactional
public class CollaboratorServiceImpl implements CollaboratorsServiceInt {

    private static final Logger LOGGER = Logger.getLogger(CollaboratorServiceImpl.class);

    @Autowired
    SesameRepo sesameRepository;

    @Autowired
    InfoMyPathCedRepo infoMyPathCedRepo;

    @Autowired
    InfoMyPathEppRepo infoMyPathEppRep;

    @Autowired
    InfoRetainRepo infoRetainRepo;

    @Autowired
    CollabCmRepo cmRepository;

    /**
     * Instantiates a new CollaboratorServiceImpl.
     */
    public CollaboratorServiceImpl() {
        super();
    }

    /**
     * @return liste des collaborateurs
     */
    @Override
    public List<CollaboratorDto> getAllCollaborators() {
        LOGGER.info("+ Start getAllCollaborators");

        List<CollaboratorDto> resultList = new ArrayList<>();

        List<Sesame> sesameList = sesameRepository.findAll();

        for (Sesame sesameCollaborator : sesameList) {
            long currentGgid = sesameCollaborator.getGlobalGroupId();

            CollaboratorDto collaborator = new CollaboratorDto();

            // Sesame information
            collaborator.setGgid(currentGgid);
            collaborator.setFirstName(sesameCollaborator.getFirstName());
            collaborator.setLastName(sesameCollaborator.getLastName());
            collaborator.setGrade(sesameCollaborator.getGroupeGrade());
            collaborator.setRole(sesameCollaborator.getJobTitle());
            collaborator.setAge(getAgeFromBirthday(sesameCollaborator.getBirthday()));

            // InfoRetain information
            InfoRetain infoRetain = infoRetainRepo.findInfoRetainByGgid(currentGgid);
            if (infoRetain != null) {
                collaborator.setProject(infoRetain.getProjectName());
            }

            // CED information
            List<InfoMyPathCed> infoMyPathCedList = infoMyPathCedRepo.findInfoMyPathCedByGlobalIdSorted(currentGgid);
            if (!CollectionUtils.isEmpty(infoMyPathCedList)) {
                InfoMyPathCed lastInfoMyPathCed = infoMyPathCedList.get(0);
                collaborator.setProvisionalNote(lastInfoMyPathCed.getProvisionalPerformanceRating());
                collaborator.setProvisionalPotentiel(lastInfoMyPathCed.getProvisionalPotentialRating());
            }

            resultList.add(collaborator);
        }
        LOGGER.debug("+ getAllCollaborators result : " + resultList);
        LOGGER.info("- End getAllCollaborators");

        return resultList;
    }

    /**
     * @param ggId Matricule Collaborateur
     * @return liste des Collaborateur pas ggId
     */
    @Override
    public FicheCollabDto getCollabByGgid(Long ggId) {
        LOGGER.info("+ Start getCollabByGgid");

        FicheCollabDto fiche = new FicheCollabDto();

        Sesame sesameCollaborator = sesameRepository.findOne(ggId);
        if (sesameCollaborator != null) {
            fiche.setGgid(ggId);
            fiche.setFirstName(sesameCollaborator.getFirstName());
            fiche.setLastName(sesameCollaborator.getLastName());
            fiche.setBirthday(sesameCollaborator.getBirthday());
            fiche.setCategorie(sesameCollaborator.getCategorie());
            fiche.setClassification(sesameCollaborator.getClassification());
            fiche.setEmployeeStatus(sesameCollaborator.getEmployeeStatus());
            fiche.setEntityStartDate(sesameCollaborator.getEntityStartDate());
            fiche.setGroupeGrade(sesameCollaborator.getGroupeGrade());
            fiche.setJobTitle(sesameCollaborator.getJobTitle());
            fiche.setLeaversLastWorking(sesameCollaborator.getLeaversLastWorkingDate());
            fiche.setLocalGrade(sesameCollaborator.getLocalGrade());
            fiche.setOfficeBase(sesameCollaborator.getOfficeBase());
            fiche.setPuCode(sesameCollaborator.getPuCode());
            fiche.setTypeContrat(sesameCollaborator.getTypeContrat());

            InfoRetain infoRetain = infoRetainRepo.findOne(ggId);
            if (infoRetain != null) {
                fiche.setAffectationType(infoRetain.getAffectationType());
                fiche.setProjectName(infoRetain.getProjectName());
                fiche.setTechno(infoRetain.getTechno());
            }

            // CEDs
            List<InfoMyPathCed> collaboratorCeds = infoMyPathCedRepo.findInfoMyPathCedByGlobalId(ggId);
            List<InfoMyPathCedDto> listCed = new ArrayList<>();
            for (InfoMyPathCed cedEntity : collaboratorCeds) {

                InfoMyPathCedDto ced = new InfoMyPathCedDto();
                ced.setGgid(ggId);
                //ced.setGlobalGrade(cedEntity.getGlobalGrade());
                ced.setReviewerYearEndAssessment(cedEntity.getReviewerYearEndAssessment());

                ced.setProvisionalPerformanceRating(cedEntity.getProvisionalPerformanceRating());
                ced.setProvisionalPotentialRating(cedEntity.getProvisionalPotentialRating());
                ced.setProvisionalPromotionNomination(cedEntity.getProvisionalPromotionNomination());
                ced.setProvisionalVPPotentialRating(cedEntity.getProvisionalVPPotentialRating());

                ced.setFinalPerformanceRating(cedEntity.getFinalPerformanceRating());
                ced.setFinalPotentialRating(cedEntity.getFinalPotentialRating());
                ced.setFinalPromotionNomination(cedEntity.getFinalPromotionNomination());
                ced.setFinalVPPotentialRating(cedEntity.getFinalVPPotentialRating());

                listCed.add(ced);
            }
            fiche.setCedList(listCed);
            // EPPs
            List<InfoMyPathEpp> collaboratorEpps = infoMyPathEppRep.findInfoMyPathEppByGlobalId(ggId);
            List<InfoMyPathEppDto> listEpp = new ArrayList<>();
            for (InfoMyPathEpp eppEntity : collaboratorEpps) {

                InfoMyPathEppDto epp = new InfoMyPathEppDto();
                epp.setEmployeeGlobalId(ggId);
                epp.setAssignmentRating(eppEntity.getAssignmentRating());
                epp.setEmployeeGlobalGrade(eppEntity.getEmployeeGlobalGrade());
                epp.setReviewerFirstName(eppEntity.getReviewerFirstName());
                epp.setReviewerStatus(eppEntity.getReviewerStatus());
                epp.setAssignmentAppraisalHrComments(eppEntity.getAssignmentAppraisalHrComments());
                listEpp.add(epp);
            }

            fiche.setEppList(listEpp);
        }
        LOGGER.info("- End getCollabByGgid");

        return fiche;
    }

    /**
     * @param ggidCM Matricule CM
     * @return la liste des collaborateurs pour un CM
     */
    @Override
    public List<CollaboratorDto> getCollabByCM(Long ggidCM) {
        LOGGER.info("+ Start getCollabByGgid : " + ggidCM);

        List<CollaboratorDto> resultList = new ArrayList<>();

        List<CollabCm> collabCMList = cmRepository.findCollabByCM(ggidCM);

        for (CollabCm collaboratorCM : collabCMList) {
            CollaboratorDto collab = new CollaboratorDto();
            collab.setGgid(collaboratorCM.getGgid());
            collab.setFirstName(collaboratorCM.getPrenomCollab());
            collab.setLastName(collaboratorCM.getNomCollab());
            //collab.setGrade(collaboratorCM.getGroupeGrade());

            resultList.add(collab);
        }
        LOGGER.debug("Collabs list : " + resultList);

        LOGGER.info("- End getCollabByGgid");

        return resultList;
    }
}


