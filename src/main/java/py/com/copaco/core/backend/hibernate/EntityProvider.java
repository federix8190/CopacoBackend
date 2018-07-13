package py.com.copaco.core.backend.hibernate;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 * Mezcla dos frameworks y provee un {@link EntityManager} a través de la
 * anotación CDI {@link Inject}.
 * 
 * TODO: Agregar {@link DataSource}
 * 
 * @author Arturo Volpe
 *
 */
public class EntityProvider {

	@PersistenceContext
	@Produces
	private EntityManager entityManager;
}
