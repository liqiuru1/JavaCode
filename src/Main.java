import org.junit.Test;


import builder.Person;
import decoration.School;
import decoration.SchooolWraper;
import obserable.BaseAdapter;
import obserable.ListView;
import proses.Client;
import proses.Request;
import proses.Response;
import proses.Reture;
import single.SingleClient;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}


	@Test
	public void testProses() {

		Client client = new Client();
//		Response proceed = client.proceed();
		client.addIntercept(new Reture() {
			@Override
			public Response deal(Chain chain) {
				Request requst = chain.getRequst();
				requst.message = requst.message + "1";
				return chain.proceed(requst);
			}
		});
		client.addIntercept(new Reture() {
			@Override
			public Response deal(Chain chain) {
				Request requst = chain.getRequst();
				requst.message = requst.message + "2";
				return chain.proceed(requst);
			}
		});
		client.addIntercept(new Reture() {
			@Override
			public Response deal(Chain chain) {
				Request requst = chain.getRequst();
				requst.message = requst.message + "3";
				return chain.proceed(requst);
			}
		});
		client.addIntercept(new Reture() {
			@Override
			public Response deal(Chain chain) {
				Request requst = chain.getRequst();
				requst.message = requst.message + "4";
				Request requestnew = new Request();
				requestnew.message = "小明";
				return chain.proceed(requestnew);
			}
		});
		client.addIntercept(new Reture() {
			@Override
			public Response deal(Chain chain) {
				Request requst = chain.getRequst();
				requst.message = requst.message + "5";
				Response response = new Response();
				response.message = "新的response";
				return chain.proceed(requst);
			}
		});
		client.addIntercept(new Reture() {
			@Override
			public Response deal(Chain chain) {
				Request requst = chain.getRequst();
				requst.message = requst.message + "6";
				System.out.println("执行");
				return chain.proceed(requst);

			}
		});
		Request request = new Request();
		request.message = "你好";
		Response proceed = client.proceed(request);
		print(proceed.message);


	}

	@Test
	public void testDecoration() {
		decoration.Test test = new decoration.Test();
		School school = new School();
		SchooolWraper wraper = new SchooolWraper(school);
		wraper.setForce(true);
		test.setSchool(school);
		test.start();
	}

	@Test
	public void testObserable() {

		ListView listView1 = new ListView();
		ListView listView2 = new ListView();
		ListView listView3 = new ListView();
		ListView listView4 = new ListView();
		ListView listView5 = new ListView();
		BaseAdapter baseAdapter = new BaseAdapter();
		listView1.setAdapter(baseAdapter);
		listView2.setAdapter(baseAdapter);
		listView3.setAdapter(baseAdapter);
		listView4.setAdapter(baseAdapter);
		listView5.setAdapter(baseAdapter);
		baseAdapter.notifyInvied();
	}

	@Test
	public void testBuilder() {
		Person person1 = new Person.Builder()
				.setAge(12)
				.setName("小明")
				.setSex("男")
				.setSex("女")
				.create();
		print(person1.toString());


	}

	@Test
	public void testSingle() {


		SingleClient instance = SingleClient.getInstance();


		Thread thread = new Thread(() -> {
			SingleClient instance1 = SingleClient.getInstance();
		});
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				super.run();
				SingleClient instance1 = SingleClient.getInstance();
			}
		};
		Thread threa3 = new Thread(() -> {
			SingleClient instance1 = SingleClient.getInstance();
		});
		Thread thread4 = new Thread(() -> {
			SingleClient instance1 = SingleClient.getInstance();
		});

		thread.start();
		thread2.start();
		threa3.start();
		thread4.start();

	}


	public void print(Object value) {
		System.out.println(value);
	}
}
