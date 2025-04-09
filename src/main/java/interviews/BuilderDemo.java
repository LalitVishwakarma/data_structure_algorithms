package interviews;
/**
 * Need of Builder Pattern: Method chaining is a useful design pattern but however if accessed concurrently,
 * a thread may observe some fields to contain inconsistent values.
 * Although all setter methods in above example are atomic,
 * but calls in the method chaining can lead to inconsistent object state when the object is modified concurrently.
 * The below example can lead us to a Student instance in an inconsistent state,
 * for example, a student with name Ram and address Delhi.
 *
 * There is Builder pattern to ensure the thread-safety and atomicity of object creation.
 * Implementation : In Builder pattern, we have a inner static class named Builder inside our Server class with
 * instance fields for that class and also have a factory method to return a new instance of Builder
 * class on every invocation. The setter methods will now return Builder class reference.
 * We will also have a build method to return instances of Server side class, i.e. outer class.
 * */

final class BuilderStudent {

    // final instance fields
    private final int id;
    private final String name;
    private final String address;

    public BuilderStudent(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
    }

    // Static class Builder
    public static class Builder {

        /// instance fields
        private int id;
        private String name;
        private String address;

        public static Builder newInstance()
        {
            return new Builder();
        }

        private Builder() {}

        // Setter methods
        public Builder setId(int id)
        {
            this.id = id;
            return this;
        }
        public Builder setName(String name)
        {
            this.name = name;
            return this;
        }
        public Builder setAddress(String address)
        {
            this.address = address;
            return this;
        }

        // build method to deal with outer class
        // to return outer instance
        public BuilderStudent build()
        {
            return new BuilderStudent(this);
        }
    }

    @Override
    public String toString()
    {
        return "id = " + this.id + ", name = " + this.name +
                ", address = " + this.address;
    }
}

// Client Side Code
class StudentReceiver {

    // volatile student instance to ensure visibility
    // of shared reference to immutable objects
    private volatile BuilderStudent student;

    public StudentReceiver()
    {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                student = BuilderStudent.Builder.newInstance()
                        .setId(1)
                        .setName("Ram")
                        .setAddress("Noida")
                        .build();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                student = BuilderStudent.Builder.newInstance()
                        .setId(2)
                        .setName("Shyam")
                        .setAddress("Delhi")
                        .build();
            }
        });

        t1.start();
        t2.start();
    }

    public BuilderStudent getStudent()
    {
        return student;
    }
}

// Driver class
public class BuilderDemo {
    public static void main(String args[])
    {
        StudentReceiver sr = new StudentReceiver();
        System.out.println(sr.getStudent());
    }
}