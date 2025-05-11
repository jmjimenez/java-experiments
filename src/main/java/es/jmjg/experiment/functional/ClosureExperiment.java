package es.jmjg.experiment.functional;

public class ClosureExperiment {

    private final String name;
    private String nickname = "";

    public ClosureExperiment(String name) {
        this.name = name;
    }

    public ClosureExperiment(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public NoArgFunction<NoArgFunction<String>> returnGreeter() {
        return () -> () -> "Hello " + name;
    }

    public NoArgFunction<NoArgFunction<String>> returnGreeterWithNickname() {
        return () -> () -> "Hello " + name + " (" + nickname + ")";
    }

    public NoArgFunction<NoArgFunction<String>> returnGreeterWithOriginalNickname() {
        String originalNickname = nickname;
        return () -> () -> "Hello " + name + " (" + originalNickname + ")";
    }
}
