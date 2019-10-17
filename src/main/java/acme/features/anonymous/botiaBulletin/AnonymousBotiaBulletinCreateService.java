
package acme.features.anonymous.botiaBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.botiaBulletins.BotiaBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousBotiaBulletinCreateService implements AbstractCreateService<Anonymous, BotiaBulletin> {

	//Internal state
	@Autowired
	AnonymousBotiaBulletinRepository repository;


	@Override
	public boolean authorise(final Request<BotiaBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public BotiaBulletin instantiate(final Request<BotiaBulletin> request) {
		assert request != null;

		BotiaBulletin result;
		Date moment;
		Date expiringDate;

		moment = new Date(System.currentTimeMillis() - 1);
		expiringDate = new Date(System.currentTimeMillis() + 100000000);

		result = new BotiaBulletin();
		result.setAuthor("Jhon Doe");
		result.setTitle("Ad astra per aspera.");
		result.setTextBody("Ad astra per aspera.");
		result.setExpiringDate(expiringDate);
		result.setMoment(moment);

		return result;
	}

	@Override
	public void unbind(final Request<BotiaBulletin> request, final BotiaBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "textBody", "expiringDate", "moment");
	}

	@Override
	public void bind(final Request<BotiaBulletin> request, final BotiaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void validate(final Request<BotiaBulletin> request, final BotiaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<BotiaBulletin> request, final BotiaBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
