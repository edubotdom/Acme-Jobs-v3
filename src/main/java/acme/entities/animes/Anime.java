
package acme.entities.animes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Anime extends DomainEntity {

	/**
	 * SerialID
	 */
	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				anime;

	@Digits(fraction = 0, integer = 9999)
	@Positive
	private Integer				episodes;

	@NotBlank
	private String				director;

	@Temporal(TemporalType.DATE)
	@Past
	private Date				aired;
}
