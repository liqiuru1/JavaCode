package proses;

/**
 * @ClassName Reture
 * @Author YC
 * @Date 2019/2/17 15:56
 */

public interface Reture {


	Response deal(Chain chain);

	interface Chain {
		Request getRequst();

		Response proceed(Request request);
	}
}
