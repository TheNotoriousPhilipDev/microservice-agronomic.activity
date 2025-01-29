package org.agomez.backend.msvc.agronomic.activities.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-farm-plot", url = "http://localhost:8003")
public interface FarmPlotRestClient {

    @DeleteMapping("/delete-activity/{id}")
    void deleteFarmPlotActivity(@PathVariable Long id);

}
