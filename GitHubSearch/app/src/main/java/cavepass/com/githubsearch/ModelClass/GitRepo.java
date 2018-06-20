
package cavepass.com.githubsearch.ModelClass;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GitRepo implements Serializable, Parcelable
{

    private Integer id;
    private String nodeId;
    private String name;
    private String fullName;
    private Owner owner;
    private Boolean _private;
    private String htmlUrl;
    private String description;
    private Boolean fork;
    private String url;
    private String forksUrl;
    private String keysUrl;
    private String collaboratorsUrl;
    private String teamsUrl;
    private String hooksUrl;
    private String issueEventsUrl;
    private String eventsUrl;
    private String assigneesUrl;
    private String branchesUrl;
    private String tagsUrl;
    private String blobsUrl;
    private String gitTagsUrl;
    private String gitRefsUrl;
    private String treesUrl;
    private String statusesUrl;
    private String languagesUrl;
    private String stargazersUrl;
    private String contributorsUrl;
    private String subscribersUrl;
    private String subscriptionUrl;
    private String commitsUrl;
    private String gitCommitsUrl;
    private String commentsUrl;
    private String issueCommentUrl;
    private String contentsUrl;
    private String compareUrl;
    private String mergesUrl;
    private String archiveUrl;
    private String downloadsUrl;
    private String issuesUrl;
    private String pullsUrl;
    private String milestonesUrl;
    private String notificationsUrl;
    private String labelsUrl;
    private String releasesUrl;
    private String deploymentsUrl;
    private String createdAt;
    private String updatedAt;
    private String pushedAt;
    private String gitUrl;
    private String sshUrl;
    private String cloneUrl;
    private String svnUrl;
    private String homepage;
    private Integer size;
    private Integer stargazersCount;
    private Integer watchersCount;
    private String language;
    private Boolean hasIssues;
    private Boolean hasProjects;
    private Boolean hasDownloads;
    private Boolean hasWiki;
    private Boolean hasPages;
    private Integer forksCount;
    private Object mirrorUrl;
    private Boolean archived;
    private Integer openIssuesCount;
    private License license;
    private Integer forks;
    private Integer openIssues;
    private Integer watchers;
    private String defaultBranch;
    public final static Parcelable.Creator<GitRepo> CREATOR = new Creator<GitRepo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GitRepo createFromParcel(Parcel in) {
            return new GitRepo(in);
        }

        public GitRepo[] newArray(int size) {
            return (new GitRepo[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3677486704381729731L;

    protected GitRepo(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nodeId = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.fullName = ((String) in.readValue((String.class.getClassLoader())));
        this.owner = ((Owner) in.readValue((Owner.class.getClassLoader())));
        this._private = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.htmlUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.fork = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.forksUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.keysUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.collaboratorsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.teamsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.hooksUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.issueEventsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.eventsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.assigneesUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.branchesUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.tagsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.blobsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.gitTagsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.gitRefsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.treesUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.statusesUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.languagesUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.stargazersUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.contributorsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.subscribersUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.subscriptionUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.commitsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.gitCommitsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.commentsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.issueCommentUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.contentsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.compareUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.mergesUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.archiveUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.downloadsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.issuesUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.pullsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.milestonesUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.notificationsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.labelsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.releasesUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.deploymentsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.pushedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.gitUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.sshUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.cloneUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.svnUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.homepage = ((String) in.readValue((String.class.getClassLoader())));
        this.size = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.stargazersCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.watchersCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.language = ((String) in.readValue((String.class.getClassLoader())));
        this.hasIssues = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.hasProjects = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.hasDownloads = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.hasWiki = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.hasPages = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.forksCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.mirrorUrl = ((Object) in.readValue((Object.class.getClassLoader())));
        this.archived = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.openIssuesCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.license = ((License) in.readValue((License.class.getClassLoader())));
        this.forks = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.openIssues = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.watchers = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.defaultBranch = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GitRepo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getPrivate() {
        return _private;
    }

    public void setPrivate(Boolean _private) {
        this._private = _private;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFork() {
        return fork;
    }

    public void setFork(Boolean fork) {
        this.fork = fork;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getForksUrl() {
        return forksUrl;
    }

    public void setForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
    }

    public String getKeysUrl() {
        return keysUrl;
    }

    public void setKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
    }

    public String getCollaboratorsUrl() {
        return collaboratorsUrl;
    }

    public void setCollaboratorsUrl(String collaboratorsUrl) {
        this.collaboratorsUrl = collaboratorsUrl;
    }

    public String getTeamsUrl() {
        return teamsUrl;
    }

    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
    }

    public String getHooksUrl() {
        return hooksUrl;
    }

    public void setHooksUrl(String hooksUrl) {
        this.hooksUrl = hooksUrl;
    }

    public String getIssueEventsUrl() {
        return issueEventsUrl;
    }

    public void setIssueEventsUrl(String issueEventsUrl) {
        this.issueEventsUrl = issueEventsUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getAssigneesUrl() {
        return assigneesUrl;
    }

    public void setAssigneesUrl(String assigneesUrl) {
        this.assigneesUrl = assigneesUrl;
    }

    public String getBranchesUrl() {
        return branchesUrl;
    }

    public void setBranchesUrl(String branchesUrl) {
        this.branchesUrl = branchesUrl;
    }

    public String getTagsUrl() {
        return tagsUrl;
    }

    public void setTagsUrl(String tagsUrl) {
        this.tagsUrl = tagsUrl;
    }

    public String getBlobsUrl() {
        return blobsUrl;
    }

    public void setBlobsUrl(String blobsUrl) {
        this.blobsUrl = blobsUrl;
    }

    public String getGitTagsUrl() {
        return gitTagsUrl;
    }

    public void setGitTagsUrl(String gitTagsUrl) {
        this.gitTagsUrl = gitTagsUrl;
    }

    public String getGitRefsUrl() {
        return gitRefsUrl;
    }

    public void setGitRefsUrl(String gitRefsUrl) {
        this.gitRefsUrl = gitRefsUrl;
    }

    public String getTreesUrl() {
        return treesUrl;
    }

    public void setTreesUrl(String treesUrl) {
        this.treesUrl = treesUrl;
    }

    public String getStatusesUrl() {
        return statusesUrl;
    }

    public void setStatusesUrl(String statusesUrl) {
        this.statusesUrl = statusesUrl;
    }

    public String getLanguagesUrl() {
        return languagesUrl;
    }

    public void setLanguagesUrl(String languagesUrl) {
        this.languagesUrl = languagesUrl;
    }

    public String getStargazersUrl() {
        return stargazersUrl;
    }

    public void setStargazersUrl(String stargazersUrl) {
        this.stargazersUrl = stargazersUrl;
    }

    public String getContributorsUrl() {
        return contributorsUrl;
    }

    public void setContributorsUrl(String contributorsUrl) {
        this.contributorsUrl = contributorsUrl;
    }

    public String getSubscribersUrl() {
        return subscribersUrl;
    }

    public void setSubscribersUrl(String subscribersUrl) {
        this.subscribersUrl = subscribersUrl;
    }

    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    public void setSubscriptionUrl(String subscriptionUrl) {
        this.subscriptionUrl = subscriptionUrl;
    }

    public String getCommitsUrl() {
        return commitsUrl;
    }

    public void setCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
    }

    public String getGitCommitsUrl() {
        return gitCommitsUrl;
    }

    public void setGitCommitsUrl(String gitCommitsUrl) {
        this.gitCommitsUrl = gitCommitsUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public String getIssueCommentUrl() {
        return issueCommentUrl;
    }

    public void setIssueCommentUrl(String issueCommentUrl) {
        this.issueCommentUrl = issueCommentUrl;
    }

    public String getContentsUrl() {
        return contentsUrl;
    }

    public void setContentsUrl(String contentsUrl) {
        this.contentsUrl = contentsUrl;
    }

    public String getCompareUrl() {
        return compareUrl;
    }

    public void setCompareUrl(String compareUrl) {
        this.compareUrl = compareUrl;
    }

    public String getMergesUrl() {
        return mergesUrl;
    }

    public void setMergesUrl(String mergesUrl) {
        this.mergesUrl = mergesUrl;
    }

    public String getArchiveUrl() {
        return archiveUrl;
    }

    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    public String getDownloadsUrl() {
        return downloadsUrl;
    }

    public void setDownloadsUrl(String downloadsUrl) {
        this.downloadsUrl = downloadsUrl;
    }

    public String getIssuesUrl() {
        return issuesUrl;
    }

    public void setIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
    }

    public String getPullsUrl() {
        return pullsUrl;
    }

    public void setPullsUrl(String pullsUrl) {
        this.pullsUrl = pullsUrl;
    }

    public String getMilestonesUrl() {
        return milestonesUrl;
    }

    public void setMilestonesUrl(String milestonesUrl) {
        this.milestonesUrl = milestonesUrl;
    }

    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    public void setNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
    }

    public String getLabelsUrl() {
        return labelsUrl;
    }

    public void setLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public void setReleasesUrl(String releasesUrl) {
        this.releasesUrl = releasesUrl;
    }

    public String getDeploymentsUrl() {
        return deploymentsUrl;
    }

    public void setDeploymentsUrl(String deploymentsUrl) {
        this.deploymentsUrl = deploymentsUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getSshUrl() {
        return sshUrl;
    }

    public void setSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(Integer stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public Integer getWatchersCount() {
        return watchersCount;
    }

    public void setWatchersCount(Integer watchersCount) {
        this.watchersCount = watchersCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getHasIssues() {
        return hasIssues;
    }

    public void setHasIssues(Boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public Boolean getHasProjects() {
        return hasProjects;
    }

    public void setHasProjects(Boolean hasProjects) {
        this.hasProjects = hasProjects;
    }

    public Boolean getHasDownloads() {
        return hasDownloads;
    }

    public void setHasDownloads(Boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }

    public Boolean getHasWiki() {
        return hasWiki;
    }

    public void setHasWiki(Boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public Boolean getHasPages() {
        return hasPages;
    }

    public void setHasPages(Boolean hasPages) {
        this.hasPages = hasPages;
    }

    public Integer getForksCount() {
        return forksCount;
    }

    public void setForksCount(Integer forksCount) {
        this.forksCount = forksCount;
    }

    public Object getMirrorUrl() {
        return mirrorUrl;
    }

    public void setMirrorUrl(Object mirrorUrl) {
        this.mirrorUrl = mirrorUrl;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Integer getOpenIssuesCount() {
        return openIssuesCount;
    }

    public void setOpenIssuesCount(Integer openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public Integer getForks() {
        return forks;
    }

    public void setForks(Integer forks) {
        this.forks = forks;
    }

    public Integer getOpenIssues() {
        return openIssues;
    }

    public void setOpenIssues(Integer openIssues) {
        this.openIssues = openIssues;
    }

    public Integer getWatchers() {
        return watchers;
    }

    public void setWatchers(Integer watchers) {
        this.watchers = watchers;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(nodeId);
        dest.writeValue(name);
        dest.writeValue(fullName);
        dest.writeValue(owner);
        dest.writeValue(_private);
        dest.writeValue(htmlUrl);
        dest.writeValue(description);
        dest.writeValue(fork);
        dest.writeValue(url);
        dest.writeValue(forksUrl);
        dest.writeValue(keysUrl);
        dest.writeValue(collaboratorsUrl);
        dest.writeValue(teamsUrl);
        dest.writeValue(hooksUrl);
        dest.writeValue(issueEventsUrl);
        dest.writeValue(eventsUrl);
        dest.writeValue(assigneesUrl);
        dest.writeValue(branchesUrl);
        dest.writeValue(tagsUrl);
        dest.writeValue(blobsUrl);
        dest.writeValue(gitTagsUrl);
        dest.writeValue(gitRefsUrl);
        dest.writeValue(treesUrl);
        dest.writeValue(statusesUrl);
        dest.writeValue(languagesUrl);
        dest.writeValue(stargazersUrl);
        dest.writeValue(contributorsUrl);
        dest.writeValue(subscribersUrl);
        dest.writeValue(subscriptionUrl);
        dest.writeValue(commitsUrl);
        dest.writeValue(gitCommitsUrl);
        dest.writeValue(commentsUrl);
        dest.writeValue(issueCommentUrl);
        dest.writeValue(contentsUrl);
        dest.writeValue(compareUrl);
        dest.writeValue(mergesUrl);
        dest.writeValue(archiveUrl);
        dest.writeValue(downloadsUrl);
        dest.writeValue(issuesUrl);
        dest.writeValue(pullsUrl);
        dest.writeValue(milestonesUrl);
        dest.writeValue(notificationsUrl);
        dest.writeValue(labelsUrl);
        dest.writeValue(releasesUrl);
        dest.writeValue(deploymentsUrl);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(pushedAt);
        dest.writeValue(gitUrl);
        dest.writeValue(sshUrl);
        dest.writeValue(cloneUrl);
        dest.writeValue(svnUrl);
        dest.writeValue(homepage);
        dest.writeValue(size);
        dest.writeValue(stargazersCount);
        dest.writeValue(watchersCount);
        dest.writeValue(language);
        dest.writeValue(hasIssues);
        dest.writeValue(hasProjects);
        dest.writeValue(hasDownloads);
        dest.writeValue(hasWiki);
        dest.writeValue(hasPages);
        dest.writeValue(forksCount);
        dest.writeValue(mirrorUrl);
        dest.writeValue(archived);
        dest.writeValue(openIssuesCount);
        dest.writeValue(license);
        dest.writeValue(forks);
        dest.writeValue(openIssues);
        dest.writeValue(watchers);
        dest.writeValue(defaultBranch);
    }

    public int describeContents() {
        return  0;
    }

}
