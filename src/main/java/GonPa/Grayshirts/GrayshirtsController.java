package GonPa.Grayshirts;

import GonPa.Grayshirts.Document.WebSites;
import GonPa.Grayshirts.Repository.WebSitesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class GrayshirtsController {

    @Autowired
    private WebSitesRepository webSites;

    @RequestMapping(path = "/websites/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getWebSites(@PathVariable("id") int id, @RequestHeader("token") String token){
        Map<String, Object> response = new HashMap<>();
        WebSites webSite = webSites.findAll().get(id - 1);
        response.put("", webSite);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @RequestMapping(path = "/websites", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus
    public ResponseEntity<Map<String, Object>> Status(@RequestBody WebSites webSiteDetails, @RequestHeader("token") String token){
        Map<String, Object> response = new HashMap<>();
        WebSites newWebSite = webSites.save(webSiteDetails);
        response = newWebSite.getDto(false);
        response.put("id", webSites.count());
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}
