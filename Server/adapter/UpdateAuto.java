package adapter;

public interface UpdateAuto {
    public void updateOptionSetName(String modelName, String optionSetname, String newName);
    public void updateOptionPrice(String modelName, String optionName, String option, double newPrice);
}
