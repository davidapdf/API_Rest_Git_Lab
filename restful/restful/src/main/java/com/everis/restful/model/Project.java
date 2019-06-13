package com.everis.restful.model;



import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "TB_PROJECT")
@Entity(name = "Project")
public class Project {

		
    @JsonProperty("id")	
	private int projectId;
    @JsonProperty("name")
	private String projectName;
    @JsonProperty("description")
    private String projectDescription;
    @JsonProperty("web_url")
    private String projectWebUrl;
    @JsonProperty("avatar_url")
    private String projectAvatarUrl;
    @JsonProperty("git_ssh_url")
    private String projectGitSshUrl;
    @JsonProperty("git_http_url")
    private String projectGitHttpUrl;
    @JsonProperty("namespace")
    private String projectNamespace;
    @JsonProperty("visibility_level")
    private int projectVisibilityLevel;
    @JsonProperty("path_with_namespace")
    private String projectPathWithNamespace;
    @JsonProperty("default_branch")
    private String projectDefaultBranch;
    @JsonProperty("homepage")
    private String projectHomepage;
    @JsonProperty("url")
    private String projectUrl;
    @JsonProperty("ssh_url")
    private String projectSshUrl;
    @JsonProperty("http_url")
    private String projectHttpUrl;
    private Timestamp dtIncl;
	
    @Id
	private Long codigoProjeto;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "push_id",foreignKey =@ForeignKey(name ="FK_ProjectPush"))
	@JsonBackReference
	private Push push;
	 
	public Project(){
		
	}

	public Push getPush() {
		return push;
	}

	public void setPush(Push push) {
		this.push = push;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Long getCodigoProjeto() {
		return codigoProjeto;
	}

	public void setCodigoProjeto(Long codigoProjeto) {
		this.codigoProjeto = codigoProjeto;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectWebUrl() {
		return projectWebUrl;
	}

	public void setProjectWebUrl(String projectWebUrl) {
		this.projectWebUrl = projectWebUrl;
	}

	public String getProjectAvatarUrl() {
		return projectAvatarUrl;
	}

	public void setProjectAvatarUrl(String projectAvatarUrl) {
		this.projectAvatarUrl = projectAvatarUrl;
	}

	public String getProjectGitSshUrl() {
		return projectGitSshUrl;
	}

	public void setProjectGitSshUrl(String projectGitSshUrl) {
		this.projectGitSshUrl = projectGitSshUrl;
	}

	public String getProjectGitHttpUrl() {
		return projectGitHttpUrl;
	}

	public void setProjectGitHttpUrl(String projectGitHttpUrl) {
		this.projectGitHttpUrl = projectGitHttpUrl;
	}

	public String getProjectNamespace() {
		return projectNamespace;
	}

	public void setProjectNamespace(String projectNamespace) {
		this.projectNamespace = projectNamespace;
	}

	public int getProjectVisibilityLevel() {
		return projectVisibilityLevel;
	}

	public void setProjectVisibilityLevel(int projectVisibilityLevel) {
		this.projectVisibilityLevel = projectVisibilityLevel;
	}

	public String getProjectPathWithNamespace() {
		return projectPathWithNamespace;
	}

	public void setProjectPathWithNamespace(String projectPathWithNamespace) {
		this.projectPathWithNamespace = projectPathWithNamespace;
	}

	public String getProjectDefaultBranch() {
		return projectDefaultBranch;
	}

	public void setProjectDefaultBranch(String projectDefaultBranch) {
		this.projectDefaultBranch = projectDefaultBranch;
	}

	public String getProjectHomepage() {
		return projectHomepage;
	}

	public void setProjectHomepage(String projectHomepage) {
		this.projectHomepage = projectHomepage;
	}

	public String getProjectUrl() {
		return projectUrl;
	}

	public void setProjectUrl(String projectUrl) {
		this.projectUrl = projectUrl;
	}

	public String getProjectSshUrl() {
		return projectSshUrl;
	}

	public void setProjectSshUrl(String projectSshUrl) {
		this.projectSshUrl = projectSshUrl;
	}

	public String getProjectHttpUrl() {
		return projectHttpUrl;
	}

	public void setProjectHttpUrl(String projectHttpUrl) {
		this.projectHttpUrl = projectHttpUrl;
	}

	public Timestamp getDtIncl() {
		return dtIncl;
	}

	public void setDtIncl(Timestamp dtIncl) {
		this.dtIncl = dtIncl;
	}

	


}
