package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс BankService предоставляет сервис для управления пользователями и их счетами в банке.
 * Включает методы для добавления и удаления пользователей, добавления счетов,
 * поиска пользователей и счетов по различным критериям, а также для перевода денег между счетами.
 * @author ILYA PETUKHOV
 * @version 1.0
 */
public class BankService {
    /**
     * Коллекция для хранения пользователей и их счетов.
     * Используется HashMap, где ключом является пользователь, а значением - список его счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в систему.
     * Если пользователь уже существует, он не будет добавлен снова.
     * @param user пользователь, которого нужно добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из системы по номеру паспорта.
     * @param passport номер паспорта пользователя, которого нужно удалить
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет новый счет для пользователя.
     * Если пользователь не найден или счет уже существует, счет не будет добавлен.
     * @param passport номер паспорта пользователя, которому нужно добавить счет
     * @param account  счет, который нужно добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     * @param passport номер паспорта пользователя
     * @return найденный пользователь или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет по номеру паспорта пользователя и реквизитам счета.
     * @param passport  номер паспорта пользователя
     * @param requisite реквизиты счета
     * @return найденный счет или null, если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод переводит деньги с одного счета на другой.
     * Проверяет, существуют ли счета и достаточно ли средств на исходном счете.
     * @param sourcePassport      номер паспорта пользователя-отправителя
     * @param sourceRequisite     реквизиты счета-отправителя
     * @param destinationPassport номер паспорта пользователя-получателя
     * @param destinationRequisite реквизиты счета-получателя
     * @param amount              сумма перевода
     * @return true, если перевод выполнен успешно, иначе false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает список счетов пользователя.
     * @param user пользователь, чьи счета нужно получить
     * @return список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
