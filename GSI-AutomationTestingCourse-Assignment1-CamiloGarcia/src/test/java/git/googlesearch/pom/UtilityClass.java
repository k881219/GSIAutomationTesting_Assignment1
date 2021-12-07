package git.googlesearch.pom;

public class UtilityClass {
    private String expectedURL;
    private String actualURL;

    public UtilityClass() {
    }

    public UtilityClass(String expectedURL, String actualURL) {
        this.expectedURL = expectedURL;
        this.actualURL = actualURL;
    }

    public String getExpectedURL() {
        return expectedURL;
    }

    public void setExpectedURL(String expectedURL) {
        this.expectedURL = expectedURL;
    }

    public String getActualURL() {
        return actualURL;
    }

    public void setActualURL(String actualURL) {
        this.actualURL = actualURL;
    }
}
