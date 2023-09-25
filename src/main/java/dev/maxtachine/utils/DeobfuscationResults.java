package dev.maxtachine.utils;

public class DeobfuscationResults {
    private String type;
    private String webhook;
    private String pyinstallerVersion;
    private String pythonVersion;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }

    public String getPyinstallerVersion() {
        return pyinstallerVersion;
    }

    public void setPyinstallerVersion(String pyinstallerVersion) {
        this.pyinstallerVersion = pyinstallerVersion;
    }

    public String getPythonVersion() {
        return pythonVersion;
    }

    public void setPythonVersion(String pythonVersion) {
        this.pythonVersion = pythonVersion;
    }
}