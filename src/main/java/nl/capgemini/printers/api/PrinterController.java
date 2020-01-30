package nl.capgemini.printers.api;


import nl.capgemini.printers.model.Printer;
import nl.capgemini.printers.persistence.PrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/printers")
public class PrinterController {


    @Autowired
    private PrinterRepository repository;


    @GetMapping
    public List<Printer> list() {
        return this.repository.findAll();
    }



    @PostMapping
    public Printer create(@RequestBody  Printer printer) { // here, the default constructor is invoked.

        return this.repository.save(printer);

    }



    @GetMapping("{id}")
    public ResponseEntity<Printer> findById(@PathVariable long id) {

        Optional<Printer> optionalPrinter = this.repository.findById(id);

        if(optionalPrinter.isPresent()) {
            Printer printertje = optionalPrinter.get();
            return  ResponseEntity.ok(printertje);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Printer> updateById(@PathVariable long id, @RequestBody Printer input) {
        for(Printer printer : content) {

            if(id == printer.getId()) {
                printer.setPrice(input.getPrice());
                printer.setType(input.getType());

                return ResponseEntity.ok(printer);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Printer> deleteById(@PathVariable long id) {
        for(Printer printer : content) {

            if(id == printer.getId()) {
                // NB: You have to override equals and hashCode in Printer to do this correctly!!!
                this.content.remove(printer);

                // this below, will fail is the equals and hashCode is not overwritten.
                // I left it here for learning purposes
                /*
                Printer victim = new Printer();
                victim.setId(3);
                this.content.remove(victim);
                */


                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    public void demo(Printer p) {
        this.content.remove(p);
    }






    // this methods start when the spring boot application starts
    @PostConstruct
    public void init() {
        {
            Printer first = new Printer(++counter);
            first.setPrice(250.00);
            first.setType("Poedel");
            content.add(first);
        }
        {
            Printer first = new Printer(++counter);
            first.setPrice(450.00);
            first.setType("Crealitty");
            content.add(first);
        }
        {
            Printer first = new Printer(++counter);
            first.setPrice(2150.00);
            first.setType("Francien");
            content.add(first);
        }
    }
}
