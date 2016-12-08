package dk.bringlarsen.bportal.service;

import org.springframework.util.concurrent.ListenableFuture;

import java.util.Collection;

public interface ImportService {
    ListenableFuture<Collection<String>> doImport();
}
