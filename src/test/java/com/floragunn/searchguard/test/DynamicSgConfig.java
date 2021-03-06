package com.floragunn.searchguard.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.WriteRequest.RefreshPolicy;

import com.floragunn.searchguard.support.ConfigConstants;
import com.floragunn.searchguard.test.helper.file.FileHelper;

public class DynamicSgConfig {
    
    private String searchGuardIndexName = "searchguard";
    private String sgConfig = "sg_config.yml";
    private String sgRoles = "sg_roles.yml";
    private String sgRolesMapping = "sg_roles_mapping.yml";
    private String sgInternalUsers = "sg_internal_users.yml";
    private String sgActionGroups = "sg_action_groups.yml";
    public String getSearchGuardIndexName() {
        return searchGuardIndexName;
    }
    public DynamicSgConfig setSearchGuardIndexName(String searchGuardIndexName) {
        this.searchGuardIndexName = searchGuardIndexName;
        return this;
    }
    public String getSgConfig() {
        return sgConfig;
    }
    public DynamicSgConfig setSgConfig(String sgConfig) {
        this.sgConfig = sgConfig;
        return this;
    }
    public String getSgRoles() {
        return sgRoles;
    }
    public DynamicSgConfig setSgRoles(String sgRoles) {
        this.sgRoles = sgRoles;
        return this;
    }
    public String getSgRolesMapping() {
        return sgRolesMapping;
    }
    public DynamicSgConfig setSgRolesMapping(String sgRolesMapping) {
        this.sgRolesMapping = sgRolesMapping;
        return this;
    }
    public String getSgInternalUsers() {
        return sgInternalUsers;
    }
    public DynamicSgConfig setSgInternalUsers(String sgInternalUsers) {
        this.sgInternalUsers = sgInternalUsers;
        return this;
    }
    public String getSgActionGroups() {
        return sgActionGroups;
    }
    public DynamicSgConfig setSgActionGroups(String sgActionGroups) {
        this.sgActionGroups = sgActionGroups;
        return this;
    }
    
    public List<IndexRequest> getDynamicConfig() {
        
        List<IndexRequest> ret = new ArrayList<IndexRequest>();
        
        ret.add(new IndexRequest(searchGuardIndexName)
               .type("sg")
               .id(ConfigConstants.CONFIGNAME_CONFIG)
               .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
               .source(ConfigConstants.CONFIGNAME_CONFIG, FileHelper.readYamlContent(sgConfig)));
        
        ret.add(new IndexRequest(searchGuardIndexName)
        .type("sg")
        .id(ConfigConstants.CONFIGNAME_ACTION_GROUPS)
        .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        .source(ConfigConstants.CONFIGNAME_ACTION_GROUPS, FileHelper.readYamlContent(sgActionGroups)));
 
        ret.add(new IndexRequest(searchGuardIndexName)
        .type("sg")
        .id(ConfigConstants.CONFIGNAME_INTERNAL_USERS)
        .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        .source(ConfigConstants.CONFIGNAME_INTERNAL_USERS, FileHelper.readYamlContent(sgInternalUsers)));
 
        ret.add(new IndexRequest(searchGuardIndexName)
        .type("sg")
        .id(ConfigConstants.CONFIGNAME_ROLES)
        .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        .source(ConfigConstants.CONFIGNAME_ROLES, FileHelper.readYamlContent(sgRoles)));
 
        ret.add(new IndexRequest(searchGuardIndexName)
        .type("sg")
        .id(ConfigConstants.CONFIGNAME_ROLES_MAPPING)
        .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        .source(ConfigConstants.CONFIGNAME_ROLES_MAPPING, FileHelper.readYamlContent(sgRolesMapping)));
 
        
        return Collections.unmodifiableList(ret);
    }

}
