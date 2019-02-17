package obserable;

/**
 * @ClassName ListView
 * @Author YC
 * @Date 2019/2/17 15:11
 */

public  class ListView implements observe {


	private BaseAdapter baseAdapter;

	public void setAdapter(BaseAdapter baseAdapter) {
		this.baseAdapter = baseAdapter;
		this.baseAdapter.registerListener(this::change);
	}

	@Override
	public void change() {
          System.out.println("适配器数据改变 渲染视图");
	}
}
