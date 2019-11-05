package GonPa.Grayshirts.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "WebSites")
public class WebSites implements Serializable {
    @Id
    @NotNull
    public String id;
    public String domain;
    public String leadCount;
    public String plan;
    public String ownerId;
    public List<String> labels = new ArrayList<>();

    public void setId(String id) {
        this.id = id;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setLeadCount(String leadCount) {
        this.leadCount = leadCount;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getId() {
        return id;
    }

    public String getDomain() {
        return domain;
    }

    public String getLeadCount() {
        return leadCount;
    }

    public String getPlan() {
        return plan;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public List<String> getLabels() {
        return labels;
    }

    public WebSites(String domain, String leadCount, String plan, String ownerId, List<String> labels) {
        this.domain = domain;
        this.leadCount = leadCount;
        this.plan = plan;
        this.ownerId = ownerId;
        this.labels = labels;
    }

    public Map<String, Object> getDto(boolean lead){
        Map<String, Object> webSitesDto = new LinkedHashMap<>();
        webSitesDto.put("id", this.getId());
        webSitesDto.put("domain", this.getDomain());
        webSitesDto.put("ownerId", this.getOwnerId());
        webSitesDto.put("plan", this.getPlan());
        webSitesDto.put("labels", this.getLabels());
        if(lead){
            webSitesDto.put("leadCount", this.getLeadCount());
        }
        return webSitesDto;
    }
}
