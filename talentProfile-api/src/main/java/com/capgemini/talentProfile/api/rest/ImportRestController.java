/**
 *
 */
package com.capgemini.talentProfile.api.rest;

import com.capgemini.talentProfile.GeneralConstants;
import com.capgemini.talentProfile.dto.UserRoleDto;
import com.capgemini.talentProfile.services.interfaces.ImportServiceInt;
import com.capgemini.talentProfile.utils.WSResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.capgemini.talentProfile.GeneralConstants.ACCESS_DENIED;
import static com.capgemini.talentProfile.GeneralConstants.IMPORT_SUCCESS;


/**
 * The Class EmployeeApi.
 *
 * @author mbenjelloun
 */
@RestController
public class ImportRestController extends AbstractJWTService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportRestController.class);

    @Autowired
    ImportServiceInt importService;


    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importSesame")
    public ResponseEntity importSesame(@RequestParam("file") MultipartFile file, @RequestHeader("Authentication-Info") String auth) throws IOException {
        LOGGER.info("+ Start importSesame -> importing file : " + file.getOriginalFilename());

        UserRoleDto userRoleDto = initExecution(auth);
        if (userRoleDto == null || !GeneralConstants.ROLE_ADMIN.equals(userRoleDto.getRole())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new WSResponseMessage(ACCESS_DENIED));
        }

        if (file != null && !file.isEmpty()) {
            importService.importFromSesame(file.getInputStream());
        }

        LOGGER.info("- End importSesame");
        return ResponseEntity.status(HttpStatus.OK).body(new WSResponseMessage(IMPORT_SUCCESS));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importInfoRetain")
    public ResponseEntity importInfoRetain(@RequestParam("file") MultipartFile file, @RequestHeader("Authentication-Info") String auth) throws IOException {
        LOGGER.info("+ Start importInfoRetain -> importing file : " + file.getOriginalFilename());

        UserRoleDto userRoleDto = initExecution(auth);
        if (userRoleDto == null || !GeneralConstants.ROLE_ADMIN.equals(userRoleDto.getRole())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new WSResponseMessage(ACCESS_DENIED));
        }
        if (file != null && !file.isEmpty()) {
            importService.importFromInfoRetain(file.getInputStream());
        }

        LOGGER.info("- End importInfoRetain");
        return ResponseEntity.status(HttpStatus.OK).body(new WSResponseMessage(IMPORT_SUCCESS));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importMyPathHisto")
    public ResponseEntity importMyPathHisto(@RequestParam("file") MultipartFile file, @RequestHeader("Authentication-Info") String auth) throws IOException {
        LOGGER.info("+ Start importMyPathHisto -> importing file : " + file.getOriginalFilename());

        UserRoleDto userRoleDto = initExecution(auth);
        if (userRoleDto == null || !GeneralConstants.ROLE_ADMIN.equals(userRoleDto.getRole())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new WSResponseMessage(ACCESS_DENIED));
        }

        if (file != null && !file.isEmpty()) {
            importService.importFromMyPathHisto(file.getInputStream());
        }
        LOGGER.info("- End importInfoRetain");
        return ResponseEntity.status(HttpStatus.OK).body(new WSResponseMessage(IMPORT_SUCCESS));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importMyPathEpp")
    public ResponseEntity importMyPathEpp(@RequestParam("file") MultipartFile file, @RequestHeader("Authentication-Info") String auth) throws IOException {
        LOGGER.info("+ Start importMyPathEpp -> importing file : " + file.getOriginalFilename());

        UserRoleDto userRoleDto = initExecution(auth);
        if (userRoleDto == null || !GeneralConstants.ROLE_ADMIN.equals(userRoleDto.getRole())) {
            LOGGER.debug("insufficient roles for operation");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new WSResponseMessage(ACCESS_DENIED));
        }

        if (file != null && !file.isEmpty()) {
            importService.importFromMyPathEpp(file.getInputStream());
        }
        LOGGER.info("- End importMyPathEpp");
        return ResponseEntity.status(HttpStatus.OK).body(new WSResponseMessage(IMPORT_SUCCESS));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importMyPathCED")
    public ResponseEntity importMyPathCed(@RequestParam("file") MultipartFile file, @RequestHeader("Authentication-Info") String auth) throws IOException {
        LOGGER.info("+ Start importMyPathCed -> importing file : " + file.getOriginalFilename());

        UserRoleDto userRoleDto = initExecution(auth);
        if (userRoleDto == null || !GeneralConstants.ROLE_ADMIN.equals(userRoleDto.getRole())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new WSResponseMessage(ACCESS_DENIED));
        }
        if (file != null && !file.isEmpty()) {
            importService.importFromMyPathCed(file.getInputStream());
        }
        LOGGER.info("- End importMyPathCed");
        return ResponseEntity.status(HttpStatus.OK).body(new WSResponseMessage(IMPORT_SUCCESS));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importCollabCM")
    public ResponseEntity importCollabCm(@RequestParam("file") MultipartFile file, @RequestHeader("Authentication-Info") String auth) throws IOException {
        LOGGER.info("+ Start importCollabCm -> importing file : " + file.getOriginalFilename());

        UserRoleDto userRoleDto = initExecution(auth);
        if (userRoleDto == null || !GeneralConstants.ROLE_ADMIN.equals(userRoleDto.getRole())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new WSResponseMessage(ACCESS_DENIED));
        }
        if (file != null && !file.isEmpty()) {
            importService.importFromCollabCm(file.getInputStream());
        }
        LOGGER.info("- End importCollabCm");
        return ResponseEntity.status(HttpStatus.OK).body(new WSResponseMessage(IMPORT_SUCCESS));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importUserRole")
    public ResponseEntity importUserRole(@RequestParam("file") MultipartFile file, @RequestHeader("Authentication-Info") String auth) throws IOException {
        LOGGER.info("+ Start importUserRole -> importing file : " + file.getOriginalFilename());

        UserRoleDto userRoleDto = initExecution(auth);
        if (userRoleDto == null || !GeneralConstants.ROLE_ADMIN.equals(userRoleDto.getRole())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new WSResponseMessage(ACCESS_DENIED));
        }
        if (file != null && !file.isEmpty()) {
            importService.importFromUserRole(file.getInputStream());
        }
        LOGGER.info("- End importUserRole");
        return ResponseEntity.status(HttpStatus.OK).body(new WSResponseMessage(IMPORT_SUCCESS));
    }

}
