package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
/*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Joe's Computer Shack");
        o.setName("CPU");
        o.setInv(5);
        o.setMinInv(10);
        o.setMaxInv(100);
        o.setPrice(300.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart p= new OutsourcedPart();
        p.setCompanyName("Joe's Computer Shack");
        p.setName("GPU");
        p.setInv(5);
        p.setMinInv(10);
        p.setMaxInv(100);
        p.setPrice(400.0);
        p.setId(101L);
        outsourcedPartRepository.save(p);
        OutsourcedPart q= new OutsourcedPart();
        q.setCompanyName("Joe's Computer Shack");
        q.setName("Memory");
        q.setInv(5);
        q.setMinInv(10);
        q.setMaxInv(100);
        q.setPrice(200.0);
        q.setId(102L);
        outsourcedPartRepository.save(q);
        OutsourcedPart r= new OutsourcedPart();
        r.setCompanyName("Joe's Computer Shack");
        r.setName("SSD");
        r.setInv(5);
        r.setMinInv(10);
        r.setMaxInv(100);
        r.setPrice(150.0);
        r.setId(103L);
        outsourcedPartRepository.save(r);
        OutsourcedPart s= new OutsourcedPart();
        s.setCompanyName("Joe's Computer Shack");
        s.setName("Motherboard");
        s.setInv(5);
        s.setMinInv(10);
        s.setMaxInv(100);
        s.setPrice(350.0);
        s.setId(104L);
        outsourcedPartRepository.save(s);
        OutsourcedPart thePart=null;


        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
*/
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }




/*
        Product desktop= new Product("Desktop",1200.0,15);
        Product laptop= new Product("Laptop",800.0,15);
        Product chromebook= new Product("Chromebook",200.0,15);
        Product macMini= new Product("MacMini",500.0,15);
        Product supercomputer= new Product("Supercomputer",15000.0,15);
        productRepository.save(desktop);
        productRepository.save(laptop);
        productRepository.save(chromebook);
        productRepository.save(macMini);
        productRepository.save(supercomputer);
*/

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
