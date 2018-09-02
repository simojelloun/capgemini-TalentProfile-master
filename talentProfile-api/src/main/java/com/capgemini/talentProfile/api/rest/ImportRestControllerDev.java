/**
 *
 */
package com.capgemini.talentProfile.api.rest;

import com.capgemini.talentProfile.services.interfaces.ImportServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.core.Response;
import java.io.IOException;


/**
 * The Class EmployeeApi.
 *
 * @author mbenjelloun
 */
@RestController
public class ImportRestControllerDev {

    @Autowired
    ImportServiceInt importService;


    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importSesameDev")
    public String importSesame(@RequestParam("file") MultipartFile file) throws IOException {

        if (file != null && !file.isEmpty()) {
            importService.importFromSesame(file.getInputStream());
        }
        return Response.status(Response.Status.OK).build().toString();
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importInfoRetainDev")
    public String importInfoRetain(@RequestParam("file") MultipartFile file) throws IOException {

        if (file != null && !file.isEmpty()) {
            importService.importFromInfoRetain(file.getInputStream());
        }
        return Response.status(Response.Status.OK).build().toString();
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importMyPathHistoDev")
    public String importMyPathHisto(@RequestParam("file") MultipartFile file) throws IOException {

        if (file != null && !file.isEmpty()) {
            importService.importFromMyPathHisto(file.getInputStream());
        }
        return Response.status(Response.Status.OK).build().toString();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importMyPathEppDev")
    public String importMyPathEpp(@RequestParam("file") MultipartFile file) throws IOException {

        if (file != null && !file.isEmpty()) {
            importService.importFromMyPathEpp(file.getInputStream());
        }
        return Response.status(Response.Status.OK).build().toString();
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importMyPathCEDDev")
    public String importMyPathCed(@RequestParam("file") MultipartFile file) throws IOException {

        if (file != null && !file.isEmpty()) {
            importService.importFromMyPathCed(file.getInputStream());
        }
        return Response.status(Response.Status.OK).build().toString();
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importCollabCMDev")
    public String importCollabCm(@RequestParam("file") MultipartFile file) throws IOException {

        if (file != null && !file.isEmpty()) {
            importService.importFromCollabCm(file.getInputStream());
        }
        return Response.status(Response.Status.OK).build().toString();
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/talentProfile/importUserRoleDev")
    public String importUserRole(@RequestParam("file") MultipartFile file) throws IOException {

        if (file != null && !file.isEmpty()) {
            importService.importFromUserRole(file.getInputStream());
        }
        return Response.status(Response.Status.OK).build().toString();
    }

}
