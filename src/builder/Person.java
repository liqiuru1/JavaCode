package builder;

/**
 * @ClassName Person
 * @Author YC
 * @Date 2019/2/17 14:46
 *
 *
 * <p>
 * 构建者模式
 * 自身的属性不想被外部访问
 * 你还需要外部进行一个赋值
 * <p>
 *
 *
 * 链式调用
 * 创建完成之后属性不可以修改
 */

public class Person {

	/**
	 * AlertDialog dialog = new AlertDialog.Builder(context)
	 * .setTitle("标题")
	 * .setContext("内容")
	 * .create();
	 * <p>
	 * dialog.show();
	 * dialog.setTitle()
	 */

	private String name;
	private String sex;
	private int age;

	void setName(String name) {
		this.name = name;
	}

	void setSex(String sex) {
		this.sex = sex;
	}

	void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", sex='" + sex + '\'' +
				", age=" + age +
				'}';
	}

	public static class Builder {
		private String name;
		private String sex;
		private int age;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setSex(String sex) {
			this.sex = sex;
			return this;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		public Person create() {
			Person person = new Person();
			person.setAge(age);
			person.setName(name);
			person.setSex(sex);
			return person;
		}

	}


}
