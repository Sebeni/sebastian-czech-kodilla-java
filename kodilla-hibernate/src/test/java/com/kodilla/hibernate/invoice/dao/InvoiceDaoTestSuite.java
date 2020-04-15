package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
    private Product bean;
    private Product spring;
    private Product watch;
    private Invoice firstInvoice;
    private Invoice secondInvoice;
    private Item firstItemFirstInvoice;
    private Item secondItemFirstInvoice;
    private Item firstItemSecondInvoice;
    private Item secondItemSecondInvoice;
    
    
    @Before
    public void init() {
        bean = new Product("bean");
        spring = new Product("spring");
        watch = new Product("watch");

        firstInvoice = new Invoice("01");
        secondInvoice = new Invoice("02");

        firstItemFirstInvoice = new Item(new BigDecimal(10), 100, new BigDecimal(1000), bean, firstInvoice);
        firstItemFirstInvoice.addToProductAndInvoice();


        secondItemFirstInvoice = new Item(new BigDecimal(20), 200, new BigDecimal(4000), spring, firstInvoice);
        secondItemFirstInvoice.addToProductAndInvoice();

        firstItemSecondInvoice = new Item(new BigDecimal(30), 300, new BigDecimal(9000), watch, secondInvoice);
        firstItemSecondInvoice.addToProductAndInvoice();

        secondItemSecondInvoice = new Item(new BigDecimal(40), 400, new BigDecimal(16000), spring, secondInvoice);
        secondItemSecondInvoice.addToProductAndInvoice();

        itemDao.save(firstItemFirstInvoice);
        itemDao.save(secondItemFirstInvoice);
        itemDao.save(firstItemSecondInvoice);
        itemDao.save(secondItemSecondInvoice);
    }
    
    @After
    public void tearDown(){
//        itemDao.deleteAll();
    }


    @Test
    public void testInvoiceDaoSave() {
        int firstInvoiceId = firstInvoice.getId();
        int secondInvoiceId = secondInvoice.getId();

        Assert.assertNotEquals(0, firstInvoiceId);
        Assert.assertNotEquals(0, secondInvoiceId);


        Optional<Invoice> readFirstInvoice = invoiceDao.findById(firstInvoiceId);
        Optional<Invoice> readSecondInvoice = invoiceDao.findById(secondInvoiceId);

        Assert.assertTrue(readFirstInvoice.isPresent());
        Assert.assertTrue(readSecondInvoice.isPresent());
    }
    
    @Test
    public void testInvoiceDelete() {
//        System.out.println(firstInvoice.getId());
//        invoiceDao.deleteById(firstInvoice.getId());
    }

    @Test
    public void testFetchType() {
        System.out.println(firstInvoice.getId());
        invoiceDao.findById(firstInvoice.getId());
    }
}
