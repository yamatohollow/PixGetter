package jp.co.pixgetter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "totalHits",
        "hits",
        "total"
})
public class Hits {
    @JsonProperty("totalHits")
    public String totalHits;
    @JsonProperty("hits")
    public List<Item> hits;
    @JsonProperty("total")
    public String total;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("totalHits")
    public String getTotalHits() {
        return totalHits;
    }
    @JsonProperty("hits")
    public List<Item> getHits() {
        return hits;
    }
    @JsonProperty("total")
    public String getTotal() {
        return total;
    }


    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String toString() {
        return "total: " + total;
    }
}
