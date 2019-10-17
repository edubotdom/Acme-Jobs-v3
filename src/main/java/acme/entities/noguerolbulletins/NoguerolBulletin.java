
package acme.entities.noguerolbulletins;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class NoguerolBulletin extends DomainEntity {

	// Serialization identifier -----------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------

	@NotBlank
	private String				name;

	@NotNull
	@Digits(integer = 10, fraction = 2)
	@Min(0)
	private Double				amount;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

}
