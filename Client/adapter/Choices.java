package adapter;

public interface Choices {
    public String getOptionChoice(String modelName, String setName);
    public double getOptionChoicePrice(String modelName, String setName);
    public void setOptionChoice(String modelName, String setName, String optName);
    public double getTotalPrice(String modelName);
}
