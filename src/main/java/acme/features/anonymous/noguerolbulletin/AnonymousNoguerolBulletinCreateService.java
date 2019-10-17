
package acme.features.anonymous.noguerolbulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.noguerolbulletins.NoguerolBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousNoguerolBulletinCreateService implements AbstractCreateService<Anonymous, NoguerolBulletin> {

	//Internal state
	@Autowired
	AnonymousNoguerolBulletinRepository repository;


	@Override
	public boolean authorise(final Request<NoguerolBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public NoguerolBulletin instantiate(final Request<NoguerolBulletin> request) {
		assert request != null;

		NoguerolBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new NoguerolBulletin();
		result.setName("Jhon Doe");
		result.setAmount(1.20);
		result.setMoment(moment);

		return result;
	}

	@Override
	public void unbind(final Request<NoguerolBulletin> request, final NoguerolBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "amount");
	}

	@Override
	public void bind(final Request<NoguerolBulletin> request, final NoguerolBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void validate(final Request<NoguerolBulletin> request, final NoguerolBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<NoguerolBulletin> request, final NoguerolBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
