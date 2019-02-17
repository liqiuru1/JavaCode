package proses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName Client
 * @Author YC
 * @Date 2019/2/17 15:59
 */

public class Client implements Reture.Chain {


	private Response response;
	public List<Reture> retures;

	private Iterator<Reture> iterable;
	private Request request;

	{
		retures = new ArrayList<>();
		response = new Response();
	}

	public void addIntercept(Reture reture) {
		retures.add(reture);
	}

	@Override
	public Request getRequst() {
		return request;
	}

	@Override
	public Response proceed(Request request) {
		this.request = request;
		response.message = request.message;
		if (iterable == null) {
			iterable = retures.iterator();
		}

		if (iterable.hasNext()) {
			Reture next = iterable.next();
			next.deal(this);
		}

		return response;
	}
}
