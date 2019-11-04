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
    public ResponseEntity<Map<String, Object>> getWebSites(@PathVariable("id") long id){
        Map<String, Object> response = new HashMap<>();
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @RequestMapping(path = "/websites", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> newWebSite(@RequestBody WebSites webSiteDetails){
        webSites.save(webSiteDetails);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Success");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }
}
