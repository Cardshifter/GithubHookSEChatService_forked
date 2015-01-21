
package com.skiwi.githubhooksechatservice.events.github;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skiwi.githubhooksechatservice.events.AnySetterJSONObject;
import com.skiwi.githubhooksechatservice.events.github.classes.Organization;
import com.skiwi.githubhooksechatservice.events.github.classes.Repository;
import com.skiwi.githubhooksechatservice.events.github.classes.User;
import com.skiwi.githubhooksechatservice.events.github.classes.WikiPage;

/**
 *
 * @author Frank van Heeswijk
 */
public final class GollumEvent extends AnySetterJSONObject {
	@JsonProperty
	private WikiPage[] pages;
	
	@JsonProperty
	private Repository repository;
	
	@JsonProperty(required = false)
	private Organization organization;
	
	@JsonProperty
	private User sender;

	public List<WikiPage> getPages() {
		return Arrays.asList(pages);
	}

	public Repository getRepository() {
		return repository;
	}

	public Organization getOrganization() {
		return organization;
	}

	public User getSender() {
		return sender;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 59 * hash + Arrays.deepHashCode(this.pages);
		hash = 59 * hash + Objects.hashCode(this.repository);
		hash = 59 * hash + Objects.hashCode(this.organization);
		hash = 59 * hash + Objects.hashCode(this.sender);
		return hash;
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final GollumEvent other = (GollumEvent)obj;
		if (!Arrays.deepEquals(this.pages, other.pages)) {
			return false;
		}
		if (!Objects.equals(this.repository, other.repository)) {
			return false;
		}
		if (!Objects.equals(this.organization, other.organization)) {
			return false;
		}
		if (!Objects.equals(this.sender, other.sender)) {
			return false;
		}
		return true;
	}
}
