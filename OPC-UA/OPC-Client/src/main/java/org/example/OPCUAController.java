package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class OPCUAController {
    @Autowired
    private OPCUAService service;
    @GetMapping("/read-node")
    public String readNode() {
        service.readAndSaveNodeValue();
        return "node has been saved in database";
    }
}
