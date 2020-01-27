package nl.capgemini.printers.api;


import nl.capgemini.printers.model.Printer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/printers")
public class PrinterController {


    @GetMapping
    public List<Printer> list() {

        List<Printer> result = new ArrayList<>();

        {
            Printer first = new Printer();
            first.setPrice(250.00);
            first.setType("Poedel");
            result.add(first);
        }
        {
            Printer first = new Printer();
            first.setPrice(450.00);
            first.setType("Crealitty");
            result.add(first);
        }
        {
            Printer first = new Printer();
            first.setPrice(2150.00);
            first.setType("Francien");
            result.add(first);
        }

        return result;

    }


}
