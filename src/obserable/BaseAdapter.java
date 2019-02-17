package obserable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * @ClassName BaseAdapter
 * @Author YC
 * @Date 2019/2/17 15:11
 * <p>
 * 被观察者
 */

public class BaseAdapter implements Observeble {

	List<observe> notifyList;

	{
		notifyList = new ArrayList<>();
	}


	/**
	 * 注册观察者
	 * @param observe
	 */
	public void registerListener(observe observe) {
		notifyList.add(observe);
	}


	/***
	 * 被观察者发生变化了
	 *
	 * 需要通知观察者
	 */
	@Override
	public void notifyInvied() {
//        notifyList.forEach(it -> it.change());
		for (observe observe : notifyList) {
			observe.change();
		}
	}
}
