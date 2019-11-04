package GonPa.Grayshirts.Repository;

import GonPa.Grayshirts.Document.WebSites;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@RepositoryRestResource
public interface WebSitesRepository extends MongoRepository<WebSites, Serializable> {

}
