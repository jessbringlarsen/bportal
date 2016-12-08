package dk.bringlarsen.bportal.api.controller;

import dk.bringlarsen.bportal.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Collection;

@BasePathAwareController
public class ImportController {

    private ImportService importService;

    @Autowired
    public ImportController(ImportService importService) {
        this.importService = importService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/import")
    public DeferredResult<ResponseEntity<?>> doImport() {
        DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();

        ListenableFuture<Collection<String>> collectionFuture = importService.doImport();
        collectionFuture.addCallback(
                success -> deferredResult.setResult(ResponseEntity.ok("request processed ok!")),
                failure -> {
                    // Log ex
                    deferredResult.setErrorResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR));
                });

        // TODO: Return link to status page for import instead
        return deferredResult;
    }
}
