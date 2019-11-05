package GonPa.Grayshirts;

import GonPa.Grayshirts.Document.WebSites;
import GonPa.Grayshirts.Repository.WebSitesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class GrayshirtsController {

    @Autowired
    private WebSitesRepository webSites;

    @RequestMapping(path = "/websites/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getWebSites(@PathVariable("id") long id, @RequestHeader("token") String token){
        Map<String, Object> response = new HashMap<>();
        if(token.equals("123456789")) {
            //WebSites webSitesFound = WebSitesRepository.findById(id).orElse(null);
            //response = webSitesFound.getDto(true);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        response.put("status", "401");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(path = "/websites", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus
    public ResponseEntity<Map<String, Object>> Status(@RequestBody WebSites webSiteDetails, @RequestHeader("token") String token){
        Map<String, Object> response = new HashMap<>();
        if(token.equals("123456789")){
            WebSites newWebSite = webSites.save(webSiteDetails);
            response = newWebSite.getDto(false);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        response.put("status", "401");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.UNAUTHORIZED);
    }

}
