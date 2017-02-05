package com.kitchen.psc.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;

import java.util.UUID;

/**
 * @author Kevin Chen
 */
@JsonIgnoreProperties(value = {"_embedded"}, allowGetters = true)
public abstract class ResourceWithEmbeddeds extends ResourceSupport
{
	private UUID resourceId;

	@JsonUnwrapped
	// The @JsonUnwrapped annotation is requiredResourceWithEmbeddeds as EmbeddedWrappers are by default serialised in a "_embedded" container,
	// that has to be added directly into the top level object
	private Resources<EmbeddedWrapper> embeddeds;

	public UUID getResourceId()
	{
		return resourceId;
	}

	public void setResourceId(UUID resourceId)
	{
		this.resourceId = resourceId;
	}

	public Resources<EmbeddedWrapper> getEmbeddeds() {
		return embeddeds;
	}

	public void setEmbeddeds(Resources<EmbeddedWrapper> embeddeds) {
		this.embeddeds = embeddeds;
	}
}
