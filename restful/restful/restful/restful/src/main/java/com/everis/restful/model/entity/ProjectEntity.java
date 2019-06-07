package com.everis.restful.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity(name = "Project")
@Table(name = "project")
@Component
public class ProjectEntity {
    
	@Id
	private Long codigoProjeto;
	private int projectId;
	private String projectName;
    private String projectDescription;
    private String projectWebUrl;
    private String projectAvatarUrl;
    private String projectGitSshUrl;
    private String projectGitHttpUrl;
    private String projectNamespace;
    private int projectVisibilityLevel;
    private String projectPathWithNamespace;
    private String projectDefaultBranch;
    private String projectHomepage;
    private String projectUrl;
    private String projectSshUrl;
    private String projectHttpUrl;
    
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private PushEntity push;

    public ProjectEntity(){}
    
	public Long getCodigoProjeto() {
		return codigoProjeto;
	}

	public void setCodigoProjeto(Long codigoProjeto) {
		this.codigoProjeto = codigoProjeto;
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

	public PushEntity getPush() {
		return push;
	}

	public void setPush(PushEntity push) {
		this.push = push;
	}
    
    
    
}
