package com.MindHub.HomeBanking;

import com.MindHub.HomeBanking.models.Account;
import com.MindHub.HomeBanking.models.Client;
import com.MindHub.HomeBanking.models.Transaction;
import com.MindHub.HomeBanking.models.TransactionType;
import com.MindHub.HomeBanking.repositories.AccountRepositories;
import com.MindHub.HomeBanking.repositories.ClienteRepositories;
import com.MindHub.HomeBanking.repositories.TransactionRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class HomeBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeBankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClienteRepositories clienteRepositories , AccountRepositories accountRepositories, TransactionRepositories transactionRepositories){
		return args -> {

			Client client1 = new Client("Melba","Morel","melba@mindhub.com");
			Account cuenta1 =new Account("VIN-00001",LocalDate.now().plusDays(1),5000);
			Account cuenta2 =new Account("VIN-00002",LocalDate.now().plusDays(2),7500);
			clienteRepositories.save(client1);

			client1.addAcount(cuenta1);
			client1.addAcount(cuenta2);

			accountRepositories.save(cuenta1);
			accountRepositories.save(cuenta2);

			Transaction transaction1 = new Transaction(TransactionType.CREDIT,6000,"Credit", LocalDateTime.now());
			Transaction transaction2 = new Transaction(TransactionType.DEBIT,3000,"Debit", LocalDateTime.now());
			Transaction transaction3 = new Transaction(TransactionType.CREDIT,2000,"Credit", LocalDateTime.now());
			cuenta1.addTransaction(transaction1);
			cuenta1.addTransaction(transaction2);
			cuenta1.addTransaction(transaction3);
			transactionRepositories.save(transaction1);
			transactionRepositories.save(transaction2);
			transactionRepositories.save(transaction3);


			System.out.println(client1);
			System.out.println(cuenta1);
			System.out.println(cuenta2);
			System.out.println(transaction1);
			System.out.println(transaction2);
			System.out.println(transaction3);

			Client client2 = new Client("Jorge","Sanchez","jorge@mindHun.com");
			Account cuenta3 =new Account("VIN-00003",LocalDate.now().plusDays(3),7700);

			clienteRepositories.save(client2);

			client2.addAcount(cuenta3);

			accountRepositories.save(cuenta3);

			System.out.println(client2);
			System.out.println(cuenta3);

		};
	}
}
