package id.ac.ipb.dspacemobileapps.models;

import java.util.List;

/**
 * Created by Hanif Affandi Hartanto on 8/29/2015.
 */
public class Community {
    private String id;
    private String name;
    private String type;
    private String handle;
    private String copyrightText;
    private String countItems;
    private String introductoryText;
    private String shortDescription;
    private String sidebarText;
    private boolean topCommunities;
    private List<String> expand;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getCopyrightText() {
        return copyrightText;
    }

    public void setCopyrightText(String copyrightText) {
        this.copyrightText = copyrightText;
    }

    public String getCountItems() {
        return countItems;
    }

    public void setCountItems(String countItems) {
        this.countItems = countItems;
    }

    public String getIntroductoryText() {
        return introductoryText;
    }

    public void setIntroductoryText(String introductoryText) {
        this.introductoryText = introductoryText;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getSidebarText() {
        return sidebarText;
    }

    public void setSidebarText(String sidebarText) {
        this.sidebarText = sidebarText;
    }

    public boolean isTopCommunities() {
        return topCommunities;
    }

    public void setTopCommunities(boolean topCommunities) {
        this.topCommunities = topCommunities;
    }

    public List<String> getExpand() {
        return expand;
    }

    public void setExpand(List<String> expand) {
        this.expand = expand;
    }
}
