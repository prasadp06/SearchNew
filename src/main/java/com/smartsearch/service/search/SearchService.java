package com.smartsearch.service.search;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.smartsearch.service.search.dto.Search;

@Produces({"application/xml","application/json"})
public interface SearchService {
	
	@GET
	@Path("/search/get/{q}/")
	public Search get(@PathParam("q") String id);
	
	@GET
	@Path("/search/{q}/")
	public List<Search> search(@PathParam("q") String keys);
	
	@PUT
	@Path("/search/edit/")
	public Response updateTag(Search tag);
	
	@POST
	@Path("/search/add/")
	public Response addTag(Search tag);
	
	@DELETE
	@Path("/search/delete/")
	public Response delete(Search tag);
	
	
}
