package creater.builder;

/**
 * //todo todo builder模式需要重新理解一下，这个模式解决了什么问题？ muzhe
 * @author muzhe-wang on  18-9-7 下午6:18.
 */
public class Bean {

    private String name;

    private int age;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private static class Builder {
        private Bean bean = new Bean();

        public Bean build() {
            return bean;
        }

        public Builder name(String name) {
            bean.setName(name);
            return this;
        }

        public Builder age(int age) {
            bean.setAge(age);
            return this;
        }

        public Builder address(String address) {
            bean.setAddress(address);
            return this;
        }
    }
}
