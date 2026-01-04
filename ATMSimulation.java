package com.example.atm;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/atm")
public class AtmController {

    private double balance = 1000.0;
    private final String correctPin = "1234";
    private List<String> history = new ArrayList<>();

    // 🔐 PIN Check
    @PostMapping("/login/{pin}")
    public String login(@PathVariable String pin) {
        return pin.equals(correctPin)
                ? "Login successful"
                : "Invalid PIN";
    }

    // 💰 Check Balance
    @GetMapping("/balance")
    public String balance() {
        return "Current Balance: $" + balance;
    }

    // ➕ Deposit
    @PostMapping("/deposit/{amount}")
    public String deposit(@PathVariable double amount) {
        if (amount <= 0) return "Invalid amount";
        balance += amount;
        history.add("Deposited: $" + amount);
        return "Deposit successful. New balance: $" + balance;
    }

    // ➖ Withdraw
    @PostMapping("/withdraw/{amount}")
    public String withdraw(@PathVariable double amount) {
        if (amount <= 0) return "Invalid amount";
        if (amount > balance) return "Insufficient funds";
        balance -= amount;
        history.add("Withdrawn: $" + amount);
        return "Withdrawal successful. New balance: $" + balance;
    }

    // 📜 Transaction History
    @GetMapping("/history")
    public List<String> history() {
        return history;
    }
}
