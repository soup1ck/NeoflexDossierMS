package ru.neoflex.dossier.service.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.neoflex.dossier.data.enums.Theme;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class EmailSendStrategyFactory {

    private Map<Theme, EmailSendStrategy> strategies;

    @Autowired
    public EmailSendStrategyFactory(Set<EmailSendStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public EmailSendStrategy findStrategy(Theme theme) {
        return strategies.get(theme);
    }

    /**
     * @param strategySet - set для реализации паттерна стратегия, для отправки сообщений
     * в strategySet кладется hashMap с ключом Theme и значением EmailSendStrategy, отнаследованных от данного
     * интерфейса
     */
    private void createStrategy(Set<EmailSendStrategy> strategySet) {
        strategies = new HashMap<>();
        strategySet.forEach(
                strategy -> strategies.put(strategy.getTheme(), strategy));
    }
}
