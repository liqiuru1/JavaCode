package single;

import javax.lang.model.element.AnnotationValue;

/**
 * @ClassName SingleClient
 * @Author YC
 * @Date 2019/2/17 14:31
 */

public class SingleClient {


	private SingleClient() {
	}


	{
		System.out.println("初始化");
	}

	private static  volatile SingleClient instance;

	/**
	 * 懒汉式
	 * 饿汉式
	 * <p>
	 * 1.申请内存空间地址
	 * 2.初始化对象
	 * 3.内存空间地址指向对象
	 * <p>
	 * 2  3   1
	 * 3  2  1
	 * <p>
	 * 213
	 * 3   2  1
	 * <p>
	 * 原子操作
	 */

	//饿汉
//	private SingleClient instence = new SingleClient();
	public static SingleClient getInstance() {


		if (instance == null) {
			synchronized (SingleClient.class) {
				if (instance == null) {
					instance = new SingleClient();
				}
			}
		}
		return instance;
	}


}
