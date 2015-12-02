/**
 * 
 */
package pl.grmdev.rpgmaker.multi.server.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.github.fluent.hibernate.H;

import pl.grmdev.rpgmaker.multi.server.database.*;

/**
 * @author Levvy055
 *
 */
@Path("players")
public class Players {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		DatabaseHandler.initConnection();
		List<Player> playerList = H.<Player> request(Player.class).list();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Player player : playerList) {
			sb.append("{\"id\":" + player.getId() + ",\"name\":\"" + player.getName() + "\"},");
		}
		String r = sb.substring(0, sb.length() - 1) + "]";
		return Result.json(r);
	}
}
