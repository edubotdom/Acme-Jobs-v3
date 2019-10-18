
package acme.features.anonymous.aguayobulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.animes.Anime;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousAguayoBulletinListService implements AbstractListService<Anonymous, Anime> {

	@Autowired
	AnonymousAguayoBulletinRepository repository;


	@Override
	public boolean authorise(final Request<Anime> request) {
		assert request != null;
		return false;
	}

	@Override
	public void unbind(final Request<Anime> request, final Anime entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "anime", "episodes", "aired", "director");
	}

	@Override
	public Collection<Anime> findMany(final Request<Anime> request) {
		assert request != null;

		Collection<Anime> result;

		result = this.repository.findMany();
		return result;
	}

}
