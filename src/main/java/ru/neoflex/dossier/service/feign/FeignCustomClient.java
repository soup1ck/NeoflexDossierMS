package ru.neoflex.dossier.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import ru.neoflex.dossier.data.dto.Application;

@FeignClient(value = "dossier", url = "http://localhost:8081/deal")
public interface FeignCustomClient {

    @PutMapping(value = "/admin/application/{applicationId}/status")
    void updateApplicationStatus(@PathVariable Long applicationId);

    @GetMapping(value = "/admin/application/{applicationId}")
    Application getApplicationById(@PathVariable Long applicationId);
}
