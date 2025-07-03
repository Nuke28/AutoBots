package com.autobots.BankApp;

import com.autobots.Client;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Client> clients = new HashMap<>();
    public static void main(String[] args) {

        Client asan = new Client("Asan Uson","123");

        DepositAccount asanDepositAccount = new DepositAccount(asan,Currency.USD);
        CreditAccount asanCreditAccount = new CreditAccount(asan,Currency.EUR);

        asan.addAccount(asanDepositAccount);
        asan.addAccount(asanCreditAccount);

        System.out.println(asan.getClientId());

        clients.put(asan.getClientId(),asan);

        System.out.println("=======Welcome to Mbank======");
        System.out.print("Please enter client ID");
        String clientID = scanner.nextLine();
        Client client = clients.get(clientID);
        if(client == null){
            System.out.println("client was not found");
            return;
        }
        System.out.println("Please enter pin code");
        String pinCode = scanner.nextLine();
        if(!client.authenticate(pinCode)){
            System.out.println("You entered wrong pin code!");
            return;
        }
        System.out.println(client.getFullName() + " welcome to Mbank");
        while (true){
            System.out.println("1. Посмотреть счета");
            System.out.println("2. Перевести между счетами");
            System.out.println("3. Показать чек");
            System.out.println("0. Выход из системы");
        }

    }
    private static BankAccount findAccount(String accountNumber){
        for(Client client : clients.values()){
            for (BankAccount bankAccount : client.getAccounts()){
                if(bankAccount.getAccountNumber().equals(accountNumber)){
                    return bankAccount;
                }
            }
        }
        return null;
    }
}
