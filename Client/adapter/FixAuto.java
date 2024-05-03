package adapter;

public interface FixAuto {
    public String fix();
    public void exceptionLog(String fileName, String errMsg, int errNo);
}