/*
 * @IRestBaseService.java 1.0 Sep 3, 2014
 * Sistema Integral de Gestion Hospitalaria
 * 
 */
package py.com.copaco.core.backend.rest;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import py.com.copaco.core.backend.exception.ApplicationException;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Sep 3, 2014
 * 
 */

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IBaseResource<T, K extends Serializable> {

	@GET
	@Path("/paginate")
	RespuestaList<List<T>> getAll(@QueryParam("order") List<String> orders,
			@QueryParam("filterValues") List<String> values,
			@QueryParam("filterColumns") List<String> columns,
			@DefaultValue("-1") @QueryParam("first") int first,
			@DefaultValue("10") @QueryParam("pageSize") int pageSize);

	@GET
	@Path("/all")
	Respuesta<List<T>> getAll();

	@GET
	@Path("/entidad/{id}")
	Respuesta<T> get(@PathParam("id") K id);

	@POST
	@Path("/add")
	Respuesta<T> add(T entity);

	@PUT
	@Path("/update")
	Respuesta<T> update(T entity);

	@DELETE
	@Path("/delete/{id}")
	Respuesta<T> delete(@PathParam("id") K id);

}