package de.mediapool.server.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class NodeDTO extends GraphEntryDTO {

	private static final long serialVersionUID = 1L;

	private String id;
	
	public abstract String getType();
}
