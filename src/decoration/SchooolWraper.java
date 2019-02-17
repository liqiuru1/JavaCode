package decoration;

/**
 * @ClassName SchooolWraper
 * @Author YC
 * @Date 2019/2/17 15:47
 */

public  class SchooolWraper implements TakeInter {
	private TakeInter school;

	private boolean force;

	public SchooolWraper(TakeInter school) {
		this.school = school;
	}

	public void setForce(boolean force) {
		this.force = force;
	}

	@Override
	public void takeTrach() {
		if (force) {
			school.takeTrach();
		} else {
			System.out.println("小红倒垃圾");
		}
	}
}
