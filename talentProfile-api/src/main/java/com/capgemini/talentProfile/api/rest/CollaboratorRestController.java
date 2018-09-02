/**
 *
 */
package com.capgemini.talentProfile.api.rest;

import com.capgemini.talentProfile.GeneralConstants;
import com.capgemini.talentProfile.api.mappers.CollaboratorApiMapper;
import com.capgemini.talentProfile.api.mappers.FicheCollabApiMapper;
import com.capgemini.talentProfile.api.models.CollaboratorApiModel;
import com.capgemini.talentProfile.dto.UserRoleDto;
import com.capgemini.talentProfile.services.interfaces.CollaboratorsServiceInt;
import com.capgemini.talentProfile.utils.WSResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.capgemini.talentProfile.GeneralConstants.ACCESS_DENIED;


/**
 * The Class EmployeeApi.
 *
 * @author mbenjelloun
 */
@RestController
public class CollaboratorRestController extends AbstractJWTService {

    @Autowired
    CollaboratorsServiceInt collabService;

    @Autowired
    CollaboratorApiMapper collabMapper;

    @Autowired
    FicheCollabApiMapper ficheCollabMapper;


    @CrossOrigin(origins = "*")
    @GetMapping(value = "/talentProfile/getCollabByCM/{ggidCM}")
    public ResponseEntity getCollabByCM(@PathVariable Long ggidCM, @RequestHeader("Authentication-Info") String auth) {
        UserRoleDto userRoleDto = initExecution(auth);
        if (userRoleDto == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new WSResponseMessage(ACCESS_DENIED));
        }
        final List<CollaboratorApiModel> collaborators = collabMapper.fromDtoToApiModel(collabService.getCollabByCM(ggidCM));
        return new ResponseEntity(collaborators, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/talentProfile/Collabs/{ggid}", method = RequestMethod.GET)
    public ResponseEntity getCollabById(@PathVariable Long ggid, @RequestHeader("Authentication-Info") String auth) {
        UserRoleDto userRoleDto = initExecution(auth);
        if (userRoleDto == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new WSResponseMessage(ACCESS_DENIED));
        }

        return new ResponseEntity(ficheCollabMapper.fromDtoToApiModel(collabService.getCollabByGgid(ggid)), HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @GetMapping(value = "/talentProfile/getAllCollabToken")
    public ResponseEntity getAllCollaborators(@RequestHeader("Authentication-Info") String auth) {

        UserRoleDto userRoleDto = initExecution(auth);
        if (userRoleDto == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new WSResponseMessage(ACCESS_DENIED));
        }

        List<CollaboratorApiModel> collaborators;
        if (GeneralConstants.ROLE_CM.equals(userRoleDto.getRole())) {
            collaborators = collabMapper.fromDtoToApiModel(collabService.getCollabByCM(userRoleDto.getGgid()));
        }
        else {
            collaborators = collabMapper.fromDtoToApiModel(collabService.getAllCollaborators());
        }

        return new ResponseEntity(collaborators, HttpStatus.OK);
    }

}
;