package dk.bringlarsen.dbtu.rating.common.model;

import java.time.LocalDate;

public class Version {

    private LocalDate version;

    public Version(LocalDate version) {
        this.version = version;
    }

    public LocalDate getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Version{" +
                "version=" + version +
                '}';
    }
}
