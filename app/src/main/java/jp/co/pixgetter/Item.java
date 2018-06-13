package jp.co.pixgetter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "pageURL",
        "type",
        "tags",
        "previewURL",
        "previewWidth",
        "previewHeight",
        "webformatURL",
        "webformatWidth",
        "webformatHeight",
        "fullHDURL",
        "largeImageURL",
        "imageURL",
        "imageWidth",
        "imageHeight",
        "imageSize",
        "views",
        "downloads",
        "favorites",
        "likes",
        "comments",
        "user_id",
        "user",
        "userImageURL"
})

public class Item implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("pageURL")
    private String pageURL;
    @JsonProperty("type")
    private String type;
    @JsonProperty("tags")
    private String tags;

    @JsonProperty("previewURL")
    private String previewURL;
    @JsonProperty("previewWidth")
    private String previewWidth;
    @JsonProperty("previewHeight")
    private String previewHeight;

    @JsonProperty("webformatURL")
    private String webformatURL;
    @JsonProperty("webformatWidth")
    private String webformatWidth;
    @JsonProperty("webformatHeight")
    private String webformatHeight;

    @JsonProperty("fullHDURL")
    private String fullHDURL;

    @JsonProperty("largeImageURL")
    private String largeImageURL;
    @JsonProperty("imageURL")
    private String imageURL;
    @JsonProperty("imageWidth")
    private String imageWidth;
    @JsonProperty("imageHeight")
    private String imageHeight;

    @JsonProperty("imageSize")
    private String imageSize;
    @JsonProperty("views")
    private String views;
    @JsonProperty("downloads")
    private String downloads;
    @JsonProperty("favorites")
    private String favorites;
    @JsonProperty("likes")
    private String likes;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("user_id")
    private String user_id;
    @JsonProperty("user")
    private String user;
    @JsonProperty("userImageURL")
    private String userImageURL;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("tags")
    public String getTags() {
        return tags;
    }

    @JsonProperty("pageURL")
    public String getPageURL() {
        return pageURL;
    }

    @JsonProperty("previewURL")
    public String getPreviewURL() {
        return previewURL;
    }
    @JsonProperty("previewWidth")
    public String getPreviewWidth() {
        return previewWidth;
    }
    @JsonProperty("previewHeight")
    public String getPreviewHeight() {
        return previewHeight;
    }

    @JsonProperty("webformatURL")
    public String getWebformatURL() {
        return webformatURL;
    }
    @JsonProperty("webformatWidth")
    public String getWebformatWidth() {
        return webformatWidth;
    }
    @JsonProperty("webformatHeight")
    public String getWebformatHeight() {
        return webformatHeight;
    }

    @JsonProperty("largeImageURL")
    public String getLargeImageURL() {
        return largeImageURL;
    }
    @JsonProperty("imageURL")
    public String getImageURL() {
        return imageURL;
    }
    @JsonProperty("imageWidth")
    public String getImageWidth() {
        return imageWidth;
    }
    @JsonProperty("imageHeight")
    public String getImageHeight() {
        return imageHeight;
    }

    @JsonProperty("views")
    public String getViews() {
        return views;
    }

    @JsonProperty("downloads")
    public String getDownloads() {
        return downloads;
    }

    @JsonProperty("favorites")
    public String getFavorites() {
        return favorites;
    }

    @JsonProperty("likes")
    public String getLikes() {
        return likes;
    }

    @JsonProperty("comments")
    public String getComments() {
        return comments;
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
        return "id: " + id;
    }
}
