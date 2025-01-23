package app.web;

import app.transaction.model.Transaction;
import app.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public ModelAndView transactions() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("transactions");

        List<Transaction> allTransactions = transactionService.getAllTransactions();
        modelAndView.addObject("transactions", allTransactions);

        return modelAndView;
    }
}
