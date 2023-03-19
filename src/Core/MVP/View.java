package Core.MVP;

public interface View {
    String getName();
    void setName(String name);
    int getAge();
    void setAge(int age);
    String getCommands();
    void addNewCommand(String command);
}
