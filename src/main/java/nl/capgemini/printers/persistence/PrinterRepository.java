package nl.capgemini.printers.persistence;

import nl.capgemini.printers.model.Printer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PrinterRepository {

    private static long counter = 0;

    List<Printer> content = new ArrayList<>();

    public List<Printer> findAll() {
        return this.content;
    }

    public Printer save(Printer printer) {
       printer.setId(++counter);

       this.content.add(printer);

       return printer;
    }

    public Optional<Printer> findById(long id) {
        for(Printer printer : content) {

            if(id == printer.getId()) {
                return Optional.of(printer);
            }
        }

        return Optional.empty();
    }

    public Optional<Printer> updateById(long id, Printer input) {

        Optional<Printer> optionalPrinter = this.findById(id);
        if(optionalPrinter.isPresent()) {
            Printer target = optionalPrinter.get();
            target.setType(input.getType());
            target.setPrice(input.getPrice());
        }

        return optionalPrinter;
    }

    public boolean deleteById(long id) {
        Optional<Printer> optionalPrinter = this.findById(id);
        if(optionalPrinter.isPresent()) {
            this.content.remove(optionalPrinter.get());
            return true;
        }
        else {
            return false;
        }
    }
}
