package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest

public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;
    
    @Autowired
    ItemDao itemDao;
    
    @Autowired
    ProductDao productDao;
    
    @Test
    public void testInvoiceDaoSave() {
        Product bean = new Product("bean");
        Product spring = new Product("spring");
        Product watch = new Product("watch");

//        productDao.save(bean);
//        productDao.save(spring);
//        productDao.save(watch);
       
        
        Invoice firstInvoice = new Invoice("01");
        Invoice secondInvoice = new Invoice("02");

//        invoiceDao.save(firstInvoice);
//        invoiceDao.save(secondInvoice);
//        
        Item firstItemFirstInvoice = new Item(new BigDecimal(10), 100, new BigDecimal(1000), bean, firstInvoice);
        firstItemFirstInvoice.addToProductAndInvoice();


        Item secondItemFirstInvoice = new Item(new BigDecimal(20), 200, new BigDecimal(4000), spring, firstInvoice);
        secondItemFirstInvoice.addToProductAndInvoice();

        Item firstItemSecondInvoice = new Item(new BigDecimal(30), 300, new BigDecimal(9000), watch, secondInvoice);
        firstItemSecondInvoice.addToProductAndInvoice();

        Item secondItemSecondInvoice = new Item(new BigDecimal(40), 400, new BigDecimal(16000), spring, secondInvoice);
        secondItemSecondInvoice.addToProductAndInvoice();

        itemDao.save(firstItemFirstInvoice);
        itemDao.save(secondItemFirstInvoice);
        itemDao.save(firstItemSecondInvoice);
        itemDao.save(secondItemSecondInvoice);
        

        int firstInvoiceId = firstInvoice.getId();
        int secondInvoiceId = secondInvoice.getId();

        Assert.assertNotEquals(0, firstInvoiceId);
        Assert.assertNotEquals(0, secondInvoiceId);


        Optional<Invoice> readFirstInvoice = invoiceDao.findById(firstInvoiceId);
        Optional<Invoice> readSecondInvoice = invoiceDao.findById(secondInvoiceId);

        Assert.assertTrue(readFirstInvoice.isPresent());
        Assert.assertTrue(readSecondInvoice.isPresent());


//        invoiceDao.deleteById(firstInvoiceId);
//        invoiceDao.deleteById(secondInvoiceId);
        
    }
    
}
