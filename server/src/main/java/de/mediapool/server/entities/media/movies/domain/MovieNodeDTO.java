package de.mediapool.server.entities.media.movies.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.mediapool.server.entities.media.domain.MediaNodeDTO;
import de.mediapool.server.entities.persons.actors.domain.ActorNodeDTO;
import lombok.Getter;
import lombok.Setter;

@NodeEntity
@Getter
@Setter
public class MovieNodeDTO extends MediaNodeDTO {
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@RelatedTo(type = "ACTOR_IN", direction = Direction.INCOMING)
	private @Fetch Set<ActorNodeDTO> actors;
	
	public void addActor(ActorNodeDTO actor) {
		if (actors == null) {
			actors = new HashSet<ActorNodeDTO>();
		}
		actors.add(actor);
	}
	
	@Override
	public String getType() {
		return "movie";
	}

}
