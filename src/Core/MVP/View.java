package Core.MVP;

public interface View {
    String getName();
    void setName(String name);
    int getAge();
    void setAge(int age);
    String getCommand();
    void learnCommand(String command);
}
