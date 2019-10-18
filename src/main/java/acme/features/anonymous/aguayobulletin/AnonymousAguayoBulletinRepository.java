
package acme.features.anonymous.aguayobulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.animes.Anime;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousAguayoBulletinRepository extends AbstractRepository {

	@Query("select s from Anime s")
	Collection<Anime> findMany();

}
